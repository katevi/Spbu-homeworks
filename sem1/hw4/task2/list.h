#pragma once

struct Subscriber 
{
	char* number;
	char* name;
	Subscriber *next;
};

struct List 
{
	Subscriber *first;
};

List *createList();
void deleteList(List *list);

int sizeOfList(List *list);
void printOfList(List *list);

void addSubscriberInList(List *list, char* number, char* name);

void findNumberInList(List* list, char* name);
void findNameInList(List* list, char* number);

void saveListToFile(List* list);
void readListFromFile(List* &list);