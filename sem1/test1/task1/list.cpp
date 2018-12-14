#include "list.h"
#include <iostream>

List *createList()
{
	return new List{ nullptr};
}

void deleteList(List *list)
{
	ListElement *current = list->first;
	while (current)
	{
		ListElement *nextElement = current->next;
		current->previous = nullptr;
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
	std::cout << "\n";
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
		list->first = new ListElement{ x, list->first, list->first};
		return;
	}
	while (current->next != nullptr)
	{
		current = current->next;
	}
	ListElement* newElement = new ListElement{ x, nullptr, current};
	current->next = newElement;
}


bool isSymmetricalElement(ListElement* tail)
{
	if (tail == nullptr || tail->next == nullptr)
		return true;
	ListElement* head = tail;
	while (tail->next)
	{
		tail = tail->next;
	}
	while (head != tail)
	{
		if (head->value != tail->value)
		{
			return false;
		}
		head = head->next;
		tail = tail->previous;
	}
	return true;

}

bool isSymmetrical(List* list)
{
	return isSymmetricalElement(list->first);
}
