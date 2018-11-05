#include "list.h"
#include "Polynomial.h"
#include <iostream>


int lengthOfNumber(int number)
{
	if ((number == 0) || (number == 1))
		return 0;
	int length = 0;
	int temp = number;
	while (temp > 0)
	{
		length++;
		temp = temp / 10;
	}
	return length;
}

void printWithoutDegrees(Polynomial *polynomial)
{
	elementOfPolynomial *current = polynomial->first;
	if (lengthOfNumber(polynomial->first->coefficient))
	{
		if (polynomial->first->sign == '+')
		{
			std::cout << polynomial->first->coefficient << "x ";
		}
		else
		{
			std::cout << polynomial->first->sign << polynomial->first->coefficient << "x ";
		}
	}
	else
	{
		if (polynomial->first->sign == '-')
		{
			std::cout << polynomial->first->sign << "x ";
		}
		else
		{
			std::cout << "x ";
		}
	}

	while (current->next)
	{
		current = current->next;
		if ((current->degree == 0) && (current->coefficient != 0))
			std::cout <<current->sign << current->coefficient;
		else
		{
			if ((current->coefficient != 0) && (current->coefficient != 1))
			{
				std::cout << current->sign << current->coefficient << "x ";
			}
			if (current->coefficient == 1)
			{
				std::cout << current->sign << "x ";
			}
		}
	}
}

void printDegrees(Polynomial *polynomial)
{
	elementOfPolynomial *current = polynomial->first;
	for (int i = 0; i <= lengthOfNumber(polynomial->first->coefficient); i++)
		{
			std::cout << " ";
		}
	if (polynomial->first->sign == '-')
		std::cout << " ";
	std::cout << polynomial->first->degree;

	while (current->next->degree > 1)
	{
		current = current->next;
		if ((current->coefficient != 0))
		{
			for (int i = 0; i <= lengthOfNumber(current->coefficient) + 1; i++)
			{
				std::cout << " ";
			}
			std::cout << current->degree;
		}
	
	}
	std::cout << "\n";
}

