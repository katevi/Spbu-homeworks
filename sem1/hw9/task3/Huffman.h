#pragma once

struct HuffmanCode;

HuffmanCode *loadFile(char *path);

void decryptHuffman(HuffmanCode *huffman);
void saveOriginalFile(HuffmanCode *huffman, char *path);

void deleteHuffmanCode(HuffmanCode *&huffman);