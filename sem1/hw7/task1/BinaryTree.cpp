#include "BinaryTree.h"

BinaryTree *createTree()
{
	return new BinaryTree {nullptr};
}

void removeTree(BinaryTree* tree)
{
	if (tree && tree->root)
		removeTree(tree->root);
	delete tree;

}

void removeTree(Node* node)
{
	if (node == nullptr)
		return;
	removeTree(node->left);
	removeTree(node->right);
	delete node;
}

void addNode(Node *&node, int x)
{
	if (node == nullptr)
	{
		node = new Node {x, nullptr, nullptr};
		return;
	}
	if (x > node->value)
	{
		addNode(node->right, x);
	}
	else if (x < node->value)
	{
		addNode(node->left, x);
	}
}

Node* minimumNode(Node* node)
{
	if (node->left != nullptr)
	{
		return minimumNode(node->left);
	}
	else
		return node;
}

Node* deleteNode(Node* node, int x)
{
	if (node == nullptr)
	{
		return node;
	}
	if (x < node->value)
	{
		node->left = deleteNode(node->left, x);
	}
	else if (x > node->value)
	{
		node->right = deleteNode(node->right, x);
	}
	else if ((node->left != nullptr) && (node->right != nullptr))
	{
		node->value = minimumNode(node->right)->value;
		node->right = deleteNode(node->right, node->value);
	}
	else
		if (node->left != nullptr)
		{
			node = node->left;
		}
		else
		{
			node = node->right;
		}
	return node;
}

void treePrint(Node* node) 
{
	if (node != nullptr) 
	{
		std::cout << node->value;
		treePrint(node->left);
		treePrint(node->right);
	}
}

/*bool isBelong(Node* node, int x)
{
	if (node == nullptr)
	{
		return;
	}
	if (node->value == x)
		return true;
	else
	isBelong(node->left, x);
	isBelong(node->right, x);
}*/