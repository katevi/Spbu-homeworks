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

int main()
{
	int const constHiddenNumber = 7593;
	int hiddenNumber = constHiddenNumber;
	int currentNumber = 0;
	int digitsHiddenNumber[4]{ 0 };
	int digitsCurrentNumber[4]{ 0 };
	numberToArray(digitsHiddenNumber, hiddenNumber);
	int bull = 0;
	int cow = 0;
	int count = 1;

	std::cout << "A (bull) - means your number has a number that is the original number and is in the same place as the original number \n";
	std::cout << "B (cow) - means your number has a number that is the original number, but is not in the same place as the original number \n";
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