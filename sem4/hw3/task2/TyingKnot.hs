module TyingKnot where

series179 :: [Integer]
series179 = 1 : 7 : 9 : concat (map (\t -> [10 * t + 1, 10 * t + 7, 10 * t + 9]) series179)