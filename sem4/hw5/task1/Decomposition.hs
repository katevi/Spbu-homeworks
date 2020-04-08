module Decomposition where

decompose :: Int -> [[Int]]
decompose x = decompose' x x where
    decompose' 0 _ = [[]]
    decompose' x y | x < y     = decompose' x x
                   | otherwise = concatMap (\i -> map (\j -> i : j) (decompose' (x - i) i)) [1, 2..y]
