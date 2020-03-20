module ReductionToPointFreeStyle where

{-| 
Given: func x l = map (\y -> y * x) l
1. We know, that type of the standard library function "map" is (a -> b) -> [a] -> [b] . 
   So, if func x l = map ... and (\y -> y * x) is operation (=> x is not list => l - is list), we do not need in writing l as argument:
   func x = map (\y -> y * x)
2. Operation (\y -> y * x) means, that each element of list is multiplied by x, consequently, we can replace it with this (* x)        
   func x = map (* x)
3. Since we know, that x - is not list, we can write map (* x) as composition :
   func = map . (*)
   Where (*) is applies to x, and after passes as operation in map first argument.
|-}
func :: Num a => a -> [a] -> [a] 
func = map . (*)