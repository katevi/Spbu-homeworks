module FibonacciSeriesLinear where

fibonacci 0 = 0
fibonacci 1 = 1
fibonacci n | n > 0 = helperLinear 0 1 (n - 2) + helperLinear 0 1 (n - 1)
            | n < 0 = helperLinear 0 1 (n + 2) - helperLinear 0 1 (n + 1)

helperLinear accumulator1 accumulator2 0 = accumulator1
helperLinear accumulator1 accumulator2 n | n > 0 = helperLinear accumulator2 (accumulator1 + accumulator2)  (n - 1)
                                         | n < 0 = helperLinear accumulator2 (accumulator1 - accumulator2)  (n + 1)