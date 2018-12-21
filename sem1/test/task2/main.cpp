#include <iostream>
#include <fstream>
#include "graph.h"
#include "list.h"

using namespace std;

bool isAllVisited(bool* used, int amount)
{
	for (int k = 0; k < amount; k++)
	{
		if (!used[k])
			return false;
	}
	return true;
}

int main()
{
	Graph* graph = createGraph("in.txt");
	bool* isUsed = new bool[graph->vertex];
	for (int i = 0; i < graph->vertex; i++)
	{
		isUsed[i] = false;
	}
	bool** allVisited = new bool*[graph->vertex];
	for (int i = 0; i < graph->vertex; i++)
	{
		allVisited[i] = new bool[graph->vertex];
	}
	for (int i = 0; i < graph->vertex; i++)
	{
		dfs(graph->vertices, graph->vertex, isUsed, i);
		//std::cout << "\n";
		for (int k = 0; k < graph->vertex; k++)
		{
			allVisited[k][i] = isUsed[k];
			isUsed[k] = false;
		}
	}
	bool isAchieved = false;
	for (int i = 0; i < graph->vertex; i++)
	{
		for (int j = 0; j < graph->vertex; j++)
		{
			std::cout <<  allVisited[j][i] << " ";
		}
		std::cout << "\n";
	}
	for (int i = 0; i < graph->vertex; i++)
	{
		isAchieved = true;
		for (int j = 0; j < graph->vertex; j++)
		{
			if (allVisited[i][j] == 0)
				isAchieved = false;
		}
		if (isAchieved == true)
			std::cout << i << " ";
	}
	for (int i = 0; i < graph->vertex; i++)
		delete[] allVisited[i];
	delete[] allVisited;
	delete[] isUsed;
	deleteGraph(graph);
	return 0;
}
