#include <iostream>

int min(int a, int b)
{
	if (a < b)
		return a;
	if (a >= b)
		return b;
}

void waysToOutput(int number, int upperBound, int numberOfCell, int terms[])
{
	int i = 0;
	if (number > 0)
	{
		for (i = 1; i <= upperBound; i++)
		{
			terms[numberOfCell] = i;
			waysToOutput(number - i, min(i, number - i), numberOfCell + 1, terms);
		}
	}
	else
	{
		for (i = 0; i < numberOfCell; i++)
		{
			std::cout << terms[i];
			if (i == numberOfCell - 1)
				std::cout << "\n";
			else
				std::cout << " + ";
		}
	}
}

int main()
{
	std::cout << "Enter the number: ";
	int number;
	std::cin >> number;
	int arrayOfTerms[50];
	for (int i = 0; i < 50; i++)
		arrayOfTerms[i] = 0;
	waysToOutput(number, number - 1, 0, arrayOfTerms);
}