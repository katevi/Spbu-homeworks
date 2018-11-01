#include "list.h"
#include <iostream>

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
	char* name = new char[10] {0};
	std::cin >> name;
	std::cout << "Enter number:";
	char* number = new char[10] {0};
	std::cin >> number;
	addingSubscriberInList(list, number, name);
}

int main()
{
	List *list = createList();
	int option = 0;
	std::cout << "Welcome to the interactive phone book! Press: \n '0' - if you want to exit \n '1' - if you want to add subscriber \n '2' - if you want to find number \n '3' - if you want to find name \n '4' - if you want to save it into the file \n";
	readingListFromFile(list);
	std::cout << "Enter option:";
	std::cin >> option;
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
	deleteList(list);
}