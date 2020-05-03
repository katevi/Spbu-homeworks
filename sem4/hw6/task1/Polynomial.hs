module Polynomial where

data Polynomial = Polynomial[Int]

instance Num Polynomial where
        (+) (Polynomial p) (Polynomial q) = Polynomial (zipWith2 (+) p q)
        (-) (Polynomial p) (Polynomial q) = Polynomial (zipWith2 (-) p q)
        (*) (Polynomial p) (Polynomial q) = Polynomial (multiplePolynomials p q)
        abs (Polynomial p) = Polynomial (map abs p)
        negate (Polynomial p) = Polynomial (map negate p)
        fromInteger = error "No such functionality"
        signum = error "No such functionality"
        
        
zipWith2 :: (a -> a -> a) -> [a] -> [a] -> [a]    
zipWith2 operation a b = zipWith2' operation a b [] where
        zipWith2' operation [] [] result = reverse result
        zipWith2' operation (x : xs) [] result = zipWith2' operation xs [] (x : result)
        zipWith2' operation [] (y : ys) result = zipWith2' operation [] ys (y : result)
        zipWith2' operation (x : xs) (y : ys) result = zipWith2' operation xs ys ((operation x y) : result)        

multiplePolynomials :: [Int] -> [Int] -> [Int]
multiplePolynomials []       _  = [0]
multiplePolynomials _       []  = [0]
multiplePolynomials xs (y : []) = map (* y) xs
multiplePolynomials (y : []) xs = map (* y) xs
multiplePolynomials (x : xs) ys = zipWith2 (+) (map (* x) ys) (0 : (multiplePolynomials xs ys))

instance Show Polynomial where
        show (Polynomial []) = ""
        show (Polynomial (x : xs))      | xs == [] = show x
                                        | x == 0 = show (Polynomial xs)
                                        | all (== 0) xs && (x == 1) = "x" ++ degree xs
                                        | all (== 0) xs && (x /= 1) = show x ++ "x" ++ degree xs
                                        | x == 1 = "x" ++ degree xs ++ "+" ++ show (Polynomial xs)
                                        | otherwise = show x ++ "x" ++ degree xs ++ "+" ++ show (Polynomial xs)

degree :: [Int] -> [Char]
degree xs | length xs == 1 = ""
          | otherwise = "^" ++ show (length xs)

test = (show (Polynomial [1,2,3,0,(-5)] * Polynomial [2,3,4]) == "2x^6+7x^5+16x^4+17x^3+2x^2+-15x+-20") &&
       (show (Polynomial [1,2,3] + Polynomial [2,3,4]) == "3x^2+5x+7") &&
       (show (Polynomial [0]) == "0") && (show (Polynomial []) == "") &&
       (show (Polynomial [1,2,3,0,(-5)] * Polynomial [1]) == "x^4+2x^3+3x^2+-5") &&
       (show (Polynomial [1,0,0,0] * Polynomial [0,0,0,1]) == "x^3") &&
       (show (Polynomial [1,0,0,0] * Polynomial [1,0,0,0]) == "x^6") &&
       (show (abs (Polynomial [(-1),(-2),3])) == "x^2+2x+3") &&
       (show (negate (Polynomial [(-1),(-2),3])) == "x^2+2x+-3")
       
       
       
