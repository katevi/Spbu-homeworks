#include <iostream>
#include "Huffman.h"
#include "BinaryTree.h"
using namespace std;

int main()
{
	char input[] = "huffmanCode.txt";
	HuffmanCode *huffman = loadFile(input);
	decryptHuffman(huffman);
	char output[] = "text.txt";
	saveOriginalFile(huffman, output);
	deleteHuffmanCode(huffman);
}