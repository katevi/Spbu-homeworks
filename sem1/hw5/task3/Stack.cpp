#include "Stack.h"
#include <string.h>

Stack* createStack()
{
	return new Stack{ nullptr };
}

void push(Stack* stack, char x)
{
	stack->first = new StackElement{ x, stack->first };
}

char pop(Stack* stack)
{
	if (isEmpty(stack))
	{
		std::cout << "Stack ended. ";
	}
	else
	{
		StackElement* getElement = stack->first;
		stack->first = getElement->next;
		char result = getElement->value;
		delete getElement;
		return result;
	}
}

char getLastElement(Stack *stack)
{
	if (!isEmpty(stack))
	{
		return stack->first->value;
	}
}

bool isEmpty(Stack *stack)
{
	return stack->first == nullptr;
}

void deleteStack(Stack* stack)
{
	if (isEmpty(stack))
	{
		return;
		delete stack;
	}
	StackElement *current = stack->first;
	while (current)
	{
		StackElement *nextElement = current->next;
		delete current;
		current = nextElement;
	}
	delete stack;
}