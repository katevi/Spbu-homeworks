module CorrectBracketSequence where

checkIfSequenceCorrect :: [Char] -> Bool
checkIfSequenceCorrect xs = checkIfSequenceCorrect' xs [] True where
        isOpeningBracket :: Char -> Bool
        isOpeningBracket x = x == '(' || x == '{' || x == '['
        
        isClosingBracket :: Char -> Bool
        isClosingBracket x = x == ')' || x == '}' || x == ']'
        
        checkIfSequenceCorrect' :: [Char] -> [Char] -> Bool -> Bool
        checkIfSequenceCorrect' xs bracketStack False = False
        checkIfSequenceCorrect' [] bracketStack result = length bracketStack == 0 && result
        checkIfSequenceCorrect' (x : xs) [] result | isClosingBracket x = False
                                                   | isOpeningBracket x = checkIfSequenceCorrect' xs (x : []) result
                                                   | otherwise = error "Sequence must have only brackets {} [] ()"
      
        checkIfSequenceCorrect' (x : xs) (s : bracketStack) result | x == ')' = checkIfSequenceCorrect' xs bracketStack (result && s == '(')
                                                                   | x == '}' = checkIfSequenceCorrect' xs bracketStack (result && s == '{')
                                                                   | x == ']' = checkIfSequenceCorrect' xs bracketStack (result && s == '[')
                                                                   | isOpeningBracket x = checkIfSequenceCorrect' xs (x : s : bracketStack) result
                                                                   | otherwise = error "Sequence must have only brackets {} [] ()"
