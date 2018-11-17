#include "list.h"
#include <stdio.h>
#include <iostream>
#include <fstream>
#include <cstring>

using namespace std;

List *createList()
{
	return new List{ nullptr };
}

void deleteList(List *list)
{
	Subscriber *current = list->first;
	while (current)
	{
		Subscriber *nextElement = current->next;
		delete[] current->name;
		delete[] current->number;
		delete current;
		current = nextElement;
	}
	delete list;
}

void printOfList(List *list)
{
	Subscriber *current = list->first;
	for (int i = 0; i < sizeOfList(list); i++)
	{
		std::cout << current->name << " " << current->number << "\n";
		current = current->next;
	}
}

int sizeOfList(List *list)
{
	Subscriber *current = list->first;
	int length = 0;
	while (current)
	{
		length++;
		current = current->next;
	}
	return length;
}

void addSubscriberInList(List *list, char* number, char* name)
{
	Subscriber *newSubscriber = new Subscriber {number, name, nullptr};
	Subscriber *current = list->first;
	if (list->first == nullptr)
	{
		list->first = newSubscriber;
		return;
	}
	while (current->next)
	{
		current = current->next;
	}
	current->next = newSubscriber;
	return;
}

void findNumberInList(List* list, char* name)
{
	Subscriber *current = list->first;
	int length = strlen(name);
	while (current)
	{
		bool isSame = true;
		for (int i = 0; i < length; i++)
		{
			if (current->name[i] != name[i])
			{
				isSame = false;
			}
		}
		if (isSame)
		{
			std::cout << current->name << " " << current->number << "\n";
		}
		current = current->next;
	}
}

void findNameInList(List* list, char* number)
{
	Subscriber *current = list->first;
	int length = strlen(number);
	while (current)
	{
		bool isSame = true;
		for (int i = 0; i < length; i++)
		{
			if (current->number[i] != number[i])
			{
				isSame = false;
			}
		}
		if (isSame)
		{
			std::cout << current->name << " " << current->number << "\n";
			return;
		}
		current = current->next;
	}
}

void saveListToFile(List* list)
{
	ofstream file;
	char nameOfFile[] = "Telephones.txt";
	file.open(nameOfFile, ios::out);
	if ((sizeOfList(list) == 0))
	{
		std::cout << "Phonebook is empty. If you want to save something, please, add subscribers before.";
		ofstream ofs(nameOfFile, ios::out);
		return;
	}
	else
	{
		Subscriber* current = list->first;
		while (current)
		{
			file << current->number << "\n";
			file << current->name << "\n";
			current = current->next;
		}
	}
	file.close();
	std::cout << "Saved successfully. \n";
}

void readListFromFile(List *&list)
{
	ifstream file;
	char nameOfFile[] = "Telephones.txt";
	file.open(nameOfFile);
	if (!file)
	{
		std::cout << "Phonebook is empty. Please, add subscribers before.";
		ofstream ofs(nameOfFile);
		return;
	}
	while (!(file.eof()))
	{
		char* number = new char[10];
		char* name = new char[10];
		file.getline(number, 10);
		file.getline(name, 10);
		addSubscriberInList(list, number, name);
	}
}