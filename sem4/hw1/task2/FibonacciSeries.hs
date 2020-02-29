module FibonacciSeries where

fibonacci 0 = 0
fibonacci 1 = 1
fibonacci n | n > 0 = fibonacci (n - 2) + fibonacci (n - 1)
            | n < 0 = fibonacci (n + 2) - fibonacci (n + 1)