#include "StackFloat.h"
#include "string.h"

StackFloat* createStackFloat()
{
	return new StackFloat {nullptr};
}

void pushFloat(StackFloat* stack, float x)
{
	stack->first = new StackElementFloat {x, stack->first};
}

float popFloat(StackFloat* stack)
{
	if (isEmptyFloat(stack))
	{
		std::cout << "Stack ended. ";
	}
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
	{
		return stack->first->value;
	}
}

bool isEmptyFloat(StackFloat *stack)
{
	return stack->first == nullptr;
}

void deleteStackFloat(StackFloat* stack) 
{
	if (isEmptyFloat(stack))
	{
		return;
		delete stack;
	}
	StackElementFloat* current = stack->first;
	while (current)
	{
		StackElementFloat* nextElement = current->next;
		delete current;
		current = nextElement;
	}

	delete stack->first;
	delete stack;
}