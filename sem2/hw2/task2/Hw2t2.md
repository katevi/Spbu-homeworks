# Implementation of stack-based calculator


*Solution contains*:

* **LinkedStack** class, which implements Stack

* **ArrayStack** class, which implements Stack

* interface **Stack**

* calculator that calculates simple arithmetic expressions such "5+3-4*2" (using only digits)

(**LinkedStack** and **ArrayStack** implements simple single-linked stack and stack, based on array).

## Calculator

**Constructor**:

Uses two stacks - stack for operations (**private <Character> operations**) and for digits (**private <Float> result**) (as result of expression may not be an integer).

**public String input()**: the method used to enter an expression by the user. (uses java.util.Scanner).

**private String convertToPostfix(String expression)**
 : the entered expression is converted to the Postfix form (reverse Polish notation). The algorithm of conversion can be found here [(http://natalia.appmat.ru/c%26c%2B%2B/postfisso.html)] and here [http://library.kiwix.org/wikipedia_ru_all_nopic_2018-07/A/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D1%81%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BE%D1%87%D0%BD%D0%BE%D0%B9_%D1%81%D1%82%D0%B0%D0%BD%D1%86%D0%B8%D0%B8.html]. You can check the correctness of the conversion to the Postfix form by following the link [(http://primat.org/news/obratnaja_polskaja_zapis/2016-04-09-1181)]. Method returns expression, converted to postfix form (**stringExpressionInPostfix**). Important: this string - is string with length = 100, the end of the Postfix form is indicated by a sign # (actual length of postfix form - length of expression before #).

**private int lengthOfPostfixForm(String stringExpressionInPostfix)**: returns the actual length of the Postfix form obtained in the method convertToPostfix (**lengthOfPostfixForm**).

**private char[] removeTabsFromPostfixForm(String stringExpressionInPostfixForm)** : outputs a string whose non-empty part (up to #) matches the string of the Postfix form (**finalString**).

 **private Float calculateResultFromPostfix(String stringExpressionInPostfix)**
: By the string obtained in the method **convertToPostfix**, calculates the original arithmetic expression, returns Float type. The calculation algorithm can be found here [https://habr.com/ru/post/100869/].

**private Float operate(Float a, Float b, char operator)**: the method applies an arithmetic operation to two given numbers according to the given operator and returns the result.

 **public Float calculate(String expression)**: using previous methods, returns the value of the entered expression.