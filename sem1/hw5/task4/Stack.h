#pragma once
#include <iostream>
struct StackElement
{
	float value;
	StackElement* next;
};
struct Stack
{
	StackElement* first;
};
Stack* createStack();
void push(Stack* stack, float x);
float pop(Stack* stack);
bool isEmpty(Stack* stack);
void deleteStack(Stack* stack);
float getLastElement(Stack *stack);