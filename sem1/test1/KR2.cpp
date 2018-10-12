#include <iostream>
#include <ctime>

void sortInsert(int array[], int lengthOfArray)
{
	int temp = 0; 
	int previousElementIndex = 0; 
	for (int counter = 1; counter < lengthOfArray; counter++)
	{
		temp = array[counter]; 
		previousElementIndex = counter - 1;
		while (previousElementIndex >= 0 && array[previousElementIndex] > temp) 
		{
			array[previousElementIndex + 1] = array[previousElementIndex]; 
			array[previousElementIndex] = temp;
			previousElementIndex--;
		}
	}
}

void inputArray(int array[], int length)
{
	for (int i = 0; i < length; i++)
		std::cin >> array[i];
}

void inputArrayRandom(int array[], int length)
{
	srand((unsigned int)time(NULL));
	for (int i = 0; i < length; i++)
	{
		array[i] = rand() % (42 - 11 + 1) + 11;
	}
}


int main()
{
	int length = 0;
	int method = 0;
	std::cout << "Choose array fill method ( 1 = manually, 2 = random):";
	std::cin >> method;
	std::cout << "Enter length of array:";
	std::cin >> length;


	int *numbers = new int[length] {0};

	if (method == 1)
	{
		std::cout << "Enter cells of array:";
		inputArray(numbers, length);
	}
	if (method == 2)
		inputArrayRandom(numbers, length);

	std::cout << "Start array:";
	for (int i = 0; i < length; i++)
		std::cout << numbers[i] << " ";

	int lengthOfEven = 0;
	if (length % 2 == 1)
	lengthOfEven = length / 2 + 1;
	if (length % 2 == 0)
	lengthOfEven = length / 2;

	int *evenNumbers = new int[lengthOfEven] {0};
	int k = 0;
	for (int i = 0; i < length; i++)
	if (i % 2 == 0)
	{
		evenNumbers[k] = numbers[i];
		k++;
	}

	sortInsert(evenNumbers, lengthOfEven);

	k = 0;
	std::cout << "\n";
	std::cout << "Finish array:";
	if ((method == 1) or (method == 2))
		for (int i = 0; i < length; i++)
		{
			if (i % 2 == 1)
				std::cout << numbers[i] << " ";
			if (i % 2 == 0)
			{
				std::cout << evenNumbers[k] << " ";
				k++;
			}
		}

	delete[] numbers;
	delete[] evenNumbers;
	system("pause");
}