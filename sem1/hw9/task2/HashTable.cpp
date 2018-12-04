#include "HashTable.h"
#include "String.h"

int hash(char symbol, int mod)
{
	int result = 0;
	result = int(symbol) % mod;
	return result ;
}

HashTable* createTable()
{
	HashTable* table = new HashTable;
	for (int i = 0; i < table->size; i++)
		table->bucket[i].countOfSame = 0;
	return table;
}

void deleteTable(HashTable* table)
{
	delete[] table->bucket;
	delete table;
}

void deleteElement(TableElement* element)
{
	if (element == nullptr)
	{
		return;
	}
	delete element;
}

void addElement(HashTable *&table, char symbol)
{
	int index = hash(symbol, table->size);
	table->bucket[index].countOfSame++;
	table->bucket[index].symbol = symbol;

}

int numberOfSymbols(HashTable* table)
{
	int numberOfSymbols = 0;
	for (int i = 0; i < table->size; i++)
	{
		if (table->bucket[i].countOfSame != 0)
			numberOfSymbols++;
	}
	return numberOfSymbols;
}

void printNumberOfWords(HashTable* table)
{
	std::cout << "Number of occurrences of each word in the text:\n";
	for (int i = 0; i < table->size; i++)
	{
		if (table->bucket[i].countOfSame != 0)
			std::cout << table->bucket[i].symbol << ":" << table->bucket[i].countOfSame << "\n";
	}
}

