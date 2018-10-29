#include <iostream>
#include <cstdlib>
#include <ctime>

void numberToArray(int array[], int number)
{
	for (int i = 0; i < 4; i++)
	{
		array[i] = number % 10;
		number = number / 10;
	}
}


void findingBull(int arrayHidden[], int arrayCurrent[], int &bull)
{
	for (int i = 0; i < 4; i++)
		if (arrayCurrent[i] == arrayHidden[i])
		{
			bull++;
		}
}

void findingCow(int arrayHidden[], int arrayCurrent[], int &cow)
{
	for (int i = 0; i < 4; i++)
		for (int j = 0; j < 4; j++)
		{
			if (i != j)
			{
				if (arrayCurrent[i] == arrayHidden[j])
				{
					cow++;
				}
			}
		}

}

void generatingOfHiddenNumber(int arrayOfDigits[], int &number)
{
	bool isDifferent = false;
	for (int i = 1; i < 4; i++)
	{
		isDifferent = false;
		while (!isDifferent)
		{
			isDifferent = true;
			arrayOfDigits[i] = rand() % 9 + 0;
			for (int j = 0; j < i; j++)
			{
				if (arrayOfDigits[j] == arrayOfDigits[i])
					isDifferent = false;
			}
		}
	}
	number = arrayOfDigits[3] + arrayOfDigits[2] * 10 + arrayOfDigits[1] * 100 + arrayOfDigits[0] * 1000;
}

int main()
{
	srand(time(NULL));
	int digitsHiddenNumber[4] {-1};
	digitsHiddenNumber[0] = rand() % 9 + 1;
	int constHiddenNumber = 0;
	generatingOfHiddenNumber(digitsHiddenNumber, constHiddenNumber);
	int hiddenNumber = constHiddenNumber;
	int currentNumber = 0;
	int digitsCurrentNumber[4] {0};
	int bull = 0;
	int cow = 0;
	int count = 1;
	std::cout << "A (bull) - your number has the same number and same place \n";
	std::cout << "B (cow) - your number has the same number, but not on the same place \n";
	std::cout << "You have ten attempts to guess the hidden number. Enter numbers...\n";
	while (!((bull == 4) && (cow == 0)))
	{
		if (count <= 10)
		{
			bull = 0;
			cow = 0;
			hiddenNumber = constHiddenNumber;
			numberToArray(digitsHiddenNumber, hiddenNumber);
			std::cout << count << ". Entered number:";
			std::cin >> currentNumber;
			numberToArray(digitsCurrentNumber, currentNumber);
			findingBull(digitsHiddenNumber, digitsCurrentNumber, bull);
			findingCow(digitsHiddenNumber, digitsCurrentNumber, cow);
			std::cout << "Result: " << bull << "A" << cow << "B\n";
			count++;
		}
		if (count > 10)
		{
			bull = 4;
			cow = 0;
			std::cout << "You lose!" << "Hidden number =" << constHiddenNumber;
		}
	}
	if (count <= 10)
		std::cout << "You win!";
}