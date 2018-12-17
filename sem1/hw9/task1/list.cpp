#include "list.h"
#include "graph.h"
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
		std::cout << current->city << " " << current->lengthOfRoad<< "\n";
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

void add(List *list, int city, int lengthOfRoad)
{
	ListElement *current = list->first;
	ListElement* temp = current;
	while (temp)
	{
		if (temp->city == city)
			return;
		temp = temp->next;
	}
	if ((list->first == nullptr) || (current->lengthOfRoad > lengthOfRoad))
	{
		list->first = new ListElement {city, lengthOfRoad, list->first};
		return;
	}
	while ((current->next) && (current->next->lengthOfRoad < lengthOfRoad))
	{
		current = current->next;
	}
	ListElement* newElement = new ListElement {city, lengthOfRoad,  current->next};
	current->next = newElement;
}
