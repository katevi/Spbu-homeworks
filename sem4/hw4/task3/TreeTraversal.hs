import Data.Foldable

data Tree a = Leaf a
            | Branch (Tree a) a (Tree a)

instance Foldable Tree where
    foldr f z (Leaf x) = f x z
    foldr f z (Branch l k r) = foldr f (f k (foldr f z r)) l

--test tree 1   
tree1 = Branch (Branch (Leaf "e") "a" (Leaf "c")) "b" (Branch (Leaf "f") "c" (Leaf "g"))

--test tree 2
tree2 = Branch (Branch (Branch (Leaf 8) 7 (Leaf 6)) 5 (Branch (Leaf 4) 3 (Leaf 2))) 9 (Leaf 10)

traverseMyTree :: Tree a -> [a]
traverseMyTree tree = foldr (:) [] tree