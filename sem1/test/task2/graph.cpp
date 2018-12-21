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
	}
	fin >> graph->vertex >> graph->edge;
	std::cout << graph->vertex << " " << graph->edge << "\n";
	int **adjacencyMatrix = new int*[graph->edge];
	for (int i = 0; i < graph->edge; i++)
		adjacencyMatrix[i] = new int[graph->vertex];

	for (int i = 0; i < graph->vertex; i++)
	{
		for (int j = 0; j < graph->edge; j++)
		{
			fin >> adjacencyMatrix[j][i];
		}
	}
	for (int i = 0; i < graph->vertex; i++)
	{
		for (int j = 0; j < graph->edge; j++)
		{
			std::cout << adjacencyMatrix[j][i];
		}
		std::cout << "\n";
	}
	int fromCity = -1;
	int toCity = -1;
	for (int i = 0; i < graph->vertex; i++)
	{
		graph->vertices[i] = createList();
	}
	for (int i = 0; i < graph->edge; i++)
	{
		for (int j = 0; j < graph->vertex; j++)
		{
			if (adjacencyMatrix[i][j] == 1)
			{
				fromCity = j;
			}
			if (adjacencyMatrix[i][j] == -1)
			{
				toCity = i;
			}
			if (fromCity != -1 && toCity != -1)
			{
				add(graph->vertices[fromCity], toCity);
			}
		}
	}
	for (int i = 0; i < graph->vertex; i++)
	{
		print(graph->vertices[i]);
	}
	for (int i = 0; i < graph->edge; i++)
	{
		delete[] adjacencyMatrix;
	}
	delete adjacencyMatrix;
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