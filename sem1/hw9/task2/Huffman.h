#pragma once

int const stringSize = 1024;
int const maximumCharCode = 256;

struct HuffmanCode;

HuffmanCode *readFile(char *path);

void performHuffman(HuffmanCode *huffman);
void saveFile(HuffmanCode *huffman, char *path);

void deleteHuffmanCode(HuffmanCode *&huffman);