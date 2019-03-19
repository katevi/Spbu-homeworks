#pragma once
#include <stdio.h>
#include <iostream>

struct Node {
	int value;
	int height;
	Node *left;
	Node *right;
};

struct  BinaryTree {
	Node *root;
};

BinaryTree *createTree();
void removeTree(BinaryTree* tree);
void addNode(BinaryTree* &tree, int x);
void removeNode(BinaryTree* &tree, int x);

bool exists(BinaryTree* tree, int x);

void descendingOrderPrint(BinaryTree* tree);
void ascendingOrderPrint(BinaryTree* tree);
void preorderPrint(BinaryTree* tree);
