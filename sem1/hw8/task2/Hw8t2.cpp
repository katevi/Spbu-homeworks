#include <iostream>
#include "String.h"

int main()
{
	std::cout << "Strings:\n";
	std::cout << "It's first string\n";
	std::cout << "It's second string\n\n";

	char example1[] = "It's first string";
	char example2[] = "It's second string";
	String* string1 = createString(example1);
	String* string2 = createString(example2);

	std::cout << "Concatenated - added string2 to the end of the string1:\n";
	concatenate(string1, string2);
	std::cout << string1->string << "\n\n";

	std::cout << "Made a clone of the resulting string1:\n";
	String* copyString1 = clone(string1);
	std::cout << "Length:" << copyString1->length << " String:" << copyString1->string << "\n\n";

	if (isEmpty(string1))
		std::cout << "String1 is empty\n\n";
	else std::cout << "String1 is not empty\n\n";

	int lengthOfString1 = length(string1);
	std::cout << "Length of string1 by function:" << lengthOfString1 << "\n\n";

	std::cout << "Result of comparison: " << stringComparison(string1, string2) <<"\n";

	char* charString = convertToChar(string1);
	std::cout << "String converterted to char:" << charString << "\n\n";

	String* substring = createSubstring(string1, 0, 11);
	std::cout << "Substring:" << substring->string << "\n\n";

	deleteString(copyString1);
	deleteString(substring);
	deleteString(string1);
	deleteString(string2);
}