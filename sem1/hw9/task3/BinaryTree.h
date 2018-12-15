
#pragma once

struct Tree;

Tree *loadTree(char *string);
void decryptString(Tree *tree, char *&string);

void deleteTree(Tree *&tree);