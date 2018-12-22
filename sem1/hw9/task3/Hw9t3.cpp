#include <iostream>
#include "Huffman.h"
#include "BinaryTree.h"
using namespace std;

int main()
{
	char input[] = "huffmanCode.txt";
	HuffmanCode *huffman = loadFile(input);
	//std::cout << huffman->tree << "\n";
	//Tree* tree = loadTree(huffman->string);
	descendingOrderPrint(huffman->tree);
	decryptHuffman(huffman);
	char output[] = "text.txt";
	saveOriginalFile(huffman, output);
	system("pause");
	deleteHuffmanCode(huffman);
}