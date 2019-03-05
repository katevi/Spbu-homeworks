#pragma once
#include "BinaryTree.h"

struct Node
{
	int key;
	Tree *value;
	Node *next;
};

struct PriorityQueue
{
	Node *head;
};

PriorityQueue *createPriorityQueue();

void insert(PriorityQueue *priorityQueue, int key, Tree *value);
Tree *pop(PriorityQueue *priorityQueue, int &key);
bool isEmpty(PriorityQueue *priorityQueue);

void deletePriorityQueue(PriorityQueue *&priorityQueue);