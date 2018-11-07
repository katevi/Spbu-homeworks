#include "PhoneBook.h"
#include "list.h"
#include <stdio.h>
#include <iostream>
#include <fstream>
#include <cstring>

using namespace std;

void findNameInList(List* list)
{
	std::cout << "Enter number:";
	char* number = new char[10];
	std::cin >> number;
	findNameInList(list, number);
	delete[] number;
}

void findNumberInList(List* list)
{
	std::cout << "Enter name:";
	char* name = new char[10];
	std::cin >> name;
	findNumberInList(list, name);
	delete[] name;
}

void toAddSubscriber(List* list)
{
	std::cout << "Enter name:";
	char* name = new char[10]{ 0 };
	std::cin >> name;
	std::cout << "Enter number:";
	char* number = new char[10]{ 0 };
	std::cin >> number;
	addSubscriberInList(list, number, name);
}

void saving(List* list)
{
	saveListToFile(list);
}