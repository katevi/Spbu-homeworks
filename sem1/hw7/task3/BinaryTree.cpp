#include "BinaryTree.h"
#include <fstream>
#include <iostream>

BinaryTree *createTree()
{
	return new BinaryTree {nullptr};
}

void removeTree(BinaryTree* tree)
{
	if (tree && tree->root)
	{
		removeTree(tree->root);
	}
	delete tree;
}

void removeTree(Node* node)
{
	if (node == nullptr)
	{
		return;
	}
	removeTree(node->left);
	removeTree(node->right);
	delete node;
}

void addTree(BinaryTree* &tree, ifstream &file)
{
	tree->root = addNode(file);
}


bool isNumber(char x)
{
	return ((x >= '0') && (x <= '9'));
}

Node* addNode(ifstream &file)
{
	Node *newNode = new Node;
	char currentSymbol = file.get();
	if (currentSymbol == '(')
	{
		currentSymbol = file.get();
		if (currentSymbol == ' ')
		{
			currentSymbol = '*';
		}
		else
		{
			file.get(); 
		}
		newNode->isLeaf = false;
		newNode->operand = currentSymbol;
		newNode->left = addNode(file);
		file.get(); 
		newNode->right = addNode(file);
		file.get(); 
	}
	else
	{
		int currentValue = currentSymbol - '0';
		currentSymbol = file.get();
		while (isNumber(currentSymbol))
		{
			currentValue = currentValue * 10 + currentSymbol - '0';
			currentSymbol = file.get();
		}
		file.unget();
		newNode->isLeaf = true;
		newNode->left = nullptr;
		newNode->right = nullptr;
		newNode->value = currentValue;
	}
	return newNode;
}

int calculate(BinaryTree* tree)
{
	int result = calculate(tree->root);
	return result;
}

int calculate(Node* node)
{
	if (node->isLeaf)
		return node->value;
	else
	{
		switch (node->operand)
		{
		case '+':
		{
			return (calculate(node->left) + calculate(node->right));
			break;
		}
		case '-':
		{
			return (calculate(node->left) - calculate(node->right));
		}
		case '*':
		{
			return (calculate(node->left) * calculate(node->right));
		}
		case '/':
		{
			return (calculate(node->right) / calculate(node->left));
		}
		}
	}
}

void printInfixNode(Node *node)
{
	if (node->isLeaf)
	{
		cout << node->value;
		return;
	}

	cout << "(";
	printInfixNode(node->left);
	cout << " " << node->operand << " ";
	printInfixNode(node->right);
	cout << ")";
}

void printInfixForm(BinaryTree* tree)
{
	printInfixNode(tree->root);
	cout << endl;
}

