#pragma once

struct String {
	char* string;
	int length;
};

String* createString(char* currentString);
void deleteString(String* string);
void concatenate(String* string1, String* string2);
String* clone(String* string);
bool isEmpty(String* string);
int length(String* string);
int stringComparison(String* string1, String* string2);
String* createSubstring(String* baseString, int firstPosition, int lastPosition);
char* convertToChar(String* string);
bool isSame(String* string1, String* string2);