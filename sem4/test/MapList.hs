module MapList where

supermap :: [a] -> (a -> [b]) -> [b]
supermap ys x = supermap' ys [[]] where
        supermap' [] zs = reverse $ concat zs
        supermap' (w : ws) zs = supermap' ws $ (reverse $ x w) : zs
        

test = (supermap [1,2,3] (\t -> [t^2, t + 1])) == [1,2,4,3,9,4] &&
       (supermap [2,3,4] (\t -> [t + 2, t + 3])) == [4,5,5,6,6,7] &&
       (supermap [1] (\t -> [t + 1, t + 2, t + 3, t + 4])) == [2,3,4,5] &&
       (supermap [1/2, 0] (\t -> [sin (pi * t)])) == [1.0, 0.0]