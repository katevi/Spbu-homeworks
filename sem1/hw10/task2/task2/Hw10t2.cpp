#include <iostream>
#include "String.h"

int const prime = 7;
int const intSize = 2147483647;

int hash(String* string)
{
	int result = 0;
	for (int i = string->length - 1; i >= 0; i--)
	{
		result = (result * prime % intSize + int(string->string[i])) % intSize;
	}
	return result;
}

void inputLength(int &lengthString, int &lengthSubstring)
{
	std::cout << "Enter the length of string:\n";
	std::cin >> lengthString;
	std::cout << "Enter the length of substring:\n";
	std::cin >> lengthSubstring;
}

void inputStrings(char* stringChar, char* substringChar)
{
	std::cout << "Enter string:\n";
	std::cin >> stringChar;
	std::cout << "Enter substring:\n";
	std::cin >> substringChar;
}

int main()
{
	int lengthString = 0;
	int lengthSubstring = 0;

	inputLength(lengthString, lengthSubstring);
	char* stringChar = new char[lengthString + 1];
	char* substringChar = new char[lengthSubstring + 1];
	inputStrings(stringChar, substringChar);

	String* string = createString(stringChar);
	String* substring = createString(substringChar);

	int hashSubstring = hash(substring);

	std::cout << "First indices of all occurrences of a substring in a string:\n";
	String* currentString = substring;
	int currentHash = 0;
	for (int i = lengthSubstring - 1; i < lengthString; i++)
	{
		for (int k = i; k >= i - substring->length + 1; k--)
		{
			currentHash = ((currentHash * prime) % intSize + (int)(string->string[k])) % intSize;
		}
		if (currentHash == hashSubstring)
		{
			currentString = createSubstring(string, i - substring->length + 1, i);
			if (isSame(currentString, substring))
				std::cout << i - substring->length + 1 << " ";
		}
		currentHash = 0;
	}
	
	deleteString(currentString);
	deleteString(string);
	deleteString(substring);
}