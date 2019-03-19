#include <iostream>
#include <cstring>

void countingLetters(int array[], char string[], int lengthString)
{
	for (int i = 0; i < lengthString; i++)
	{
		int k = (int)string[i];
		array[k]++;
	}
}

int main()
{
	int const numberOfCodes = 127;
	std::cout << "Enter length of first string:";
	int lengthString1 = 0;
	std::cin >> lengthString1;
	std::cout << "Enter first string:";
	char *string1 = new char[lengthString1];
	std::cin >> string1;

	std::cout << "Enter length of second string:";
	int lengthString2 = 0;
	std::cin >> lengthString2;
	std::cout << "Enter second string:";
	char *string2 = new char[lengthString2];
	std::cin >> string2;

	if (lengthString2 == lengthString1)
	{
		int array1[numberOfCodes] = {0};
		int array2[numberOfCodes] = {0};

		countingLetters(array1, string1, lengthString1);
		countingLetters(array2, string2, lengthString2);

		bool isSame = true;
		for (int i = 0; i < numberOfCodes; i++)
			if (array2[i] != array1[i])
				isSame = false;

		if (isSame)
			std::cout << "It is possible to make the second line from the first";
		else std::cout << "It is impossible to make the second line from the first";

	}
	else
		std::cout << "It is impossible to make the second line from the first";
	delete[] string1;
	delete[] string2;
}
