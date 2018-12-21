#include <iostream>
#include "String.h"
#include "HashTable.h"
#include <fstream>

using namespace std;

int const stringSize = 256;

void printStringsToFile(HashTable* table, ofstream &file)
{
	for (int i = 0; i < table->size; i++)
	{
		if (table->bucket[i] != nullptr)
		{
			file << table->bucket[i]->word->string << "\n";
		}
	}
}

int main()
{
	ifstream file("input.txt");
	char* currentString = new char[stringSize];
	HashTable* table = createTable();
	while (!file.eof())
	{
		file.getline(currentString, stringSize);
		String* string = createString(currentString);
		addElement(table, string);
	}
	ofstream output("output.txt");
	printStringsToFile(table, output);
	deleteTable(table);
	output.close();
	file.close();
}