#pragma once

struct QueueElement
{
	int value;
	QueueElement *next;
};

struct Queue
{
	QueueElement *head;
	QueueElement *tail;
};

Queue *createQueue();
void deleteQueue(Queue *queue);

void push(Queue *queue, int value);
int pop(Queue *queue);

void print(Queue* queue);

int getLastElement(Queue *queue);

bool isEmpty(Queue *queue); 
