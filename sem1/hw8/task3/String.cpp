#define _CRT_SECURE_NO_WARNINGS
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

void deleteString(String *&string)
{
	delete[] string->string;
	delete string;
}

void concatenate(String* baseString, String* addedString)
{
	baseString->length = baseString->length + addedString->length;
	char* concatenatedString = new char[baseString->length + 1];

	strcpy(concatenatedString, baseString->string);
	strcat(concatenatedString, addedString->string);
	concatenatedString[baseString->length] = '\0';

	delete[] baseString->string;
	baseString->string = concatenatedString;
}

String* clone(String* string)
{
	char* newCharString = new char[string->length + 1];
	for (int i = 0; i < string->length; i++)
	{
		newCharString[i] = string->string[i];
	}
	newCharString[string->length] = '\0';
	String* stringCopy = new String {newCharString, string->length};
	return stringCopy;
}

bool isEmpty(String* string)
{
	if (string->length > 0)
	{
		return false;
	}
	else
	{
		return true;
	}
}

int length(String* string)
{
	return string->length;
}

int stringComparison(String* string1, String* string2)
{
	return strcmp(string1->string, string2->string);
}

bool isSame(String* string1, String* string2)
{
	if (string1->length != string2->length)
	{
		return false;
	}
	for (int i = 0; i < string2->length; i++)
	{
		if (string1->string[i] != string2->string[i])
		{
			return false;
		}
	}
	return true;
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