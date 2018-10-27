#include <iostream>
#include "Stack.h"
#include <string>

void writePriority1Operand(Stack* stack, std::string array, int i, std::string &finalString)
{
	if ((getLastElement(stack) == '+') || (getLastElement(stack) == '-') || (getLastElement(stack) == '(') || (isEmpty(stack)))
		push(stack, array[i]);
	else
	{
		finalString = finalString + pop(stack);
		push(stack, array[i]);
	}
}

void writePriority2Operand(Stack* stack, std::string array, int i, std::string &finalString)
{
	if (isEmpty(stack))
		push(stack, array[i]);
	else
	{
		while ((getLastElement(stack) != '(') && (!isEmpty(stack)))
			finalString = finalString + pop(stack);
		push(stack, array[i]);
	}
}

int main()
{
	std::string expression;
	std::string finalString;
	std::cout << "Enter expression:\n";
	std::getline(std::cin, expression);
	Stack* stack = createStack();
	std::cout << "Reverse polish notation:\n";
	int lengthOfExpression = expression.length();
	for (int i = 0; i < lengthOfExpression; i++)
	{
		if ((int(expression[i]) > 47) && (int(expression[i]) < 58))
			finalString = finalString + expression[i];
		else
		{
			if ((expression[i] == '+') || (expression[i] == '-'))
				writePriority2Operand(stack, expression, i, finalString);
			if ((expression[i] == '*') || (expression[i] == '/'))
				writePriority1Operand(stack, expression, i, finalString);
			if (expression[i] == '(')
				push(stack, expression[i]);
			if (expression[i] == ')')
			{
				while (getLastElement(stack) != '(')
					finalString = finalString + pop(stack);
				pop(stack);
			}
		}
	}
	while (!isEmpty(stack))
		finalString = finalString + pop(stack);
	std::cout << finalString;
	deleteStack(stack);
}
