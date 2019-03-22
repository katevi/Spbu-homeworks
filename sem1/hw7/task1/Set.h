#pragma once
#include <stdio.h>
#include <iostream>
#include "BinaryTree.h"

struct Set{
	BinaryTree* tree;
};

Set* createSet();
void addElement(Set* set, int x);
void deleteElement(Set* set, int x);
void removeSet(Set* set);
void preorderPrint(Set* set);
void descendingOrderPrint(Set* set);
void ascendingOrderPrint(Set* set);
