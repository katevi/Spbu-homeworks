#pragma once
#include <stdio.h>
#include <iostream>
#include "BalanceBinaryTree.h"

struct Set {
	BinaryTree* tree;
};

Set* createSet();
void removeSet(Set* set);

void addElement(Set* set, int x);
void deleteElement(Set* set, int x);

void preorderPrint(Set* set);
void descendingOrderPrint(Set* set);
void ascendingOrderPrint(Set* set);

