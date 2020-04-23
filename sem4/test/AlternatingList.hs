module AlternatingList where


generateModulusOneList :: [Integer]
generateModulusOneList = 1 : (-1) : generateModulusOneList

generateAlternatingIntegers :: [Integer]
generateAlternatingIntegers = zipWith (*) [1..] generateModulusOneList