#include "Stack.h"
Stack* createStack()
{
	return new Stack{ nullptr };
}

void push(Stack* stack, float x)
{
	stack->first = new StackElement{ x, stack->first };
}

float pop(Stack* stack)
{
	if (isEmpty(stack))
		std::cout << "Stack ended. ";
	else
	{
		StackElement* getElement = stack->first;
		stack->first = getElement->next;
		float result = getElement->value;
		delete getElement;
		return result;
	}
}

float getLastElement(Stack *stack)
{
	if (!isEmpty(stack))
		return stack->first->value;
}

bool isEmpty(Stack *stack)
{
	return stack->first == nullptr;
}

void deleteStack(Stack* stack)
{
	if (isEmpty(stack))
		return;
	while (!isEmpty(stack))
	{
		StackElement* getElement = stack->first;
		stack->first = stack->first->next;
		delete getElement;
	}
	delete stack->first;
	delete stack;
}