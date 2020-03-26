module ListsSum where

sumThreeLists :: Num a => [a] -> [a] -> [a] -> [a]
sumThreeLists xs ys zs = sumTwoLists xs (sumTwoLists ys zs) where
                sumTwoLists :: Num a => [a] -> [a] -> [a]
                sumTwoLists a b = sumElements a b [] where
                        sumElements [] [] result = reverse result
                        sumElements (x : xs) [] result = sumElements xs [] (x : result)
                        sumElements [] (y : ys) result = sumElements [] ys (y : result)
                        sumElements (x : xs) (y : ys) result = sumElements xs ys ((x + y) : result)