#define _CRT_SECURE_NO_WARNINGS
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


Node *createNode(char symbol, Node *left, Node *right)
{
	Node *newNode = new Node;

	newNode->left = left;
	newNode->right = right;
	newNode->symbol = symbol;

	return newNode;
}

Tree *createTree(char symbol)
{
	Tree *newTree = new Tree;

	newTree->root = createNode(symbol, nullptr, nullptr);

	return newTree;
}

Tree *mergeTrees(Tree *&left, Tree *&right)
{
	Tree *newTree = new Tree;

	newTree->root = createNode('\0', left->root, right->root);

	delete left;
	left = nullptr;
	delete right;
	right = nullptr;
	
	return newTree;
}


void addSymbol(char *string, char symbol)
{
	if (symbol == '\0')
	{
		strcat(string, "'\\0'");
		return;
	}

	char temp[4] = {'\0'};
	temp[0] = '\'';
	temp[1] = symbol;
	temp[2] = '\'';
	strcat(string, temp);
}

void addString(char *string, char *toAdd)
{
	strcat(string, toAdd);
	delete[] toAdd;
}

char *outputABC(Node *node)
{
	char *answer = new char[stringSize];
	
	if (node == nullptr)
	{
		strcpy(answer, "null");
		return answer;
	}
	
	strcpy(answer, "(");
	addSymbol(answer, node->symbol);
	strcat(answer, " ");

	addString(answer, outputABC(node->left));
	strcat(answer, " ");

	addString(answer, outputABC(node->right));
	strcat(answer, ")");
	
	return answer;
}

char *outputABC(Tree *tree)
{
	return outputABC(tree->root);
}

void countCodes(Node *node, int *codes, int code)
{
	if (node == nullptr)
		return;
	
	if (node->symbol != '\0')
		codes[(unsigned char)node->symbol] = code;
	
	countCodes(node->left, codes, code * 10);
	countCodes(node->right, codes, code * 10 + 1);
}

int *countCodes(Tree *tree)
{
	int *codes = new int[charSize];
	int code = 2;
	countCodes(tree->root, codes, code);
	return codes;
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