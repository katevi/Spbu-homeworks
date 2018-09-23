#include <iostream>
#include <cstring>
int main()
{
	std::cout << "Enter main string:";
	char mainString[256];
	for (int i = 0; i < 256; i++)
		mainString[i] = ' ';
	std::cin >> mainString;
	int lengthMainString = strlen(mainString);

	std::cout << "Enter  substring:";
	char subString[256];
	for (int i = 0; i < 256; i++)
		subString[i] = ' ';
	std::cin >> subString;
	int lengthSubString = strlen(subString);

	int sum = 0;
	for (int i = lengthSubString - 1; i < lengthMainString; i++)
	{
		int isConcludes = true;
		int k = lengthSubString - 1;
		for (int j = i; j >= i - lengthSubString + 1; j--)
		{
			if (mainString[j] != subString[k])
				isConcludes = false;
			k--;
		}
		if (isConcludes)
			sum++;
	}

	std::cout << "Number of occurences substring in string =" << sum;
}