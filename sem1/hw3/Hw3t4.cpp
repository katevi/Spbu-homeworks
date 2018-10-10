#include <iostream>
#include <cstdlib>

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
					arrayCurrent[i] = -1;
				}
			}
		}

}

int main()
{
	srand(time(NULL));
	const int constHiddenNumber = rand() % (9999 - 1000 + 1) + 1000;
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
			std::cout << "You lose!" << "Hidden number =" << constHiddenNumber;
		}
	}
	if (count <= 10)
		std::cout << "You win!";
}