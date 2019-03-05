#include <iostream>

int checkPrime(int divCurrent, int iCurrent, int numArrayCurrent)
{
	if ((divCurrent < iCurrent) and (numArrayCurrent % divCurrent == 0))
		numArrayCurrent = 0;
	return numArrayCurrent;
}

int main()
{
	std::cout << "Enter number ";
	int number = 0;
	std::cin >> number;

	int i = 0;
	int sequenceNumbers[1000]; /*длина массива = количество членов натурального ряда от 1 до заданного простого числа*/
	for (int i = 1; i <= number; i++)
		sequenceNumbers[i] = i;

	int primeDiv = 2;

	while (primeDiv <= number)
	{
		while (sequenceNumbers[primeDiv] == 0)
		{
			primeDiv = primeDiv + 1;
		}
		for (int i = primeDiv; i <= number; i++)
		{
			sequenceNumbers[i] = checkPrime(primeDiv, i, sequenceNumbers[i]);
		}
		primeDiv = primeDiv + 1;
	}

	if (number == 0)
		std::cout << "Prime divisions doesn't exists ";

	if (number != 0)
		for (int i = 2; i <= number; i++)
			if (sequenceNumbers[i] != 0)
				std::cout << sequenceNumbers[i] << " ";
}