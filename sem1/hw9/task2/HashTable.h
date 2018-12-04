#pragma once
#include "String.h"
#include <stdio.h>
#include <iostream>

struct TableElement {
	char symbol;
	int countOfSame;
};

struct HashTable {
	const int size = 307; 
	int currentSize = 0;
	TableElement* bucket = new TableElement[size];
};

HashTable* createTable();
void deleteTable(HashTable* table);

int hash(char symbol, int mod);

void addElement(HashTable* &table, char symbol);
void deleteElement(TableElement* element);

void printNumberOfWords(HashTable* table);
int numberOfSymbols(HashTable* table);
