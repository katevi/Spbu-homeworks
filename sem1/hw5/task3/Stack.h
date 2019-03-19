#pragma once
#include <iostream>
struct StackElement
{
	char value;
	StackElement* next;
};
struct Stack
{
	StackElement* first;
};
Stack* createStack();
void push(Stack* stack, char x);
char pop(Stack* stack);
bool isEmpty(Stack* stack);
void deleteStack(Stack* stack);
char getLastElement(Stack *stack);