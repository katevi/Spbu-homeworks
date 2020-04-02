module LocalMax where

import Control.Monad.Zip

findLocalMax :: Ord a => [a] -> Maybe a
findLocalMax xs = (\l -> if (null l) then Nothing else Just (head l)) 
        (mzip3 (drop 1 xs) xs (drop 2 xs) >>= (\(x, y, z) -> if (x > y && x > z) then [x] else []))

mzip3 xs ys zs = mzipWith (\x (y, z) -> (x, y, z)) xs (mzip ys zs)