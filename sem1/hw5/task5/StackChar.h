#pragma once
#include <iostream>

struct StackElementChar 
{
	char value;
	StackElementChar* next;
};

struct StackChar 
{
	StackElementChar* first;
};

StackChar* createStackChar();
void pushChar(StackChar* stack, char x);
char popChar(StackChar* stack);
bool isEmptyChar(StackChar* stack);
void deleteStackChar(StackChar* stack);
char getLastElementChar(StackChar *stack);
