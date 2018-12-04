#pragma once
#include <stdio.h>
#include <iostream>
#include "HashTable.h"
#include <fstream>

using namespace std;

struct Node {
	TableElement* element;
	Node *left;
	Node *right;
};

struct  BinaryTree {
	Node *root;
};

BinaryTree *createTree();
void removeTree(BinaryTree* tree);
void removeTree(Node* node);

void addNode(Node* &node, TableElement* element);
void addNode(BinaryTree* &tree, TableElement* x);
String **codes(BinaryTree* tree, int tableSize);

void ascendingOrderPrint(Node* node);
void ascendingOrderPrint(BinaryTree* tree);
void preorderPrint(Node* node, ofstream &file);
void preorderPrint(BinaryTree* tree, ofstream &file);

BinaryTree* mergeTree(BinaryTree* tree1, BinaryTree* tree2);
bool isLeaf(Node* node);