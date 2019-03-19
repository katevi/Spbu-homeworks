#pragma once

int const textSize = 2048;
int const stringSize = 256;
int const maximumCharCode = 256;

struct HuffmanCode;

HuffmanCode *readFile(char *path);
void performHuffman(HuffmanCode *huffman);
void saveFile(HuffmanCode *huffman, char *path);

void deleteHuffmanCode(HuffmanCode *&huffman);