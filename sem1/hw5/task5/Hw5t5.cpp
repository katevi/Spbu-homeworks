#include <iostream>
#include "StackChar.h"
#include <string>
#include "StackFloat.h"

void writePriority1Operand(StackChar* stack, std::string array, int i, std::string &finalString)
{
	if ((getLastElementChar(stack) == '+') || (getLastElementChar(stack) == '-') || (getLastElementChar(stack) == '(') || (isEmptyChar(stack)))
		pushChar(stack, array[i]);
	else
	{
		finalString = finalString + popChar(stack);
		pushChar(stack, array[i]);
	}
}

void writePriority2Operand(StackChar* stack, std::string array, int i, std::string &finalString)
{
	if (isEmptyChar(stack))
		pushChar(stack, array[i]);
	else
	{
		while ((getLastElementChar(stack) != '(') && (!isEmptyChar(stack)))
			finalString = finalString + popChar(stack);
		pushChar(stack, array[i]);
	}
}


std::string fromExpressionToPostfix()
{
	std::string expression;
	std::string finalString;
	std::cout << "Enter expression:\n";
	std::getline(std::cin, expression);
	StackChar* stack = createStackChar();
	std::cout << "Reverse polish notation:\n";
	int lengthOfExpression = expression.length();
	for (int i = 0; i < lengthOfExpression; i++)
	{
		if ((int(expression[i]) > 47) && (int(expression[i]) < 58))
			finalString = finalString + expression[i];
		else
		{
			if ((expression[i] == '+') || (expression[i] == '-'))
			{
				writePriority2Operand(stack, expression, i, finalString);
			}
			if ((expression[i] == '*') || (expression[i] == '/'))
			{
				writePriority1Operand(stack, expression, i, finalString);
			}
			if (expression[i] == '(')
			{
				pushChar(stack, expression[i]);
			}
			if (expression[i] == ')')
			{
				while (getLastElementChar(stack) != '(')
					finalString = finalString + popChar(stack);
				popChar(stack);
			}
		}
	}
	while (!isEmptyChar(stack))
	{
		finalString = finalString + popChar(stack);
	}
	std::cout << finalString;
	deleteStackChar(stack);
	return finalString;
}

void fromPostfixToAnswer(std::string finalString)
{
	StackFloat* stackOfNumbers = createStackFloat();
	int lengthOfPostfixForm = finalString.length();
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
				pushFloat(stackOfNumbers, -popFloat(stackOfNumbers));
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

int main()
{
	std::string finalString;
	finalString = fromExpressionToPostfix();
	fromPostfixToAnswer(finalString);
}