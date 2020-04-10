module FilterList where

filterList :: (Eq a, Ord a) => (a -> Bool) -> [a] -> [a]
filterList condition xs  = filterList' xs [] where
        filterList' [] ys = reverse ys
        filterList' (x : xs) ys | (condition x) = filterList' xs (x : ys)
                                | otherwise = filterList' xs ys
                                
test = (filterList (\t -> (t > 5)) [1,2,3,10] == [10]) &&
       (filterList (\t -> (mod t 2 == 0)) [1,2,3,10] == [2, 10]) &&
       (filterList (\t -> (t ^ 3 >= 27)) [9,8,3,0,3,2,1] == [9,8,3,3])
