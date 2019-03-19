#pragma once
#include <iostream>

struct StackElementFloat 
{
	float value;
	StackElementFloat* next;
};

struct StackFloat 
{
	StackElementFloat* first;
};

StackFloat* createStackFloat();
void pushFloat(StackFloat* stack, float x);
float popFloat(StackFloat* stack);
bool isEmptyFloat(StackFloat* stack);
void deleteStackFloat(StackFloat* stack);
float getLastElementFloat(StackFloat *stack);
