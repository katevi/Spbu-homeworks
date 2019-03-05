#pragma once
#include <stdio.h>
#include <iostream>
#include <fstream>

using namespace std;
struct Node {
	int value;
	char operand;
	bool isLeaf;
	Node *left;
	Node *right;
};

struct  BinaryTree {
	Node *root;
};

BinaryTree *createTree();
void removeTree(BinaryTree* tree);
void removeTree(Node* node);

void addTree(BinaryTree* &tree, ifstream &file);
Node* addNode(ifstream &file);


int calculate(BinaryTree* tree);
int calculate(Node* node);

void printInfixNode(Node *node);
void printInfixForm(BinaryTree *tree);