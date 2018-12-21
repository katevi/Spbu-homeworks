#include <iostream>
#include "String.h"
#include "HashTable.h"
#include <fstream>

using namespace std;

int const stringSize = 256;


void sort(char** strings, HashTable* table)
{
	char* temp = 0;
	for (int i = 0; i < table->currentSize - 1; i++) {
		for (int j = 0; j < table->currentSize - i - 1; j++) {
			if (strcmp(strings[j], strings[j + 1]) == 1)
			{
				temp = strings[j];
				strings[j] = strings[j + 1];
				strings[j + 1] = temp;
			}
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
	char** strings = new char*[table->currentSize];
	int k = 0;
	for (int i = 0; i < table->size; i++)
	{
		if (table->bucket[i] != nullptr)
		{
			strings[k] = table->bucket[i]->word->string;
			k++;
		}
	}
	sort(strings, table);
	for (int i = 0; i < table->currentSize; i++)
	{
		output << strings[i] << endl;
	}

	delete[] strings;
	delete[] currentString;
	deleteTable(table);
	output.close();
	file.close();
}