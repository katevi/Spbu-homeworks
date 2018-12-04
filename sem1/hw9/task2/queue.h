#pragma once
#include "HashTable.h"
#include "BinaryTree.h"

struct QueueElement
{
	BinaryTree* tree {nullptr};
	QueueElement *next;
};

struct Queue
{
	QueueElement *head;
	QueueElement *tail;
};

Queue *createQueue();
void deleteQueue(Queue *queue);

void push(Queue *queue, TableElement* element);
void push(Queue* queue, BinaryTree* tree);
QueueElement* pop(Queue *queue);

void print(Queue* queue);
int length(Queue *queue);

bool isEmpty(Queue *queue); 
