#include "StackChar.h"
#include "StackFloat.h"

void writePriority1Operand(StackChar* stack, char array[], int i, char finalString[], int &count)
{
	if ((getLastElementChar(stack) == '+') || (getLastElementChar(stack) == '-') || (getLastElementChar(stack) == '(') || (isEmptyChar(stack)))
	{
		pushChar(stack, array[i]);
	}
	else
	{
		finalString[count] = popChar(stack);
		count++;
		pushChar(stack, array[i]);
	}
}

void writePriority2Operand(StackChar* stack, char array[], int i, char finalString[], int &count)
{
	if (isEmptyChar(stack))
	{
		pushChar(stack, array[i]);
	}
	else
	{
		while ((getLastElementChar(stack) != '(') && (!isEmptyChar(stack)))
		{
			finalString[count] = popChar(stack);
			count++;
		}
		pushChar(stack, array[i]);
	}
}


void fromExpressionToPostfix(char finalString[])
{
	char expression[100]{ ' ' };
	std::cout << "Enter expression:\n";
	std::cin >> expression;
	StackChar* stack = createStackChar();
	std::cout << "Reverse polish notation:\n";
	int lengthOfExpression = strlen(expression);
	int count = 0;
	for (int i = 0; i < lengthOfExpression; i++)
	{
		if ((int(expression[i]) > 47) && (int(expression[i]) < 58))
		{
			finalString[count] = expression[i];
			count++;
		}
		else
		{
			if ((expression[i] == '+') || (expression[i] == '-'))
			{
				writePriority2Operand(stack, expression, i, finalString, count);
			}
			if ((expression[i] == '*') || (expression[i] == '/'))
			{
				writePriority1Operand(stack, expression, i, finalString, count);
			}
			if (expression[i] == '(')
			{
				pushChar(stack, expression[i]);
			}
			if (expression[i] == ')')
			{
				while (getLastElementChar(stack) != '(')
				{
					i++;
					finalString[count] = popChar(stack);
					count++;
				}
				popChar(stack);
			}
		}
	}
	while (!isEmptyChar(stack))
	{
		finalString[count] = popChar(stack);
		count++;
	}
	std::cout << finalString;
	deleteStackChar(stack);
}

void fromPostfixToAnswer(char finalString[])
{
	StackFloat* stackOfNumbers = createStackFloat();
	int lengthOfPostfixForm = strlen(finalString);
	float a = 0;
	float b = 0;
	float c = 0;
	int countOfNumbers = 0;
	for (int i = 0; i < lengthOfPostfixForm; i++)
	{
		if ((float(finalString[i]) > 47) && (float(finalString[i]) < 58))
		{
			countOfNumbers++;
			pushFloat(stackOfNumbers, float(finalString[i]) - 48);
		}
		else
		{
			if ((finalString[i] == '-') && (countOfNumbers == 1))
			{
				pushFloat(stackOfNumbers, -popFloat(stackOfNumbers));
			}
			else
			{
				a = popFloat(stackOfNumbers);
				b = popFloat(stackOfNumbers);
				switch (finalString[i])
				{
				case '+':
				{
					c = b + a;
					break;
				}
				case '*':
				{
					c = b * a;
					break;
				}
				case '-':
				{
					c = b - a;
					break;
				}
				case '/':
				{
					c = b / a;
					break;
				}
				}
				pushFloat(stackOfNumbers, c);
			}
		}
	}
	std::cout << "\nValue of this expression = " << popFloat(stackOfNumbers);
	delete(stackOfNumbers);
}