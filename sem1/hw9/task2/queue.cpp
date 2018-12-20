#include "queue.h"
#include "BinaryTree.h"

PriorityQueue *createPriorityQueue()
{
	PriorityQueue *newPriorityQueue = new PriorityQueue;
	newPriorityQueue->head = nullptr;
	return newPriorityQueue;
}


Node *createNode(int key, Tree *value, Node *next)
{
	Node *newNode = new Node;
	newNode->key = key;
	newNode->value = value;
	newNode->next = next;
	return newNode;
}

void insert(PriorityQueue *priorityQueue, int key, Tree *value)
{
	if (isEmpty(priorityQueue))
	{
		priorityQueue->head = createNode(key, value, nullptr);
		return;
	}

	if (priorityQueue->head->key > key)
	{
		priorityQueue->head = createNode(key, value, priorityQueue->head);
		return;
	}

	Node *temp = priorityQueue->head;
	while ((temp->next != nullptr) && (temp->next->key < key))
		temp = temp->next;

	temp->next = createNode(key, value, temp->next);
}

Tree *pop(PriorityQueue *priorityQueue, int &key)
{
	if (isEmpty(priorityQueue))
		return nullptr;

	Node *temp = priorityQueue->head;
	Tree *answer = temp->value;
	key = temp->key;
	priorityQueue->head = temp->next;
	delete temp;

	return answer;
}

bool isEmpty(PriorityQueue *priorityQueue)
{
	return priorityQueue->head == nullptr;
}


void deletePriorityQueue(PriorityQueue *&priorityQueue)
{
	Node *temp = priorityQueue->head;

	while (temp != nullptr)
	{
		Node *toDelete = temp;
		temp = temp->next;
		deleteTree(toDelete->value);
		delete toDelete;
	}

	delete priorityQueue;
	priorityQueue = nullptr;
}