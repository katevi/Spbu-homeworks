#include <iostream>
#include <fstream>
#include "graph.h"
#include "list.h"

using namespace std;

bool isAllVisited(bool* used, int amount)
{
	for (int i = 0; i < amount; i++)
	{
		if (used[i] == false)
			return false;
	}
	return true;
}

int main()
{
	Graph* graph = createGraph("in.txt");
	bool* isUsed = new bool[graph->vertex];
	/*for (int i = 0; i < graph->vertex; i++)
	{
		isUsed[i] = false;
	}*/
	/*for (int i = 0; i < graph->vertex; i++)
	{
		dfs(graph->vertices, graph->vertex, isUsed, 0);
		if (isAllVisited(isUsed, graph->vertex))
			std::cout << i << " ";
		for (int i = 0; i < graph->vertex; i++)
		{
			isUsed[i] = false;
		}
	}*/
	//deleteGraph(graph);
	system("pause");
	return 0;
}
