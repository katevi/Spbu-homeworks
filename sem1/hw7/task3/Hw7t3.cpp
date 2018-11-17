#include <iostream>
#include <fstream>
#include "BinaryTree.h"
#include <string.h>

using namespace std;

int main()
{
	BinaryTree* tree = createTree();
	ifstream file;
	file.open("expression.txt");
	addTree(tree, file);
	std::cout << "Expression: ";
	printInfixForm(tree);
	std::cout << "\n";
	std::cout << "Result: " << calculate(tree);
	removeTree(tree);
	file.close();
	system("pause");
}