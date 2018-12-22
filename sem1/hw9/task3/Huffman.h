#pragma once
#include "BinaryTree.h"

struct HuffmanCode
{
	char *string;
	int size;
	Tree *tree;
};

HuffmanCode *loadFile(char *path);

void decryptHuffman(HuffmanCode *huffman);
void saveOriginalFile(HuffmanCode *huffman, char *path);

void deleteHuffmanCode(HuffmanCode *&huffman);