#include "list.h"
#include <iostream>

Polynomial *createList()
{
	return new Polynomial{ nullptr };
}

void deleteList(Polynomial *polynomial)
{
	elementOfPolynomial *current = polynomial->first;
	while (current)
	{
		elementOfPolynomial *nextElement = current->next;
		delete current;
		current = nextElement;
	}

	delete polynomial;
}

void add(Polynomial *polynomial, int degree, int coefficient, char sign)
{
	elementOfPolynomial *current = polynomial->first;
	if (polynomial->first == nullptr)
	{
		polynomial->first = new elementOfPolynomial{ sign, coefficient, degree, polynomial->first};
		return;
	}
	while (current->next)
	{
		current = current->next;
	}
	elementOfPolynomial *newElement = new elementOfPolynomial{sign, coefficient, degree, nullptr};
	current->next = newElement;
}
