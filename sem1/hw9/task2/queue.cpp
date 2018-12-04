#include "queue.h"
#include "BinaryTree.h"

Queue *createQueue()
{
	Queue *newQueue = new Queue;
	newQueue->head = nullptr;
	newQueue->tail = nullptr;
	return newQueue;
}

void deleteQueue(Queue *queue)
{
	while (!isEmpty(queue))
	{
		pop(queue);
	}
	delete queue;
}

void print(Queue* queue)
{
	QueueElement* current = queue->head;
	while (current)
	{
		std::cout << current->tree->root->element->symbol << " ";
		current = current->next;
	}
}

void push(Queue* queue, BinaryTree* tree)
{
	QueueElement* current = queue->head;
	if ((queue->head == nullptr) || (current->tree->root->element->countOfSame > tree->root->element->countOfSame))
	{
		QueueElement* newElement = new QueueElement{ tree, queue->head };
		queue->head = newElement;
		return;
	}
	while ((current->next) && (current->next->tree->root->element->countOfSame <= tree->root->element->countOfSame))
	{
		current = current->next;
	}
	QueueElement* newElement = new QueueElement {tree, current->next};
	current->next = newElement;
}

void push(Queue *queue, TableElement* element)
{
	BinaryTree* newTree = createTree();
	addNode(newTree, element);
	QueueElement* current = queue->head;
	if ((queue->head == nullptr) || (current->tree->root->element->countOfSame > element->countOfSame))
	{
		QueueElement* newElement = new QueueElement{newTree, queue->head};
		queue->head = newElement;
		return;
	}
	while ((current->next) && (current->next->tree->root->element->countOfSame <= element->countOfSame))
	{
		current = current->next;
	}
	QueueElement* newElement = new QueueElement {newTree, current->next};
	current->next = newElement;
}

QueueElement* pop(Queue *queue)
{
	QueueElement* element = new QueueElement {queue->head->tree, nullptr };
	QueueElement *tmp = queue->head->next;
	delete queue->head;
	queue->head = tmp;
	return element;
}

bool isEmpty(Queue *queue)
{
	return queue->head == nullptr;
}

int length(Queue *queue)
{
	int result = 0;
	QueueElement *currentElement = queue->head;
	while (currentElement != nullptr)
	{
		currentElement = currentElement->next;
		result++;
	}
	return result;
}
