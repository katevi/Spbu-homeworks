#pragma once
#include "String.h"
#include <stdio.h>
#include <iostream>

struct TableElement {
	String* word;
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

int hash(String* string, int mod);

void addElement(HashTable* table, String* string);
void deleteElement(TableElement* element);

bool exists(HashTable* table, String* string);

void printNumberOfWords(HashTable* table);

int numberOfWords(HashTable* table);
int emptyCells(HashTable* table);
double averageNumberOfSamples(HashTable* table);
void outputWordWithMaxSample(HashTable* table);

void debugPrinting(HashTable* table, int index, int shift, int attempt);