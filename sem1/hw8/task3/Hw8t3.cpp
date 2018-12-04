#include <iostream>
#include "HashTable.h"
#include "String.h"
#include <fstream>

using namespace std;

bool isLetter(char symbol)
{
	return (symbol >= 'a' && symbol <= 'z' || symbol >= 'A' && symbol <= 'Z');
}

int main()
{
	HashTable* table = createTable();
	ifstream file;
	char nameOfFile[] = "text.txt";
	file.open(nameOfFile, ios::out);
	char* wordChar = new char[100];
	int count = 0;
	while (!file.eof())
	{
		file >> wordChar;
		String* wordWithSymbol = createString(wordChar);
		int i = 0;
		for (i = 0; i < length(wordWithSymbol); i++)
		{
			if (!isLetter(wordWithSymbol->string[i]))
			{
				break;
			}
		}
		String* wordWithoutSymbol = createSubstring(wordWithSymbol, 0, i - 1);
		if (wordWithoutSymbol->length > 0)
		{
			addElement(table, wordWithoutSymbol);
		}
		deleteString(wordWithSymbol);
	}
	printNumberOfWords(table);
	std::cout << "LoadFactor: " << loadFactor(table) << "\n";
	std::cout << "Number of words: " << numberOfWords(table) << "\n";
	std::cout << "Number of empty cells: " << emptyCells(table) << "\n";
	std:cout << "Average number of samples:" << averageNumberOfSamples(table) << "\n";
	outputWordWithMaxSample(table);
	delete[] wordChar;
	deleteTable(table);
	file.close();
}