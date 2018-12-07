#include "list.h"
#include <iostream>

List *createList()
{
	return new List{ nullptr };
}

void deleteList(List *list)
{
	ListElement *current = list->first;
	while (current)
	{
		ListElement *nextElement = current->next;
		delete current;
		current = nextElement;
	}

	delete list;
}

void print(List *list)
{
	ListElement *current = list->first;
	while (current)
	{
		std::cout << current->value << " ";
		current = current->next;
	}
}

int size(List *list)
{
	ListElement *current = list->first;
	int length = 0;
	while (current)
	{
		length++;
		current = current->next;
	}
	return length;
}

int getElement(List *list, int index)
{
	ListElement *current = list->first;
	int count = 0;
	while (current)
	{
		if (count == index)
			return current->value;
		count += 1;
		current = current->next;
	}
	return -1;
}

void add(List *list, int x)
{
	ListElement *current = list->first;
	if (list->first == nullptr)
	{
		list->first = new ListElement{ x, list->first };
		return;
	}
	while (current->next != nullptr)
		current = current->next;
	ListElement* newElement = new ListElement {x, nullptr};
	current->next = newElement;
}

ListElement* previous(List* list, ListElement* element)
{
	ListElement* current = list->first;
	if (current == nullptr || current == element)
		return nullptr;
	while (current->next != element && current->next)
	{
		current = current->next;
	}
	return current;
}

void insertionSortList(List *list)
{
	ListElement *tail = list->first;
	while (tail->next)
	{
		tail = tail->next;
	}
	while (tail)
	{
		ListElement *current = tail;
		while (current->next)
		{
			if (current->value > current->next->value)
			{
				int temp = current->value;
				current->value = current->next->value;
				current->next->value = temp;
			}
			current = current->next;
		}
		tail = previous(list, tail);
	}
}