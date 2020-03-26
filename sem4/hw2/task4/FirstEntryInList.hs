module FirstEntryList where

computeFirstEntry :: [Integer] -> Integer -> Integer
computeFirstEntry xs n = helper xs 0 where
        helper :: [Integer] -> Integer -> Integer
        helper [] _ = 0
        helper (x : xs) counter | (x == n) = counter
                                | otherwise = helper xs (counter + 1)