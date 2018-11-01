#pragma once

struct Subscriber {
	char* number;
	char* name;
	Subscriber *next;
};

struct List {
	Subscriber *first;
};

List *createList();
void deleteList(List *list);

void addingSubscriberInList(List *list, char* number, char* name);

int sizeOfList(List *list);

void printOfList(List *list);
void findingNumberInList(List* list, char* name);
void findingNameInList(List* list, char* number);
void savingListToFile(List* list);
void readingListFromFile(List* &list);