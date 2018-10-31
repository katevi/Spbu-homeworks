#include <iostream>
#include "Stack.h"

void writePriority1Operand(Stack* stack, char array[], int i)
{
	if ((getLastElement(stack) == '+') || (getLastElement(stack) == '-') || (getLastElement(stack) == '(') || (isEmpty(stack)))
		push(stack, array[i]);
	else
	{
		std::cout << pop(stack) << " ";
		push(stack, array[i]);
	}
}

void writePriority2Operand(Stack* stack, char array[], int i)
{
	if (isEmpty(stack))
		push(stack, array[i]);
	else
	{
		while ((getLastElement(stack) != '(') && (!isEmpty(stack)))
			std::cout << pop(stack) << " ";
		push(stack, array[i]);
	}
}

int main()
{
	char expression[100]{ ' ' };
	std::cout << "Enter expression:\n";
	std::cin >> expression;
	Stack* stack = createStack();
	std::cout << "Reverse polish notation:\n";
	for (int i = 0; i < strlen(expression); i++)
	{
		if ((int(expression[i]) > 47) && (int(expression[i]) < 58))
			std::cout << expression[i] << " ";
		else
		{
			if ((expression[i] == '+') || (expression[i] == '-'))
				writePriority2Operand(stack, expression, i);
			if ((expression[i] == '*') || (expression[i] == '/'))
				writePriority1Operand(stack, expression, i);
			if (expression[i] == '(')
				push(stack, expression[i]);
			if (expression[i] == ')')
			{
				while (getLastElement(stack) != '(')
					std::cout << pop(stack) << " ";
				pop(stack);
			}
		}
	}
	while (!isEmpty(stack))
		std::cout << pop(stack) << " ";
	deleteStack(stack);
	system("pause");
}