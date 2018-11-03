#include "list.h"
#include "PhoneBook.h"
#include <iostream>


int main()
{
	List *list = createList();
	int option = 0;
	std::cout << "Welcome to the interactive phone book! Press: \n '0' - if you want to exit \n '1' - if you want to add subscriber \n '2' - if you want to find number \n '3' - if you want to find name \n '4' - if you want to save it into the file \n";
	readingListFromFile(list);
	std::cout << "Enter option:";
	std::cin >> option;
	menu(option, list);
	deleteList(list);
}