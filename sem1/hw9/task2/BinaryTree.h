#pragma once

struct Tree;

Tree *createTree(char symbol);
Tree *mergeTrees(Tree *&left, Tree *&right);

char *outputABC(Tree *tree);
int *countCodes(Tree *tree);

void deleteTree(Tree *&tree);