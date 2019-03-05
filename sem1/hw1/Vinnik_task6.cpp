#include <iostream>
#include <cstring>

void arrayToEnter(char a[256], char text[])
{
	std::cout << text;
	for (int count; count < 256; count++)
		a[count] = ' ';
	std::cin >> a;
}

int main()
{
	char mainString[256]; char subString[256];
	arrayToEnter(mainString, "Enter the string:");
	arrayToEnter(subString, "Enter the substring:");
	int lengthSubString = strlen(subString);
	int lengthMainString = strlen(mainString);
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