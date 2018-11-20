#pragma once
#include <stdio.h>
#include <iostream>
#include "BinaryTree.h"

struct Set{
	BinaryTree* tree;
};

Set* createSet();
void addElement(Set* set);
void deleteElement(Set* set);
void removeSet(Set* set);
void preorderPrint(Set* set);
void descendingOrderPrint(Set* set);
void ascendingOrderPrint(Set* set);
