import Control.Monad.State
import Data.List

data Graph v = Graph [(Int,v)] [(Int,Int,Int)] deriving (Show)
data Cost v = Cost (v, Int) deriving (Show)

vertex (Cost a) = fst a
distance (Cost a) = snd a

from (v, u, w)    = v
to (v, u, w)      = u
weight (v, u, w)  = w

getDistance :: [Cost Int] -> Int -> Int
getDistance costs v = distance $ head $ filter ((== v) . vertex) costs

updateWeights :: [(Int, Int, Int)] -> [Cost Int] -> [Cost Int]
updateWeights [] costs = costs
updateWeights (x : xs) costs | ((getDistance costs (from x)) + (weight x) <= (getDistance costs (to x))) = 
                                updateWeights xs $ (Cost (to x, getDistance costs (from x) + (weight x))) : (filter ((/= (to x)) . vertex) costs)
                             | ((getDistance costs (to x)) + (weight x) <= (getDistance costs (from x))) = 
                                updateWeights xs $ (Cost (from x, getDistance costs (to x) + (weight x))) : (filter ((/= (from x)) . vertex) costs)
                             | otherwise = updateWeights xs costs

initializeCosts :: Int -> [(Int,v)] -> [Cost Int]
initializeCosts start vertexes = [if x == start then Cost (x, 0) else Cost (x, 100000) | x <- map fst vertexes]

dijkstra' :: Graph v -> [Cost Int] -> (State [Int] [Cost Int])
dijkstra' (Graph vertexes edges) costs = do {
        state <- get;
        if null state
                then return costs
                else do 
                        let v = minimumBy (\a b -> compare (getDistance costs a) $ getDistance costs b) state
                        put (filter (/= v) state)
                        dijkstra' (Graph vertexes edges) $ updateWeights (filter (\e -> (from e == v || (to e) == v)) edges) costs
        }

dijkstra :: Graph v -> Int -> [Cost Int]
dijkstra (Graph vertexes edges) start = evalState (dijkstra' (Graph vertexes edges) $ initializeCosts start vertexes) (map fst vertexes)
        
--tests
graph1 = Graph [(1, 1), (2, 2), (3, 3), (4, 4)] [(1, 2, 6), (1, 3, 2), (3, 4, 1), (2, 3, 10)]
graph2 = Graph [(1, 1), (2, 2), (3, 3), (4, 4), (5, 5)] [(1, 3, 4), (1, 4, 6), (1, 5, 7), (2, 3, 8), (2, 5, 5), (3, 4, 3)]

test1 = dijkstra graph2 1 
--[Cost (2,12),Cost (5,7),Cost (4,6),Cost (3,4),Cost (1,0)]

test2 = dijkstra graph2 2
--[Cost (1,12),Cost (4,11),Cost (3,8),Cost (5,5),Cost (2,0)]

test3 = dijkstra graph1 2
--[Cost (4,9),Cost (3,8),Cost (1,6),Cost (2,0)]
