module Factorial where

factorial :: Int -> Int
factorial 0 = 1
factorial n | n > 0 = n * factorial (n - 1)
            | otherwise = error "Argument must be positive or 0"