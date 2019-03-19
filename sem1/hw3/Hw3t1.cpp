#include <iostream>

int main()
{
	int lengthOfArray = 0;
	std::cout << "Enter the length of array:";
	std::cin >> lengthOfArray;
	int *numbers = new int[lengthOfArray];
	std::cout << "Enter the value of cells of array:";
	for (int i = 0; i < lengthOfArray; i++)
		std::cin >> numbers[i];

	int maxCurrent = 0;
	int count = 0;
	int maxTemporary = 0;
	for (int i = 0; i < lengthOfArray; i++)
	{
		if ((numbers[i] > maxCurrent) && (numbers[i] == maxTemporary) && (count >= 2))
		{
			maxCurrent = maxTemporary;
			maxCurrent = numbers[i];
			count = 0;
		}
		if (numbers[i] > maxTemporary)
		{
			maxTemporary = numbers[i];
			count = 1;
		}
		if (numbers[i] == maxTemporary)
			count++;
	}

	delete[] numbers;
	std::cout << "Maximum of array that occur more than two times: " << maxCurrent;
}