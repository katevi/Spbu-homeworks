#include <iostream>
#include "list.h"
#include "Polynomial.h"

int main()
{
	int number = 0;
	std::cout << "Enter the maximum degree <> 0 of x:";
	std::cin >> number;
	if (number == 0)
		std::cout << "It's not a polynomial!";
	else
	{
		int *arrayOfCoefficients = new int[number + 1];
		std::cout << "Enter the coefficients of the polynomial from x:";
		Polynomial *polynomial = createList();
		char sign = ' ';
		for (int i = number; i >= 0; i--)
		{
			std::cin >> arrayOfCoefficients[i];
			if (arrayOfCoefficients[i] >= 0)
				sign = '+';
			else
			{
				sign = '-';
			}
			add(polynomial, i, abs(arrayOfCoefficients[i]), sign);
		}
		std::cout << "Polynomial:\n";
		printDegrees(polynomial);
		printWithoutDegrees(polynomial);
		deleteList(polynomial);
		delete[] arrayOfCoefficients;
	}
}