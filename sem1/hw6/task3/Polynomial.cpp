#include "list.h"
#include "Polynomial.h"
#include <iostream>


int lengthOfNumber(int number)
{
	if ((number == 0) || (number == 1))
	{
		return 0;
	}
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
	bool isFirst = true;
	while (current)
	{
		if (current->degree == 0)
		{
			if (current->coefficient != 0)
			{
				std::cout << current->sign << current->coefficient;
			}
		}
		else
		{
			if (isFirst)
			{
				if (current->coefficient == 1)
				{
					if (current->sign == '-')
					{
						std::cout << "-x";
					}
					else
					{
						std::cout << "x";
					}
				}
				else
				{
					if (current->sign == '-')
					{
						std::cout << "-" << current->coefficient << "x";
					}
					else
					{
						std::cout << current->coefficient << "x";
					}
				}
				isFirst = false;
			}
			else
			{
				if (current->coefficient != 0)
				{
					if (current->coefficient == 1)
					{
						if (current->sign == '-')
						{
							std::cout << "-x";
						}
						else
						{
							std::cout << "+x";
						}
					}
					else
					{
						if (current->sign == '-')
						{
							std::cout << "-" << current->coefficient << "x";
						}
						else
						{
							std::cout << "+" << current->coefficient << "x";
						}
					}
				}
			}
		}
		if (current->coefficient >= 1)
		{
			for (int i = 0; i < lengthOfNumber(current->degree); i++)
			{
				std::cout << " ";
			}
		}
		current = current->next;
	}
}

void printDegrees(Polynomial *polynomial)
{
	elementOfPolynomial *current = polynomial->first;
	bool isFirst = true;
	while (current->degree > 1)
	{
		if (current->coefficient != 0)
		{
			if (isFirst)
			{
				if ((lengthOfNumber(current->coefficient) == 0))
				{
					if (current->sign == '-')
					{
						for (int i = 0; i < 2; i++)
						{
							std::cout << " ";
						}
					}
					else
					{
						std::cout << " ";
					}
				}
				else
				{
					if (current->sign == '-')
					{
						for (int i = 0; i < lengthOfNumber(current->coefficient) + 2; i++)
						{
							std::cout << " ";
						}
					}
					else
					{
						for (int i = 0; i < lengthOfNumber(current->coefficient) + 1; i++)
						{
							std::cout << " ";
						}
					}
				}
				std::cout << current->degree;
				isFirst = false;
			}
			else
			{
				if ((lengthOfNumber(current->coefficient) == 0))
				{
					for (int i = 0; i < 2; i++)
					{
						std::cout << " ";
					}
				}
				else
				{
					for (int i = 0; i < lengthOfNumber(current->coefficient) + 2; i++)
					{
						std::cout << " ";
					}
				}
				std::cout << current->degree;
			}
		}
		current = current->next;
	}
	std::cout << "\n";
}

