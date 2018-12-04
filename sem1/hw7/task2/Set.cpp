#include "BalanceBinaryTree.h"
#include "Set.h"

Set* createSet()
{
	BinaryTree* tree = createTree();
	return new Set {tree};
}

void addElement(Set* set, int x)
{
	addNode(set->tree, x);
}

void deleteElement(Set* set, int x)
{
	removeNode(set->tree, x);
}

void removeSet(Set* set)
{
	removeTree(set->tree);
	delete set;
}

void preorderPrint(Set* set)
{
	preorderPrint(set->tree);
}

void descendingOrderPrint(Set* set)
{
	descendingOrderPrint(set->tree);
}

void ascendingOrderPrint(Set* set)
{
	ascendingOrderPrint(set->tree);
}
	