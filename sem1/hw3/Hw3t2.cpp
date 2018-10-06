#include <iostream>
#include <cstring>

void countingLetters(int array[], char *string, int lengthString)
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
	std::cout << "Enter first string:";
	char *string1 = new char;
	std::cin >> string1;

	std::cout << "Enter second string:";
	char *string2 = new char;
	std::cin >> string2;

	if (strlen(string1) == strlen(string2))
	{
		int array1[numberOfCodes] = {0};
		int array2[numberOfCodes] = {0};

		int lengthString1 = strlen(string1);
		int lengthString2 = strlen(string2);
		countingLetters(array1, string1, lengthString1);
		countingLetters(array2, string2, lengthString2);

		bool isSame = true;
		for (int i = 0; i < numberOfCodes; i++)
			if (array2[i] != array1[i])
				isSame = false;

		if (isSame == true)
			std::cout << "It is possible to make the second line from the first";
		else std::cout << "It is impossible to make the second line from the first";

	}
	else
		std::cout << "It is impossible to make the second line from the first";
	delete[] string1;
	delete[] string2;
}
