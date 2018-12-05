#include <iostream>
#include "Text-encoding.h"
#include "HashTable.h"
#include "BinaryTree.h"

using namespace std;

void fromFileToTable(ifstream &file, HashTable* &table)
{
	char currentSymbol;
	file >> currentSymbol;
	while (!file.eof())
	{
		addElement(table, currentSymbol);
		file.get(currentSymbol);
	}
}

void fromTableToQueue(HashTable* table, Queue* queue)
{
	for (int i = 0; i < table->size; i++)
	{
		if (table->bucket[i].countOfSame != 0)
			push(queue, &table->bucket[i]);
	}
}

void readingFromFile(ifstream &file, HashTable* table, Queue* queue)
{
	fromFileToTable(file, table);
	fromTableToQueue(table, queue);
}

void writingToFile(ifstream &inputFile, ofstream &outputFile, String* arrayOfCodes[], HashTable* table, BinaryTree* tree)
{
	preorderPrint(tree, outputFile);
	outputFile << endl;
	char currentSymbol;
	inputFile.get(currentSymbol);
	while (!inputFile.eof())
	{
		for (int i = 0; i < table->size; i++)
		{
			if (int(currentSymbol) == i)
			{
				outputFile << arrayOfCodes[i]->string << " ";
			}
		}
		inputFile.get(currentSymbol);
	}
}