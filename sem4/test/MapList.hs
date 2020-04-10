module MapList where

supermap :: (a -> [b]) -> [a] -> [b]
supermap x ys = supermap' ys [[]] where
        supermap' [] zs = reverse $ concat zs
        supermap' (w : ws) zs = supermap' ws $ (reverse $ x w) : zs
        

test = (supermap (\t -> [t^2, t + 1])  [1,2,3]) == [1,2,4,3,9,4] &&
       (supermap (\t -> [t + 2, t + 3]) [2,3,4]) == [4,5,5,6,6,7] &&
       (supermap (\t -> [t + 1, t + 2, t + 3, t + 4]) [1]) == [2,3,4,5] &&
       (supermap (\t -> [sin (pi * t)]) [1/2, 0]) == [1.0, 0.0]