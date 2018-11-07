#include "list.h"
#include "PhoneBook.h"
#include <iostream>
#include <cstring>


int main()
{
	List *list = createList();
	int option = 0;
	std::cout << "Welcome to the interactive phone book! Press: \n '0' - if you want to exit \n '1' - if you want to add subscriber \n '2' - if you want to find number \n '3' - if you want to find name \n '4' - if you want to save new Subscriber into the file \n";
	readListFromFile(list);
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
				findNumberInList(list);
				break;
			}
			case 3:
			{
				findNameInList(list);
				break;
			}
			case 4:
			{
				saveListToFile(list);
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