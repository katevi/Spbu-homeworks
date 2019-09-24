# Implementation of simple hash table

*Solution contains*
* **HashFunctionSum class** - implements hash function (The cycle passes through the string, the i-th element is multiplied by i).
* **HashFunctionPolynom** - implements polynomial hash function, algorithm can be found here [http://www.e-maxx-ru.1gb.ru/algo/string_hashes].
* **HashFunction** - interface for two previous hash functions
* **List class** - simple single-linked list
* **ListHashTable** - simple hash table with collisition resolution through separate chaining by **List**
* **Main** class, which implements communication with user
* **input.txt** - file from which the table reads information

Also there are tests for hash table, list and hash functions and ListIsEmptyException, which used in the delete element from list (cannot delete an element from an empty list) and print (cannot print an empty list).