module MaxSumOfAdjacentElementsInList where

{-|Iinitially assume that maximum is equal to the sum of the first two numbers (not 0) from list in order to take case of negative numbers|-}
computeFirstWithMaxSum :: [Integer] -> Integer
computeFirstWithMaxSum (x1 : []) = error "List must have length >= 2 to have adjacent elements"
computeFirstWithMaxSum (x1 : x2 : xs) = computeFirstWithMaxSum' xs x1 x2 (x1 + x2) 1 2 where
        computeFirstWithMaxSum' :: [Integer] -> Integer -> Integer -> Integer -> Integer -> Integer -> Integer
        computeFirstWithMaxSum' [] first second max maxPosition counter = maxPosition
        computeFirstWithMaxSum' (x : xs) first second max maxPosition counter | x + second >= max = 
                                                                              computeFirstWithMaxSum' xs second x (second + x) counter (counter + 1)
                                                                              | x + second < max = 
                                                                              computeFirstWithMaxSum' xs second x max maxPosition (counter + 1)



