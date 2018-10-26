#include "list.h"
#include <iostream>

List *createList()
{
	return new List {0, nullptr, nullptr };
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
	ListElement *current = new ListElement;
	current->next = list->head;
	current->value = number;
	if (list->head != NULL)
	{
		list->tail->next = current;
		list->tail = current;
	}
	else
	{
		list->head = current;
		list->tail = current;
	}
}

void deleteElements(List *list, int m)
{
	ListElement *current = list->head;
	int i = 0;
	while (list->size > 1)
	{
		i++;
		if (i % m == 0)
		{
			if (current->next == list->head)
			{
				list->head = current->next->next;
			}
			ListElement *elementToDelete = current->next;
			current->next = current->next->next;
			delete elementToDelete;
			list->size--;
		}
		current = current->next;
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