#pragma once

struct ListElement {
	int city;
	int lengthOfRoad;
	ListElement *next;
};

struct List {
	ListElement *first;
};

List *createList();
void deleteList(List *list);

void add(List *list, int city, int lengthOfRoad);
int size(List *list);

void print(List *list);