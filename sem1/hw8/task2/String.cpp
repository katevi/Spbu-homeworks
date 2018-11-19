#include "String.h"
#include <cstring>
#include <iostream>

String* createString(char* currentString)
{
	String* newString = new String;
	newString->length = strlen(currentString);
	newString->string = new char[newString->length + 1];
	newString->string[newString->length] = '\0';
	strcpy(newString->string, currentString);
	return newString;
}

void deleteString(String *& string)
{
	delete[] string;
}

void concatenate(String* string, String* stringToAdd)
{
	int previousLength = string->length;
	string->length = string->length + stringToAdd->length;
	char* previousString = new char[previousLength + 1];
	previousString = string->string;
	string->string = new char[string->length + 1];
	for (int i = 0; i < previousLength; i++)
	{
		string->string[i] = previousString[i];
	}
	int j = 0;
	for (int i = previousLength; i < string->length; i++)
	{
		string->string[i] = stringToAdd->string[j];
		j++;
	}
	string->string[string->length] = '\0';
}

String* clone(String* string)
{
	String* stringCopy = new String {string->string, string->length};
	return stringCopy;
}

bool isEmpty(String* string)
{
	return !(string->length);
}

int length(String* string)
{
	return string->length;
}

void stringComparison(String* string1, String* string2)
{
	if (string1->length < string2->length)
		std::cout << string1->string << " < " << string2->string << "\n\n";
	if (string1->length > string2->length)
		std::cout << string1->string << " > " << string2->string << "\n\n";
	if ((string1->length == string2->length))
	{
		int i = 0;
		for (i = 0; i < string1->length; i++)
			if (string1->string[i] != string2->string[i])
			{
				std::cout << string1->string << " != " << string2->string << "\n\n";
				break;
			}
		if (i == string1->length)
			std::cout << string1->string << " = " << string2->string << "\n\n";
	}
}

String* createSubstring(String* baseString, int firstPosition, int lastPosition)
{
	int j = 0;
	char* charSubstring = new char[lastPosition - firstPosition + 2];
	for (int i  = firstPosition; i <= lastPosition; i++)
	{
		charSubstring[j] = baseString->string[i];
		j++;
	}
	charSubstring[j] = '\0';
	String* substring = new String {charSubstring, lastPosition - firstPosition + 1};
	return substring;
}

char* convertToChar(String* string)
{
	char* stringChar = new char[string->length];
	stringChar = string->string;
	return stringChar;
}