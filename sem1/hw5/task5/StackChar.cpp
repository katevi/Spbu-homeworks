#include "StackChar.h"

StackChar* createStackChar()
{
	return new StackChar{ nullptr };
}

void pushChar(StackChar* stack, char x)
{
	stack->first = new StackElementChar{ x, stack->first };
}

char popChar(StackChar* stack)
{
	if (isEmptyChar(stack))
	{
		std::cout << "Stack ended. ";
	}
	else
	{
		StackElementChar* getElement = stack->first;
		stack->first = getElement->next;
		int result = getElement->value;
		delete getElement;
		return result;
	}
}

char getLastElementChar(StackChar *stack)
{
	if (!isEmptyChar(stack))
	{
		return stack->first->value;
	}
}

bool isEmptyChar(StackChar *stack)
{
	return stack->first == nullptr;
}

void deleteStackChar(StackChar* stack) 
{
	if (isEmptyChar(stack))
	{
		return;
	}
	while (!isEmptyChar(stack))
	{
		StackElementChar* getElement = stack->first;
		stack->first = stack->first->next;
		delete getElement;
	}
	delete stack;
}