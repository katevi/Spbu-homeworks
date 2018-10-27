#include "StackFloat.h"

StackFloat* createStackFloat()
{
	return new StackFloat{ nullptr };
}

void pushFloat(StackFloat* stack, float x)
{
	stack->first = new StackElementFloat{ x, stack->first };
}

float popFloat(StackFloat* stack)
{
	if (isEmptyFloat(stack))
		std::cout << "Stack ended. ";
	else
	{
		StackElementFloat* getElement = stack->first;
		stack->first = getElement->next;
		float result = getElement->value;
		delete getElement;
		return result;
	}
}

float getLastElementFloat(StackFloat *stack)
{
	if (!isEmptyFloat(stack))
		return stack->first->value;
}

bool isEmptyFloat(StackFloat *stack)
{
	return stack->first == nullptr;
}

void deleteStackFloat(StackFloat* stack) 
{
	if (isEmptyFloat(stack))
		return;
	while (!isEmptyFloat(stack))
	{
		StackElementFloat* getElement = stack->first;
		stack->first = stack->first->next;
		delete getElement;
	}
	delete stack;
}