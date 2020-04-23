module Rhombus where

import Control.Monad

printRhombus :: Int -> IO() 
printRhombus n = do {
        forM_ [1..n] (\t -> do {
                forM_ [1..(n - t)] (\t -> putChar ' ');
                forM_ [1..(2 * t - 1)] (\x -> putChar 'x');
                putStrLn " "
        });
        forM_ [1..n] (\t -> do {
                forM_ [1..t] (\t -> putChar ' ');
                forM_ [1..(2 * (n - t) - 1)] (\x -> putChar 'x');
                putStrLn " "
                })
        }