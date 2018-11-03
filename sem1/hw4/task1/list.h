#pragma once

struct ListElement 
{
    int value;
    ListElement *next;
};

struct List 
{
	int size;
	ListElement *head {nullptr};
};

List *createList();
void deleteList(List *list);

void add(List *list, int value);
void deleteElement(List* list);
void movePositionOfElement(List* list);

void print(List *list);

int printListSize(List *list);
void listSizeDecrease(List* list);