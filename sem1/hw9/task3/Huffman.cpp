#include "Huffman.h"
#include <fstream>
#include <string.h>
#include "BinaryTree.h"

using namespace std;

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

HuffmanCode *loadFile(char *path)
{
	HuffmanCode *answer = createHuffmanCode();
	fstream file;
	file.open(path, ios::in);

	char *string = new char[stringSize];
	file.getline(string, stringSize);
	answer->tree = loadTree(string);
	delete[] string;

	answer->string = new char[stringSize];
	file.getline(answer->string, stringSize);
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