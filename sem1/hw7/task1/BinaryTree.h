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
Node* deleteNode(Node* node, int x);
bool isBelong(Node* node, int x);

/*void printInAscendingOrder(BinaryTree* tree);
void printInDescendingOrder(BinaryTree* tree);
void printAsTree(BinaryTree* tree);*/
Node* minimumNode(Node* node);
void treePrint(Node* node);