# Implementation of the parse tree of the arithmetic expression


*Solution contains*:

 

* **ExpressionTree** class, which implements the essence of task, works with **Operator**:

	* **getRoot** - causes **getOperator** from the tree root.

    	* **getOperator** - parses the string into tree (the algorithm is based on the fact that after each bracket there is an operand, and then - two of its arguments. The operand is the root of the subtree and the numbers are its leafs. The method runs recursively from the left and right subtrees.)
    
	* **getNumber** - converts string like "1234" to int number
    
	* **calculate** - recursively calculates the expression, starts from tree root.
  
 

* **Operand** interface, which is  unifying entity for signs: +, -, /, * and numbers: 1, 2, 22 etc.
:
	* **Number** implements **Operandr** = numbers
    
	* **Operator** implements **Operand** = signs, from which extended classes:
        
		* **Multiplication** = "*" (multiplies the left and the right leaf)
        
		* **Division** = "/" (divides the left by the right leaf)
        
		* **Addition** = "+" (adds the left to the right leaf)
        
		* **Substraction** = "-" (multiplies the left and right leaf)



Also solution contains test expression and check that the tree was correctly read from the string (**ExpressionTreeTest**) and input file "**expression.txt**".