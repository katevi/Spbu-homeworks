import System.Random

data BinaryTree a = Null | Node (BinaryTree a) a (BinaryTree a)
        deriving Show

--Insert part
insert :: (Ord a) => a -> BinaryTree a -> BinaryTree a
insert x Null = Node Null x Null
insert x (Node left value right) | x == value = Node left value right
                                 | x > value = Node left value (insert x right)
                                 | x < value = Node (insert x left) value right 
             
--Remove part             
remove :: (Ord a) => a -> BinaryTree a -> BinaryTree a
remove x Null = Null
remove x (Node left value right) | x == value = removeRoot (Node left value right)
                                 | x > value = Node left value (remove x right)
                                 | x < value = Node (remove x left) value right
                                
removeRoot :: BinaryTree a -> BinaryTree a
removeRoot (Node Null _ Null) = Null
removeRoot (Node Null _ right) = right
removeRoot (Node left _ Null) = left
removeRoot (Node left _ right) = Node (removeMaxLeftElement left) (findMaxElement left) right

findMaxElement :: BinaryTree a -> a
findMaxElement (Node _ value Null) = value
findMaxElement (Node _ _ right) = findMaxElement right

removeMaxLeftElement :: BinaryTree a -> BinaryTree a
removeMaxLeftElement (Node left _ Null) = left
removeMaxLeftElement (Node left value right) = Node left value (removeMaxLeftElement right)

--Size part
size :: BinaryTree a -> Int
size Null = 0
size (Node left _ right) = 1 + (size left) + (size right)

--Height part
height :: BinaryTree a -> Int
height Null = 0
height (Node left _ right) = 1 + max (height left) (height right)

--Search
contains :: (Ord a) => a -> BinaryTree a -> Bool
contains x Null = False
contains x (Node left value right) | x == value = True
                                   | x > value = contains x right
                                   | x < value = contains x left

--Randomize all elements in tree
randomize :: (Random a, Num a) =>  BinaryTree a -> IO (BinaryTree a)
randomize Null = return Null
randomize (Node left value right) = do {
        value <- randomRIO (1,100);
        left <- randomize left;
        right <- randomize right;
        return (Node left value right)
        }

--Insert tests
insertTree = Node (Null) 4 (Null)
insertTest1 = insert 5 insertTree
insertTest2 = insert 3 insertTest1
insertTest3 = insert 35 insertTest2

--Remove tests
removeTree = Node (Node (Node Null 3 Null) 5 (Node Null 6 Null)) 8 (Node (Node (Node Null 10 Null) 12 Null) 13 Null)
removeTree1 = remove 6 removeTree
removeTree2 = remove 8 removeTree
removeTree3 = remove 12 removeTree

sizeTest = (size removeTree == 7) && (size removeTree1 == 6) && (size insertTest3 == 4)

heightTest = (height removeTree == 4) && (height insertTest3 == 3)

searchTest = (contains 5 removeTree == True) && (contains 14 removeTree == False) && (contains 3 insertTest3 == True)

