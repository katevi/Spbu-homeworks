#include "HashTable.h"
#include "String.h"

double loadFactor(HashTable* table)
{
	return  (double) table->currentSize / table->size;
}

int hash(String* string, int mod)
{
	int const prime = 7;
	int result = 0;
	for (int i = 0; i < length(string); i++)
	{
		result = ((result + (int)(string->string[i])) * prime) % mod;
	}
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
	deleteString(element->word);
	delete element;
}

void addElement(HashTable *table, String *string)
{
	int index = hash(string, table->size);
	TableElement *tmp = table->bucket[index];
	int attempt = 0;
	int shift = 0;
	while (tmp != nullptr)
	{
		attempt++;
		if (isSame(tmp->word, string))
		{
			tmp->countOfSame++;
			deleteString(string);
			return;
		}
		shift = attempt * attempt;
		tmp = table->bucket[(index + shift) % table->size];
	}

	TableElement *newElement = new TableElement;
	newElement->numberOfSamples = attempt;
	newElement->countOfSame = 1;
	newElement->word = string;
	newElement->nextElement = table->bucket[(index + shift) % table->size];
	table->bucket[(index + shift) % table->size] = newElement;
	table->currentSize++;
	//debugPrinting(hashTable, index, shift, attempt);
}

void debugPrinting(HashTable* table, int index, int shift, int attempt)
{
	std::cout << table->bucket[index + shift]->word->string << " index=" << index << " shift=" << shift << " attempt=" << attempt << " finalIndex=" << (index + shift) % table->size << "\n";
}

bool exists(HashTable* table, String* string)
{
	int index = hash(string, table->size);
	TableElement* tmp = table->bucket[index];
	if (table->bucket[index] == nullptr)
	{
		return false;
	}
	else
	{
		if (isSame(table->bucket[index]->word, string))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

int numberOfWords(HashTable* table)
{
	int result = 0;
	for (int i = 0; i < table->size; i++)
	{
		if (table->bucket[i] != nullptr)
		{
			result = result + table->bucket[i]->countOfSame;
		}
	}
	return result;
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

void outputWordWithMaxSample(HashTable* table)
{
	int max = 0;
	for (int i = 0; i < table->size; i++)
	{
		if (table->bucket[i] != nullptr)
		{
			if (table->bucket[i]->numberOfSamples > max)
			{
				max = table->bucket[i]->numberOfSamples;
			}
		}
	}
	std::cout << "Max sample = " << max << "\n";
	std::cout << "Words with max number of sample:\n";
	for (int i = 0; i < table->size; i++)
	{
		if (table->bucket[i] != nullptr)
		{
			if (max == table->bucket[i]->numberOfSamples)
			{
				std::cout << table->bucket[i]->word->string << "\n";
			}
		}
	}
}
