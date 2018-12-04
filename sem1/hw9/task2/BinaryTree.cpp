#include "BinaryTree.h"
#include "queue.h"
#include "String.h"
#include "HashTable.h"
#include <fstream>

using namespace std;

BinaryTree *createTree()
{
	return new BinaryTree{ nullptr };
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

void addNode(Node *&node, TableElement* element)
{
	if (node == nullptr)
	{
		node = new Node {element, nullptr, nullptr};
		node->element->symbol = element->symbol;
		node->element->countOfSame = element->countOfSame;
		return;
	}
	if (element->countOfSame > node->element->countOfSame)
	{
		addNode(node->right, element);
	}
	if (element->countOfSame <= node->element->countOfSame)
	{
		addNode(node->left, element);
	}
}

void addNode(BinaryTree* &tree, TableElement* element)
{
	addNode(tree->root, element);
}

BinaryTree* mergeTree(BinaryTree* tree1, BinaryTree* tree2)
{
	BinaryTree* newTree = createTree();
	TableElement* newElement = new TableElement { '#', 0 };
	Node* newNode = new Node{ newElement, 0 };
	QueueElement* newRoot = new QueueElement {newTree, nullptr};
	newTree->root = newNode;
	newRoot->tree->root->element->countOfSame = tree1->root->element->countOfSame + tree2->root->element->countOfSame;
	newTree->root->left = tree1->root;
	newTree->root->right = tree2->root;
	tree1->root = nullptr;
	tree2->root = nullptr;
	return newTree;
}

bool isLeaf(Node* node)
{
	return ((node->left == nullptr) && (node->right == nullptr));
}

void getCodes(Node* node, String **codes, String *currentCode)
{
	if (isLeaf(node))
	{
		if (length(currentCode) == 0)
		{
			char leftSuffixLine[2] = { '0', '\0' };
			String *leftSuffix = createString(leftSuffixLine);
			concatenate(currentCode, leftSuffix);
			deleteString(leftSuffix);
		}
		codes[(int)node->element->symbol] = currentCode;
		return;
	}

	String *leftCode = currentCode;
	String *rightCode = clone(currentCode);

	char leftSuffixLine[2] = { '0', '\0' };
	char rightSuffixLine[2] = { '1', '\0' };
	String *leftSuffix = createString(leftSuffixLine);
	String *rightSuffix = createString(rightSuffixLine);
	concatenate(leftCode, leftSuffix);
	concatenate(rightCode, rightSuffix);
	deleteString(leftSuffix);
	deleteString(rightSuffix);

	getCodes(node->left, codes, leftCode);
	getCodes(node->right, codes, rightCode);
}

String **codes(BinaryTree* tree, int tableSize)
{
	String **codes = new String*[tableSize];
	for (int i = 0; i < tableSize; i++)
		codes[i] = nullptr;

	char emptyLine[1] = { '\0' };
	getCodes(tree->root, codes, createString(emptyLine));
	return codes;
}
void ascendingOrderPrint(Node* node)
{
	if (node != nullptr)
	{
		ascendingOrderPrint(node->left);
		std::cout << node->element->symbol << " ";
		ascendingOrderPrint(node->right);
	}
}

void ascendingOrderPrint(BinaryTree* tree)
{
	if (tree->root != nullptr)
	{
		ascendingOrderPrint(tree->root);
	}
	else
	{
		std::cout << "Tree is empty.";
	}
}

void preorderPrint(Node* node, ofstream &file)
{
	if (node != nullptr)
	{
		file << " (" << node->element->symbol;
		if (node->left == nullptr)
		{
			file << " null ";
		}
		else
		{
			preorderPrint(node->left, file);
		}
		if (node->right == nullptr)
		{
			file << " null";
		}
		else
		{
			preorderPrint(node->right, file);
		}
		file << ") ";
	}
}

void preorderPrint(BinaryTree* tree, ofstream &file)
{
	if (tree->root != nullptr)
	{
		preorderPrint(tree->root, file);
	}
	else
	{
		file << "Tree is empty.";
	}
}
