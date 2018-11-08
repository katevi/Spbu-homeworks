#include <iostream>
#include "BinaryTree.h"

int main()
{
	BinaryTree* tree = createTree();
	std::cout << "Enter the elements of tree\n";
	int x = 0;
	for (int i = 0; i < 4; i++)
	{
		std::cin >> x;
		addNode(tree->root, x);
	}
	std::cout << minimumNode(tree->root)->value;
	treePrint(tree->root);
	std::cout << "Enter element to delete";
	std::cin >> x;
	deleteNode(tree->root, x);
	treePrint(tree->root);
	system("pause");
	removeTree(tree->root);
}