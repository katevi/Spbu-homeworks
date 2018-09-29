#include <iostream>

int min(int a, int b)
{
	if (a < b)
		return a;
	if (a >= b)
		return b;
}

int terms[50];
void waysToOutput(int number, int upperBound, int numberOfCell)
{
	int i = 0;
	if (number > 0)
	{
		for (i = 1; i <= upperBound; i++)
		{
			terms[numberOfCell] = i;
			waysToOutput(number - i, min(i, number - i), numberOfCell + 1);
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
	waysToOutput(number, number - 1, 0);
}
