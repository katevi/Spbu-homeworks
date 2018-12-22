
#pragma once

struct Tree;

int const stringSize = 256;
int const textSize = 1024;
int const maxSymbolCode = 256;


Tree *loadTree(char *string);
void decryptString(Tree *tree, char *&string);
void descendingOrderPrint(Tree* tree);
void deleteTree(Tree *&tree);