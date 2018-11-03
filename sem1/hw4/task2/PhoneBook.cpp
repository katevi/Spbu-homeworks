#include "PhoneBook.h"
#include "list.h"
#include <stdio.h>
#include <iostream>
#include <fstream>

using namespace std;

void toFindName(List* list)
{
	std::cout << "Enter number:";
	char* number = new char[10];
	std::cin >> number;
	findingNameInList(list, number);
	delete[] number;
}

void toFindNumber(List* list)
{
	std::cout << "Enter name:";
	char* name = new char[10];
	std::cin >> name;
	findingNumberInList(list, name);
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
	addingSubscriberInList(list, number, name);
}

void saving(List* list)
{
	savingListToFile(list);
}

void menu(int option, List* list)
{
	if ((option > 4) || (option < 0))
	{
		std::cout << "Choose 0, 1, 2, 3 or 4!";
	}
	else
	{
		while (option != 0)
		{
			switch (option)
			{
			case 1:
			{
				toAddSubscriber(list);
				break;
			}
			case 2:
			{
				toFindNumber(list);
				break;
			}
			case 3:
			{
				toFindName(list);
				break;
			}
			case 4:
			{
				savingListToFile(list);
				break;
			}
			default:
			{
				std::cout << "Choose 0, 1, 2, 3 or 4!";
				break;
			}
			}
			std::cout << "Enter option:";
			std::cin >> option;
		}
		std::cout << "Phone book exit...";
	}
}