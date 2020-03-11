module ListReverse where

reverseList :: [xs] -> [xs]
reverseList [] = []
reverseList n = helper [] n where
        helper :: [xs] -> [xs] -> [xs]
        helper y [] = y
        helper y (x : xs) = helper (x : y) xs