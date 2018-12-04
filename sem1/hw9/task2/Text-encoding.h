#pragma once
#include <iostream>
#include <fstream>
#include "HashTable.h"
#include "queue.h"
#include "BinaryTree.h"

using namespace std;

void readingFromFile(ifstream &file, HashTable* table, Queue* queue);
void writingToFile(ifstream &inputFile, ofstream &outputFile, String* arrayOfCodes[], HashTable* table, BinaryTree* tree);