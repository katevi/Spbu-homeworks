#include <iostream>

void numberToArray(int array[], int number)
{
	for (int i = 0; i < 4; i++)
	{
		array[i] = number % 10;
		number = number / 10;
	}
}

void findingA(int arrayHidden[], int arrayCurrent[], int &A)
{
	for (int i = 0; i < 4; i++)
		if (arrayCurrent[i] == arrayHidden[i])
		{
			A++;
			arrayCurrent[i] = -1;
			arrayHidden[i] = -2;
		}
}

void findingB(int arrayHidden[], int arrayCurrent[], int &B)
{
	for (int i = 0; i < 4; i++)
		for (int j = 0; j < 4; j++)
		{
			if (i != j)
			{
				if (arrayCurrent[i] == arrayHidden[j])
				{
					B++;
					arrayHidden[j] = -2;
				}
			}
		}

}

int main()
{
	const int constHiddenNumber = 1402;
	int hiddenNumber = constHiddenNumber;
	int currentNumber = 0;
	int digitsHiddenNumber[4]{ 0 };
	int digitsCurrentNumber[4]{ 0 };
	numberToArray(digitsHiddenNumber, hiddenNumber);
	int A = 0;
	int B = 0;
	int count = 1;

	std::cout << "You have ten attempts to guess the hidden number. Enter numbers...\n";
	while (not((A == 4) and (B == 0)))
	{
		if (count <= 10)
		{
			A = 0;
			B = 0;
			hiddenNumber = constHiddenNumber;
			numberToArray(digitsHiddenNumber, hiddenNumber);
			std::cout << count << ". Entered number:";
			std::cin >> currentNumber;
			numberToArray(digitsCurrentNumber, currentNumber);
			findingA(digitsHiddenNumber, digitsCurrentNumber, A);
			findingB(digitsHiddenNumber, digitsCurrentNumber, B);
			std::cout << "Result: " << A << "A" << B << "B\n";
			count++;
		}
		if (count > 10)
		{
			A = 4;
			B = 0;
			std::cout << "You lose!";
		}
	}
	if (count <= 10)
		std::cout << "You win!";
}