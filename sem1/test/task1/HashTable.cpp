#include "HashTable.h"
#include "String.h"

double loadFactor(HashTable* table)
{
	return  (double) table->currentSize / table->size;
}

int hash(int number, int mod)
{
	int const prime = 7;
	int result = 0;
	if (number < 0)
		result = mod / 2 - abs(number) % mod;
	if (number >= 0)
		result = abs(number) % mod + mod / 2;
	return result;
}

HashTable* createTable()
{
	HashTable* table = new HashTable;
	table->bucket = new TableElement*[table->size];
	for (int i = 0; i < table->size; i++)
	{
		table->bucket[i] = nullptr;
	}
	return table;
}

void deleteTable(HashTable* table)
{
	for (int i = 0; i < table->size; i++)
	{
		if (table->bucket[i] != nullptr)
		{
			deleteElement(table->bucket[i]);
		}
	}
	delete[] table->bucket;
	delete table;
}

void deleteElement(TableElement* element)
{
	if (element == nullptr)
	{
		return;
	}
	delete element->nextElement;
	delete element;
}

void addElement(HashTable *table, int value)
{
	int index = hash(value, table->size);
	TableElement *tmp = table->bucket[index];
	int attempt = 0;
	int shift = 0;
	while (tmp != nullptr)
	{
		attempt++;
		if (tmp->value == value)
		{
			tmp->countOfSame++;
			return;
		}
		shift = attempt * attempt;
		tmp = table->bucket[(index + shift) % table->size];
	}

	TableElement *newElement = new TableElement;
	newElement->numberOfSamples = attempt;
	newElement->countOfSame = 1;
	newElement->value = value;
	newElement->nextElement = table->bucket[(index + shift) % table->size];
	table->bucket[(index + shift) % table->size] = newElement;
	table->currentSize++;
}

bool exists(HashTable* table, int value)
{
	int index = hash(value, table->size);
	TableElement* tmp = table->bucket[index];
	if (table->bucket[index] == nullptr)
	{
		return false;
	}
	else
	{
		if (table->bucket[index]->value == value)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

void printNumberOfWords(HashTable* table)
{
	for (int i = 0; i < table->size; i++)
	{
		if (table->bucket[i] != nullptr)
		{
			std::cout << table->bucket[i]->value << ":" << table->bucket[i]->countOfSame << "\n";
		}
	}
}

int emptyCells(HashTable* table)
{
	int result = 0;
	for (int i = 0; i < table->size; i++)
	{
		if (table->bucket[i] == nullptr)
		{
			result++;
		}
	}
	return result;
}

double averageNumberOfSamples(HashTable* table)
{
	int result = 0;
	for (int i = 0; i < table->size; i++)
	{
		if (table->bucket[i] != nullptr)
		{
			result = result + table->bucket[i]->numberOfSamples;
		}
	}
	return (double) result / (table->size - emptyCells(table));
}
