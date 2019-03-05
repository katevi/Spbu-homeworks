#pragma once

struct Tree;

Tree *createTree(char symbol);
Tree *mergeTrees(Tree *&left, Tree *&right);

char *printTreeToFile(Tree *tree);
int *countCodes(Tree *tree);

void deleteTree(Tree *&tree);