module LocalMax where

findLocalMax :: Ord a => [a] -> Maybe a
findLocalMax xs = (\l -> if (null l) then Nothing else Just (head l)) 
        (zip3 (drop 1 xs) xs (drop 2 xs) >>= (\(x, y, z) -> if (x > y && x > z) then [x] else []))