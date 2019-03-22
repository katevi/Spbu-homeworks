#include "list.h"
#include <iostream>

List *createList()
{
	return new List {0, nullptr};
}

void print(List *list)
{
	ListElement *current = list->head;
	for (int i = list->size; i > 0; i--)
	{
		std::cout << current->value << " ";
		current = current->next;
	}
}

void add(List* list, int number)
{
	list->size++;
	ListElement *newElement = new ListElement {number, list->head};
	if (list->head == nullptr)
	{
		list->head = newElement;
	}
	else
	{
		ListElement *current = list->head;
		if (list->size == 2)
		{
			list->head->next = newElement;
			newElement->next = current;
		}
		else
		{
			while (current->next != list->head)
			{
				current = current->next;
			}
			current->next = newElement;
		}
	}
}

void deleteList(List *list)
{
	ListElement *current = list->head;
	for (int i = list->size; i > 0; i--)
	{
		ListElement *nextElement = current->next;
		delete current;
		current = nextElement;
	}
	delete list;
}

int printListSize(List *list)
{
	return list->size;
}

void listSizeDecrease(List *list)
{
	list->size--;
}

void deleteElement(List* list)
{
	ListElement* temp = list->head->next;
	list->head->next = list->head->next->next;
	delete temp;
}

void movePositionOfElement(List* list)
{
	list->head = list->head->next;
}