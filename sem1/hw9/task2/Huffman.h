#pragma once

struct HuffmanCode;

HuffmanCode *readFile(char *path);

void performHuffman(HuffmanCode *huffman);
void saveFile(HuffmanCode *huffman, char *path);

void deleteHuffmanCode(HuffmanCode *&huffman);