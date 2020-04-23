module CornerList where
import Control.Monad

mapDraft :: Int -> [Int] -> [Int]
mapDraft i xs = map (\t -> if t < i then i else t) xs

returnCornerList :: Int -> [[Int]]
returnCornerList n = returnCornerList' 0 [] where
                returnCornerList' :: Int -> [[Int]] -> [[Int]]
                returnCornerList' counter xs | (counter == n) = reverse xs
                                             | otherwise = returnCornerList' (counter + 1) ((mapDraft (counter + 1) (take n [1..])) : xs)

--Helper function for printing result
printCornerList :: Int -> IO()
printCornerList n = forM_ (returnCornerList n) (\t -> print t)

test = (returnCornerList 4 == [[1,2,3,4],[2,2,3,4],[3,3,3,4],[4,4,4,4]])