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
void print(List *list);
int printListSize(List *list);
void killTheSoldier(List* list);
void listSizeDecrease(List* list);
void changingPosition(List* list);