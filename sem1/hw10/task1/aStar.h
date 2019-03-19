#pragma once
#include "graph.h"

int heuristicFunction(int x1, int y1, int x2, int y2);
void aStar(Graph* graph, int **used, int **distance, int **previous, int **heuristics, int **currents, int xStart, int yStart, int xFinish, int yFinish);
void findMinimumDistance(int &x, int &y, int **heuristics, int **currents, int **used, int height, int weight);
void printPath(Graph* graph);