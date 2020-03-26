module SumDigits where

sumDigits :: Integer -> Integer
sumDigits 0 = 0
sumDigits n = sum where
        sum = helper 0 (abs n)
        helper :: Integer -> Integer -> Integer
        helper sumAccumulator n | (div n 10 == 0) = sumAccumulator + n
                                | (div n 10 > 0) = helper (sumAccumulator + mod n 10) (div n 10)
      
