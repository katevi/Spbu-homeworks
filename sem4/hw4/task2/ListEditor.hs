module ListEditor where

import System.IO

main = do
    doLoop []

adder :: [Int] -> Int -> [Int]
adder [] y = y : []
adder (x : xs) y | (y < x) = y : x : xs
                 | (y >= x) = adder' xs y (x : []) where
                        adder' :: [Int] -> Int -> [Int] -> [Int]
                        adder' [] y ys = reverse (y : ys)
                        adder' (x1 : []) y ys | (x1 > y) = reverse (x1 : y : ys)
                                              | (x1 <= y) = reverse (y : x1 : ys)
                        adder' (x1 : x2 : xs) y ys | (x1 < y && x2 > y) = reverse (x2 : y : x1 : ys) ++ xs
                                                   | (y <= x1) = reverse (x2 : x1 : y : ys) ++ xs
                                                   | (y >= x2) = adder' (x2 : xs) y (x1 : ys)
                                                   
remover :: [Int] -> Int -> [Int]
remover [] y = []
remover xs y | not (elem y xs) = xs
             | elem y xs = filter (\x -> (x - y) /= 0) xs

doLoop :: [Int] -> IO ()
doLoop elements = do
    putStrLn "Enter a command 1,2,3 or 0 to quit:"
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
        _ -> doLoop elements        
        