#include <iostream>
#include "Stack.h"

int main()
{
	char postfixForm[100];
	std::cout << "Enter postfix form (without tabs): ";
	std::cin >> postfixForm;
	Stack* stackOfNumbers = createStack();
	int lengthOfPostfixForm = strlen(postfixForm);
	float a = 0;
	float b = 0;
	float c = 0;
	int countOfNumbers = 0;
	for (int i = 0; i < lengthOfPostfixForm; i++)
	{
		if ((float(postfixForm[i]) > 47) && (float(postfixForm[i]) < 58))
		{
			countOfNumbers++;
			push(stackOfNumbers, float(postfixForm[i]) - 48);
		}
		else
		{
			if ((postfixForm[i] == '-') && (countOfNumbers == 1))
				push(stackOfNumbers, -pop(stackOfNumbers));
			else
			{
				a = pop(stackOfNumbers);
				b = pop(stackOfNumbers);
				switch (postfixForm[i])
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
				push(stackOfNumbers, c);
			}
		}
	}
	std::cout << "Value of this expression = " << pop(stackOfNumbers);
	delete(stackOfNumbers);
	system("pause");
}