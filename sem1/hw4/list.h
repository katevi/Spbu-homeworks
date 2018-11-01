#pragma once

struct ListElement {
	//char* number;
	char name;
	//int value;
	ListElement *next;
};

struct List {
	ListElement *first;
};

List *createList();
void deleteList(List *list);

void add(List *list, char name);
//void remove(List *list, int value);
//int getElement(List *list, int index);
int size(List *list);

void print(List *list);