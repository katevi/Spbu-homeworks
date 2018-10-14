#include "list.h"
#include <iostream>

List *createList()
{
    return new List {nullptr};
}

void print(List *list, int n)
{
	int i = 0;
	ListElement *current = list->first;
	while (i < n)
	{
		i++;
		std::cout << current->value << " ";
		current = current->next;
	}
}

int size(List* list)
{
	ListElement *current = list->first;
	int length = 0;
	while (current->next != list->first)
	{
		++length;
		current = current->next;
	}
	return length;
}

void add(List* list, int x)
{
	ListElement* current = list->first;
	if (list->first == nullptr)
	{
		list->first = new ListElement{ x, list->first };
		return;
	}
	while ((current->next) && (current->next->value < x))
	{
		current = current->next;
	}

	ListElement* newElement = new ListElement{ x, nullptr };
	current->next = newElement;
	return;
}

void deletingElements(List *list, int m)
{
	ListElement *current = list->first;
	int i = 0;
	int t = size(list);
	while (t >= 1)
	{
		i++;
		if (i % m == 0)
		{
			if (current->next == list->first)
				list->first = current->next->next;
			ListElement *elementToDelete = current->next;
			current->next = current->next->next;
			delete elementToDelete;
			t--;
		}
		current = current->next;
	}
}

void cicle(List* list)
{
	ListElement* current = list->first;
	while (current->next != nullptr) {
		current = current->next;
	}
	current->next = list->first;
}
