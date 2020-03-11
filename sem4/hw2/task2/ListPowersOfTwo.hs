module ListPowersOfTwo where

createList :: Integer -> [Integer]
createList n | (n < 0) = error "Power of 2 must be positive or 0" 
             | otherwise = helper [] 1 0 where
                helper :: [Integer] -> Integer -> Integer -> [Integer]
                helper xs twoPower counter |(counter == n + 1) = reverse xs
                                           | otherwise = helper (twoPower : xs) (twoPower * 2) (counter + 1)