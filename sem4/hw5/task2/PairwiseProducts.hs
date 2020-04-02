module PairwiseProducts where

computeProducts :: Int -> [Int]
computeProducts n = [1..n] >>= \s -> [1..n] >>= \z -> return (s * z)
   
