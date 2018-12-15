#define _CRT_SECURE_NO_WARNINGS
#include "Huffman.h"
#include <fstream>
#include <stdio.h>
#include <string.h>
#include "queue.h"
#include "BinaryTree.h"

using namespace std;

int const stringSize = 1024;
int const charSize = 256;

struct HuffmanCode
{
	char *string;
	int size;
	Tree *tree;
};


HuffmanCode *createHuffmanCode()
{
	HuffmanCode *newHuffmanCode = new HuffmanCode;
	
	newHuffmanCode->string = nullptr;
	newHuffmanCode->size = 0;
	newHuffmanCode->tree = nullptr;
	
	return newHuffmanCode;
}

HuffmanCode *readFile(char *path)
{
	HuffmanCode *answer = createHuffmanCode();
	fstream file;
	file.open(path, ios::in);

	answer->string = new char[stringSize];
	file.getline(answer->string, stringSize);
	answer->size = strlen(answer->string);
	
	file.close();
	return answer;
}


int *countFrequency(HuffmanCode *huffman)
{
	int *frequency = new int[charSize];

	for (int i = 0; i < charSize; i++)
		frequency[i] = 0;

	for (int i = 0; i < huffman->size; i++)
		frequency[(unsigned char)huffman->string[i]]++;
	
	return frequency;
}

void performHuffman(HuffmanCode *huffman)
{
	int *frequency = countFrequency(huffman);
	
	PriorityQueue *queue = createPriorityQueue();
	for (int i = 0; i < charSize; i++)
		if (frequency[i] != 0)
			insert(queue, frequency[i], createTree(i));
	
	delete[] frequency;
	
	int key = 0;
	Tree *tree = extractMinimum(queue, key);
	while (!isEmpty(queue))
	{
		int tempKey = 0;
		Tree *temp = extractMinimum(queue, tempKey);
		tree = mergeTrees(tree, temp);
		key += tempKey;
		insert(queue, key, tree);
		tree = extractMinimum(queue, key);
	}
	
	huffman->tree = tree;
	deletePriorityQueue(queue);
}

char *codeToChar(int number)
{
	char *answer = new char[stringSize];
	char *temp = new char[stringSize];

	sprintf(temp, "%d", number);
	temp++;
	strcpy(answer, temp);
	temp--;
	delete[] temp;

	return answer;
}

void saveFile(HuffmanCode *huffman, char *path)
{
	fstream file;
	file.open(path, ios::out);
	
	char *temp = outputABC(huffman->tree);
	file << temp << endl;
	delete[] temp;
	
	int *codes = countCodes(huffman->tree);
	for (int i = 0; i < huffman->size; i++)
	{
		unsigned char symbol = huffman->string[i];
		char *temp = codeToChar(codes[symbol]);
		file << temp;
		delete[] temp;
	}

	delete[] codes;
	file.close();
}


void deleteHuffmanCode(HuffmanCode *&huffman)
{
	delete[] huffman->string;
	deleteTree(huffman->tree);
	delete huffman;
	huffman = nullptr;
}