import Data.Foldable

data Tree a = Leaf a
            | Branch (Tree a) a (Tree a)

instance Foldable Tree where
    foldr f acc (Leaf value) = f value acc
    foldr f acc (Branch left value right) = foldr f (f value (foldr f acc right)) left

--test tree 1   
tree1 = Branch (Branch (Leaf "e") "a" (Leaf "c")) "b" (Branch (Leaf "f") "c" (Leaf "g"))

--test tree 2
tree2 = Branch (Branch (Branch (Leaf 8) 7 (Leaf 6)) 5 (Branch (Leaf 4) 3 (Leaf 2))) 9 (Leaf 10)

traverseMyTree :: Tree a -> [a]
traverseMyTree tree = foldr (:) [] tree