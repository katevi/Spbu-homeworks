#include "BinaryTree.h"
#include <string.h>

int const stringSize = 1024;
int const charSize = 256;

struct Node
{
	char symbol;
	Node *left;
	Node *right;
};

struct Tree
{
	Node *root;
};


Node *createNode(char symbol)
{
	Node *newNode = new Node;

	newNode->left = nullptr;
	newNode->right = nullptr;
	newNode->symbol = symbol;

	return newNode;
}

void loadTree(Node *&node, char *string, int &i)
{
	i += 2;
	if (string[i] == '\\')
	{
		i++;
		node = createNode('\0');
	}
	else
		node = createNode(string[i]);

	i += 3;
	if (string[i] == '(')
		loadTree(node->left, string, i);
	else
		i += 3;

	i += 2;
	if (string[i] == '(')
		loadTree(node->right, string, i);
	else
		i += 3;
	
	i++;
}

Tree *loadTree(char *string)
{
	Tree *newTree = new Tree;

	int i = 0;
	loadTree(newTree->root, string, i);

	return newTree;
}

void decryptSymbol(Node *node, char *coded, int &i, char *result, int &j)
{
	if (node->symbol != '\0')
	{
		result[j] = node->symbol;
		j++;
		return;
	}

	i++;
	if (coded[i - 1] == '0')
		decryptSymbol(node->left, coded, i, result, j);
	else
		decryptSymbol(node->right, coded, i, result, j);
}

void decryptString(Tree *tree, char *&string)
{
	char *answer = new char[stringSize];
	int size = strlen(string);

	int i = 0;
	int j = 0;

	while (i < size)
		decryptSymbol(tree->root, string, i, answer, j);

	answer[j] = '\0';
	delete[] string;
	string = answer;
}


void deleteTree(Node *node)
{
	if (node == nullptr)
		return;

	deleteTree(node->left);
	deleteTree(node->right);
	delete node;
}

void deleteTree(Tree *&tree)
{
	if (tree == nullptr)
		return;

	deleteTree(tree->root);
	delete tree;
	tree = nullptr;
}