#include <iostream>
#include "Huffman.h"

using namespace std;

int main()
{
	char input[] = "text.txt";
	HuffmanCode *huffman = readFile(input);

	char output[] = "huffmanCode.txt";
	performHuffman(huffman);
	saveFile(huffman, output);
	deleteHuffmanCode(huffman);
	return 0;
}