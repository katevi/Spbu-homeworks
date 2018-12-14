#pragma once
#include "String.h"
#include <stdio.h>
#include <iostream>

struct TableElement {
	int value;
	int countOfSame;
	TableElement* nextElement;
	int numberOfSamples;
};

struct HashTable {
	const int size = 10007; 
	int currentSize = 0;
	TableElement** bucket;
};

HashTable* createTable();
void deleteTable(HashTable* table);

double loadFactor(HashTable* table);

int hash(int value, int mod);

void addElement(HashTable* table, int value);
void deleteElement(TableElement* element);

bool exists(HashTable* table, int value);

void printNumberOfWords(HashTable* table);

int emptyCells(HashTable* table);
double averageNumberOfSamples(HashTable* table);