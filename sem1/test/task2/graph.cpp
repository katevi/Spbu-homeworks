#include "graph.h"
#include "list.h"
#include <iostream>
#include <fstream>

using namespace std;

Graph* createGraph(const char* path)
{
	ifstream fin;
	fin.open("in.txt");
	Graph* graph = new Graph;
	if (!fin.good())
	{
		cout << "error, file not opened";
		//return;
	}
	int vertex = 0;
	int edge = 0;
	fin >> graph->vertex >> graph->edge;
	int **adjacencyMatrix = new int*[edge];
	bool *isUsed = new bool[vertex];
	for (int i = 0; i < vertex; i++)
	{
		isUsed[i] = false;
	}

	for (int i = 0; i < edge; i++)
		adjacencyMatrix[i] = new int[vertex];

	for (int i = 0; i < vertex; i++)
		for (int j = 0; j < edge; j++)
			fin >> adjacencyMatrix[j][i];
	for (int i = 0; i < vertex; i++)
	{
		for (int j = 0; j < edge; j++)
			std::cout << adjacencyMatrix[j][i];
		std::cout << "\n";
	}
	fin.close();
	return graph;
}

void dfs(List** adjacencyMatrix, int amount, bool* isUsed, int current)
{
	if (isUsed[current])
		return;

	isUsed[current] = true;
	std::cout << current + 1 << ' ';
	ListElement* currentElement = adjacencyMatrix[current]->first;
	int i = 0;
	while (currentElement)
	{
		if (!isUsed[i])
		{
			dfs(adjacencyMatrix, amount, isUsed, i);
		}
		currentElement = currentElement->next;
		i++;
	}
}

void deleteGraph(Graph* graph)
{

	for (int i = 0; i < graph->vertex; i++)
		delete[] graph->vertices[i];
	delete[] graph->vertices;
}

/*void dijkstra(Graph *graph)
{
	createSupportArray(graph);

	bool *flag = new bool[graph->size];
	for (int i = 0; i < graph->size; i++)
		flag[i] = false;

	int min = 0;
	while (min < graph->size)
	{
		flag[min] = true;
		for (int i = 0; i < graph->size; i++)
		{
			int len = graph->matrix[min][i];
			if ((len != 0) && (graph->length[i] > graph->length[min] + len))
			{
				graph->length[i] = graph->length[min] + len;
				graph->way[i] = min;
			}
		}

		while ((min < graph->size) && !((flag[min] == false) && (graph->length[min] != INT_MAX)))
			min++;
	}

	delete[] flag;
}*/