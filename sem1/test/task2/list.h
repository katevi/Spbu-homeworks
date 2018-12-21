#pragma once

struct ListElement {
	int value;
	ListElement *next;
};

struct List {
	ListElement *first;
};

List *createList();
void deleteList(List *list);

void add(List *list, int value);
//void remove(List *list, int value);
int getElement(List *list, int index);
int size(List *list);

void print(List *list);