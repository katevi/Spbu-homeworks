#include <iostream>
#include "BalanceBinaryTree.h"

void addElement(BinaryTree* tree)
{
	std::cout << "Enter element to add (int value):";
	int x = 0;
	std::cin >> x;
	addNode(tree, x);
}

void deleteElement(BinaryTree* tree)
{
	std::cout << "Enter element to delete (int value):";
	int x = 0;
	std::cin >> x;
	removeNode(tree, x);
}

int main()
{
	BinaryTree* tree = createTree();
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
			addElement(tree);
			break;
		}
		case 2:
		{
			deleteElement(tree);
			break;
		}
		case 3:
		{
			ascendingOrderPrint(tree);
			break;
		}
		case 4:
		{
			descendingOrderPrint(tree);
			break;
		}
		case 5:
		{
			preorderPrint(tree);
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
	removeTree(tree);
}