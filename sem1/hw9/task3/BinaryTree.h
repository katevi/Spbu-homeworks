
#pragma once

struct Tree;

int const stringSize = 1024;
int const maxSymbolCode = 256;


Tree *loadTree(char *string);
void decryptString(Tree *tree, char *&string);

void deleteTree(Tree *&tree);