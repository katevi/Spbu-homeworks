#pragma once

struct ListElement 
{
    int value;
    ListElement *next;
};

struct List 
{
	int size;
	ListElement *head { nullptr };
	ListElement *tail { nullptr };
};

List *createList();
void deleteList(List *list);

void add(List *list, int value);
void print(List *list);
void deleteElements(List *list, int m);