module ListEditor where

import System.IO

main = do
    doLoop []

adder :: [Int] -> Int -> [Int]
adder [] y = y : []
adder (x : xs) y | (y < x) = y : x : xs
                 | otherwise = x : adder xs y
                                                   
remover :: [Int] -> Int -> [Int]
remover [] y = []
remover xs y | not (elem y xs) = xs
             | elem y xs = filter (\x -> (x /= y) == True) xs

doLoop :: [Int] -> IO ()
doLoop elements = do
    putStr "Enter a command 1 - if you want to add element in list,\n"
    putStr "2 - if you want to remove element from list, \n"
    putStr "3 - if you want to print list, \n0 - if you want to quit.\n"
    command <- getLine
    
    case command of
        '0':_ -> return()
        '1':value -> do
                doLoop (adder elements (read value::Int))
        '2':value -> do
                doLoop (remover elements (read value::Int))
        '3':_ -> do
                print elements
                doLoop elements
        _ -> do
                putStr "Please, enter correct command.\n"
                doLoop elements        
        