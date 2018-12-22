#define _CRT_SECURE_NO_WARNINGS
#include "Huffman.h"
#include <fstream>
#include <iostream>
#include <string.h>
#include "BinaryTree.h"

using namespace std;


HuffmanCode *createHuffmanCode()
{
	HuffmanCode *newHuffmanCode = new HuffmanCode;
	
	newHuffmanCode->string = nullptr;
	newHuffmanCode->size = 0;
	newHuffmanCode->tree = nullptr;
	
	return newHuffmanCode;
}

char* concatenate(char* baseString, char addedSymbol)
{
	int length = strlen(baseString) + 1;
	char* concatenated = new char[length + 1];

	strcpy(concatenated, baseString);
	concatenated[length - 1] = addedSymbol;
	concatenated[length] = '\0';
	return concatenated;
}

HuffmanCode *loadFile(char *path)
{
	HuffmanCode *answer = createHuffmanCode();
	fstream file;
	file.open(path, ios::in);
	char* currentString = new char[1] {};
	char c = file.get();
	while (c != '#')
	{
		currentString = concatenate(currentString, c);
		file.get(c);
	}
	file.get();
	answer->tree = loadTree(currentString);
	answer->string = new char[stringSize];
	file.getline(answer->string, stringSize);
	std::cout << answer->string << "\n";
	answer->size = strlen(answer->string);
	file.close();
	return answer;
}

void decryptHuffman(HuffmanCode *huffman)
{
	decryptString(huffman->tree, huffman->string);
}

void saveOriginalFile(HuffmanCode *huffman, char *path)
{
	fstream file;
	file.open(path, ios::out);

	file << huffman->string << endl;
	
	file.close();
}


void deleteHuffmanCode(HuffmanCode *&huffman)
{
	delete[] huffman->string;
	deleteTree(huffman->tree);
	delete huffman;
	huffman = nullptr;
}