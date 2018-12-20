#include "aStar.h"
#include "graph.h"
#include <iostream>

int heuristicFunction(int x1, int y1, int x2, int y2)
{
	return (abs(x1 - x2) + abs(y1 - y2));
}

void printPath(Graph* graph)
{
	for (int j = 0; j < graph->height; j++)
	{
		for (int i = 0; i < graph->weight; i++)
		{
			if (graph->map[i][j] == 1000)
			{
				std::cout << "* ";
			}
			else
			{
				std::cout << graph->map[i][j] << " ";
			}
		}
		std::cout << "\n";
	}
}

void findMinimumDistance(int &x, int &y, int **heuristics, int **currents, int **used, int height, int weight)
{
	int minValue = infinity;
	for (int i = 0; i < weight; i++)
	{
		for (int j = 0; j < height; j++)
		{
			if ((minValue > heuristics[i][j]) && (!used[i][j] && currents[i][j]))
			{
				minValue = heuristics[i][j];
				x = i;
				y = j;
			}
		}
	}
}

void aStar(Graph* graph, int **used, int **distance, int **previous, int **heuristics, int **currents, int xStart, int yStart, int xFinish, int yFinish)
{
	distance[xStart][yStart] = 0;
	heuristics[xStart][yStart] = distance[xStart][yStart] + heuristicFunction(xStart, yStart, xFinish, yFinish);
	int xCurrent = xStart;
	int yCurrent = yStart;
	currents[xStart][yStart] = 1;
	for (int i = 0; i < graph->height * graph->weight; i++)
	{
		findMinimumDistance(xCurrent, yCurrent, heuristics, currents, used, graph->height, graph->weight);

		if (isEqualCoordinates(xCurrent, yCurrent, xFinish, yFinish))
		{
			used[xFinish][yFinish] = 1;
			break;
		}

		used[xCurrent][yCurrent] = 1;
		for (int dx = -1; dx <= 1; dx++)
		{
			for (int dy = -1; dy <= 1; dy++)
			{
				if ((dx * dx + dy * dy == 1) && (isInsideMap(xCurrent + dx, yCurrent + dy, graph->height, graph->weight)))
				{
					int nextX = xCurrent + dx;
					int nextY = yCurrent + dy;
					if ((!used[nextX][nextY]) && (graph->map[nextX][nextY] == 0) && (distance[xCurrent][yCurrent] + 1 < distance[nextX][nextY]))
					{
						setPrevious(previous, xCurrent, yCurrent, nextX, nextY);
						distance[nextX][nextY] = distance[xCurrent][yCurrent] + 1;
						heuristics[nextX][nextY] = distance[nextX][nextY] + heuristicFunction(nextX, nextY, xFinish, yFinish);
						currents[nextX][nextY] = 1;
					}
				}
			}
		}
	}

	if (!used[xFinish][yFinish])
	{
		std::cout << "No way";
		return;
	}

	graph->map[xFinish][yFinish] = 1000;
	while (getPrevious(xFinish, yFinish, previous) != -1000)
	{
		graph->map[xFinish][yFinish] = 1000;
	}
	graph->map[xFinish][yFinish] = 1000;
	printPath(graph);
}