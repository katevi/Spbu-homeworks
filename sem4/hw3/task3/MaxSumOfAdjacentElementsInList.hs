module MaxSumOfAdjacentElementsInList where

computeFirstWithMaxSum :: [Integer] -> Integer
computeFirstWithMaxSum ls = computeFirstWithMaxSum' ls 0 0 0 0 0 where
        computeFirstWithMaxSum' :: [Integer] -> Integer -> Integer -> Integer -> Integer -> Integer -> Integer
        computeFirstWithMaxSum' [] first second max maxPosition counter = maxPosition
        computeFirstWithMaxSum' (x : xs) first second max maxPosition counter | x + second >= max = 
                                                                              computeFirstWithMaxSum' xs second x (second + x) counter (counter + 1)
                                                                              | x + second < max = 
                                                                              computeFirstWithMaxSum' xs second x max maxPosition (counter + 1)



