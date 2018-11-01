#include "list.h"
#include <cstdio>
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
	delete list->first;
	delete list;
}

void print(List *list)
{
	ListElement *current = list->first;
	std::cout << current->name; //<< "#" << current->number << "%";
	for (int i = 0; i < size(list); i++)
	{
		//printf("%s\n", current->number);
		printf("%ñ\n", current->name);
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

/*int getElement(List *list, int index)
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
}*/

void add(List *list, char name)
{
	ListElement *current = list->first;
	if (list->first == nullptr)
	{
		list->first = new ListElement{ name, list->first};
		return;
	}
	while (current->next)
	{
		current = current->next;
	}
	//ListElement *newElement = new ListElement{name, number, nullptr};
	current->next = new ListElement{ name, nullptr };
	//std::cout << current->next->name;
	return;
}
