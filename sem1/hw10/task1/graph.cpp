#include "graph.h"
#include <fstream>
#include <iostream>

using namespace std;

Graph* loadGraph(const char* path)
{
	Graph* graph = new Graph;
	ifstream file(path);
	file >> graph->weight >> graph->height;
	graph->map = new int*[graph->weight];
	for (int i = 0; i < graph->weight; i++)
		graph->map[i] = new int[graph->height];
	for (int i = 0; i < graph->height; i++)
	{
		for (int j = 0; j < graph->weight; j++)

			file >> graph->map[j][i];
	}
	file.close();
	return graph;
}

void deleteGraph(Graph* graph)
{
	for (int i = 0; i < graph->weight - 1; i++)
	{
		delete[] graph->map[i];
	}
	delete[] graph->map;
	delete graph;
}

bool isEqualCoordinates(int x1, int y1, int x2, int y2)
{
	return (x1 == x2 && y1 == y2);
}

bool isInsideMap(int x, int y, int height, int weight)
{
	return (0 <= x) && (x < weight) && (0 <= y) && (y < height);
}

void setPrevious(int** previous, int xPrevious, int yPrevious, int xCurrent, int yCurrent)
{
	enum previousDirection {up, down, left, right};
	if (xCurrent == xPrevious)
	{
		if (yCurrent > yPrevious)
		{
			previous[xCurrent][yCurrent] = left;
		}
		else
		{
			previous[xCurrent][yCurrent] = right;
		}
	}
	else
	{
		if (xCurrent > xPrevious)
		{
			previous[xCurrent][yCurrent] = up;
		}
		else
		{
			previous[xCurrent][yCurrent] = down;
		}
	}
}

int getPrevious(int &x, int &y, int** previous)
{
	enum previousDirection {up, down, left, right};
	int result = previous[x][y];
	switch (result)
	{
	case right:
	{
		y++;
		break;
	}
	case left:
	{
		y--;
		break;
	}
	case up:
	{
		x--;
		break;
	}
	case down:
	{
		x++;
		break;
	}
	}
	return result;
}

int** createAuxiliaryMatrix(int height, int weight, int initializationElement)
{
	int** newMatrix = new int*[weight];
	for (int i = 0; i < weight; i++)
	{
		newMatrix[i] = new int[height];
	}
	for (int j = 0; j < height; j++)
	{
		for (int i = 0; i < weight; i++)
		{
			newMatrix[i][j] = initializationElement;
		}
	}
	return newMatrix;
}

void deleteAuxiliaryMatrix(int ** matrix, int weight)
{
	for (int i = 0; i < weight; i++)
	{
		delete[] matrix[i];
	}
	delete[] matrix;
}

bool inside(int x, int y, int n, int m)
{
	return (0 <= x) && (x < n) && (0 <= y) && (y < m);
}

