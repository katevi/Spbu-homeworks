#pragma once
#include <stdio.h>
#include <iostream>

struct Node {
	int value;
	Node *left;
	Node *right;
};

struct  BinaryTree {
	Node *root;
};

BinaryTree *createTree();
void removeTree(BinaryTree* tree);
void removeTree(Node* node);

void addNode(Node* &node, int x);
void addNode(BinaryTree* &tree, int x);
void removeNode(Node* &node, int x);
void removeNode(Node* &node);
void removeNode(BinaryTree* tree, int x);


bool exists(Node* node, int x);
bool exists(BinaryTree* tree, int x);

void descendingOrderPrint(Node* node);
void descendingOrderPrint(BinaryTree* tree);
void ascendingOrderPrint(Node* node);
void ascendingOrderPrint(BinaryTree* tree);
void preorderPrint(Node* node);
void preorderPrint(BinaryTree* tree);
