#pragma once
#include "BinaryTree.h"

struct PriorityQueue;

PriorityQueue *createPriorityQueue();

void insert(PriorityQueue *priorityQueue, int key, Tree *value);
Tree *extractMinimum(PriorityQueue *priorityQueue, int &key);
bool isEmpty(PriorityQueue *priorityQueue);

void deletePriorityQueue(PriorityQueue *&priorityQueue);