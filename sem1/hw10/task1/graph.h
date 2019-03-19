#pragma once

struct Graph{
	int** map;
	int height;
	int weight;
};

const int infinity = 100000;
Graph* loadGraph(const char* path);
void deleteGraph(Graph* graph);

bool isEqualCoordinates(int x1, int y1, int x2, int y2);

bool isInsideMap(int x, int y, int height, int weight);

void setPrevious(int** previous, int xCurrent, int yCurrent, int xPrevious, int yPrevious);
int getPrevious(int &x, int &y, int** previous);

int** createAuxiliaryMatrix(int height, int weight, int initializationElement);
void deleteAuxiliaryMatrix(int ** matrix, int weight);
