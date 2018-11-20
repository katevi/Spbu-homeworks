#pragma once
#include <stdio.h>
#include <iostream>
#include "BalanceBinaryTree.h"

struct Set {
	BinaryTree* tree;
};

Set* createSet();
void removeSet(Set* set);

void addElement(Set* set);
void deleteElement(Set* set);

void preorderPrint(Set* set);
void descendingOrderPrint(Set* set);
void ascendingOrderPrint(Set* set);

