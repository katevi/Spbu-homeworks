#pragma once

struct ListElement {
	int value;
	ListElement *next;
	ListElement* previous;
};

struct List {
	ListElement *first;
};

List *createList();
void deleteList(List *list);

void add(List *list, int value);
int getElement(List *list, int index);
int size(List *list);
bool isSymmetrical(List* list);
void print(List *list);