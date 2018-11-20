#include "BalanceBinaryTree.h"

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

void addNode(Node *&node, int x)
{
	if (node == nullptr)
	{
		node = new Node {x, 1, nullptr, nullptr};
		balance(node);
		return;
	}
	if (x < node->value)
	{
		addNode(node->left, x);
	}
	else
	{
		addNode(node->right, x);
	}
	balance(node);
}

void addNode(BinaryTree* &tree, int x)
{
	addNode(tree->root, x);
}

void removeNode(Node *&node)
{
	if ((node->left == nullptr) && (node->right == nullptr))
	{
		delete node;
		node = nullptr;
		return;
	}

	if ((node->left != nullptr) && (node->right == nullptr))
	{
		Node *toDelete = node;
		node = node->left;
		delete toDelete;
		return;
	}

	if ((node->left == nullptr) && (node->right != nullptr))
	{
		Node *toDelete = node;
		node = node->right;
		delete toDelete;
		return;
	}

	if ((node->left != nullptr) && (node->right != nullptr))
	{
		Node **temp = &node->right;
		while ((*temp)->left != nullptr)
		{
			temp = &(*temp)->left;
		}
		node->value = (*temp)->value;
		removeNode(*temp);
		updateHeight(node);
		balance(node);
		return;
	}
}
void removeNode(Node *&node, int value)
{
	if (node == nullptr)
	{
		return;
	}
	if (node->value == value)
	{
		removeNode(node);
		return;
	}

	if (node->value > value)
	{
		removeNode(node->left, value);
	}
	else
	{
		removeNode(node->right, value);
	}
}

void removeNode(BinaryTree* &tree, int x)
{
	removeNode(tree->root, x);
}

void ascendingOrderPrint(Node* node) 
{
	if (node != nullptr) 
	{
		ascendingOrderPrint(node->left);
		std::cout << node->value << " ";
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

void descendingOrderPrint(Node* node)
{
	if (node != nullptr)
	{
		descendingOrderPrint(node->right);
		std::cout << node->value << " ";
		descendingOrderPrint(node->left);
	}
}

void descendingOrderPrint(BinaryTree* tree)
{
	if (tree->root != nullptr)
	{
		descendingOrderPrint(tree->root);
	}
	else
	{
		std::cout << "Tree is empty.";
	}
}

void preorderPrint(Node* node)
{
	if (node != nullptr)
	{
		std::cout << " (" << node->value;
		if (node->left == nullptr)
		{
			std::cout << " null ";
		}
		else
		{
			preorderPrint(node->left);
		}
		if (node->right == nullptr)
		{
			std::cout << " null";
		}
		else
		{
			preorderPrint(node->right);
		}
		std::cout << ") ";
	}
}

void preorderPrint(BinaryTree* tree)
{
	if (tree->root != nullptr)
	{
		preorderPrint(tree->root);
	}
	else
	{
		std::cout << "Tree is empty.";
	}
}

bool exists(Node* node, int x)
{
	if (node == nullptr)
	{
		return false;
	}
	
	if (node->value == x)
	{
		return true;
	}
	if (node->value < x)
	{
		if (node->right)
		{
			return exists(node->right, x);
		}
		else
		{
			return false;
		}
	}
	if (node->value > x)
	{
		if (node->left)
		{
			return exists(node->left, x);
		}
		else
		{
			return false;
		}
	}
}

bool exists(BinaryTree* tree, int x)
{
	return exists(tree->root, x);
}

//Balance functions

int height(Node *node)
{
	return node ? node->height : 0;
}

int balanceFactor(Node *node)
{
	return height(node->right) - height(node->left);
}

void updateHeight(Node *&node)
{
	int heightLeft = height(node->left);
	int heightRight = height(node->right);
	node->height = ((heightLeft > heightRight) ? heightLeft : heightRight) + 1;
}


void rotateRight(Node* &root)
{
	Node* pivot = root->left;
	root->left = pivot->right;
	pivot->right = root;
	updateHeight(root);
	updateHeight(pivot);
	root = pivot;
}

void rotateLeft(Node* &root) 
{
	Node* pivot = root->right;
	root->right = pivot->left;
	pivot->left = root;
	updateHeight(root);
	updateHeight(pivot);
	root = pivot;
}

void balance(Node* &pivot)
{
	updateHeight(pivot);

	if (balanceFactor(pivot) == 2)
	{
		if (balanceFactor(pivot->right) < 0)
			rotateRight(pivot->right);

		rotateLeft(pivot);
	}

	if (balanceFactor(pivot) == -2)
	{
		if (balanceFactor(pivot->left) > 0)
			rotateLeft(pivot->left);

		rotateRight(pivot);
	}
}


