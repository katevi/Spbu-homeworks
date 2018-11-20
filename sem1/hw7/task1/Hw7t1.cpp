#include <iostream>
#include "BinaryTree.h"
#include "Set.h"


int main()
{
	Set* set = createSet();
	std::cout << "Hello! Please, press:\n";
	std::cout << "1 - if you want to add element to tree\n";
	std::cout << "2 - if you want to delete element from tree\n";
	std::cout << "3 - if you want to print elements from tree in ascending order\n";
	std::cout << "4 - if you want to print elements from tree in descending order\n";
	std::cout << "5 - if you want to print elements from tree in preorder way (with brackets) \n";
	std::cout << "6 - if you want to exit\n";
	int option = 0;
	std::cout << "\nChoose option:";
	std::cin >> option;
	while (option != 6)
	{
		switch (option)
		{
		case 1:
		{
			addElement(set);
			break;
		}
		case 2:
		{
			deleteElement(set);
			break;
		}
		case 3:
		{
			ascendingOrderPrint(set);
			break;
		}
		case 4:
		{
			descendingOrderPrint(set);
			break;
		}
		case 5:
		{
			preorderPrint(set);
			break;
		}
		default:
		{
			std::cout << "Please, press only 1 - 6:";
			break;
		}
		}
		std::cout << "\nChoose option:";
		std::cin >> option;
		if (option == 6)
		{
			std::cout << "Exit...";
		}
	}
	removeSet(set);
}