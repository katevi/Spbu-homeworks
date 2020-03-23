module AmountOfEvenNumbersInList where

--the first way computation amount of even numbers in list
countEvenNumbersFilter :: [Int] -> Int
countEvenNumbersFilter xs = length $ filter even xs

--the second way computation amount of even numbers in list
countEvenNumbersMap :: [Int] -> Int
countEvenNumbersMap xs = sum $ map (\x -> if even x then 1 else 0) xs

--the third way computation amount of even numbers in list
countEvenNumbersFoldr :: [Int] -> Int
countEvenNumbersFoldr = foldr (\x acc -> if even x then (acc + 1) else acc) 0

