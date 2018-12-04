#include <iostream>
#include <fstream>
#include "HashTable.h"
#include "queue.h"
#include "BinaryTree.h"
#include "Text-encoding.h"

using namespace std;

int main()
{
	ifstream inputFile("text.txt");
	BinaryTree* tree = createTree();
	HashTable* table = createTable();
	Queue* queue = createQueue();
	readingFromFile(inputFile, table, queue);

	for (int i = 0; i < table->size; i++)
	{
		if (table->bucket[i].countOfSame != 0)
			push(queue, &table->bucket[i]);
	}

	while (length(queue) > 1)
	{
		tree = mergeTree(pop(queue)->tree, pop(queue)->tree);
		push(queue, tree);
	}

	String** arrayOfCodes = new String*[table->size];
	arrayOfCodes = codes(tree, table->size);

	inputFile.close();

	inputFile.open("text.txt");
	ofstream outputFile("output.txt");
	writingToFile(inputFile, outputFile, arrayOfCodes, table, tree);

	system("pause");
	inputFile.close();
	outputFile.close();
	for (int i = 0; i < table->size; i++)
	{
		if (arrayOfCodes[i] != nullptr)
			deleteString(arrayOfCodes[i]);
	}
	delete[] arrayOfCodes;
	deleteTable(table);
	deleteQueue(queue);
	removeTree(tree);
}