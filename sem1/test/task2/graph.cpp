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
	graph->vertices = new List*[graph->vertex];
	//std::cout << graph->vertex << " " << graph->edge << "\n";
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
	/*for (int i = 0; i < graph->vertex; i++)
	{
		for (int j = 0; j < graph->edge; j++)
		{
			std::cout << adjacencyMatrix[j][i];
		}
		std::cout << "\n";
	}*/
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
				toCity = j;
			}
			if (fromCity != -1 && toCity != -1)
			{
				add(graph->vertices[fromCity], toCity);
				fromCity = -1;
				toCity = -1;
			}
		}
	}
	for (int i = 0; i < graph->edge; i++)
	{
		delete[] adjacencyMatrix[i];
	}
	delete adjacencyMatrix;
	fin.close();
	return graph;
}

void dfs(List** adjacencyMatrix, int amount, bool* &isUsed, int &current)
{
	isUsed[current] = true;
	//std::cout << current << ' ';
	ListElement* currentElement = adjacencyMatrix[current]->first;
	while (currentElement)
	{
		if (!(isUsed[currentElement->value]))
		{
			//std::cout << currentElement->value;
			dfs(adjacencyMatrix, amount, isUsed, currentElement->value);
		}
		currentElement = currentElement->next;
	}
}

void deleteGraph(Graph* graph)
{

	for (int i = 0; i < graph->vertex; i++)
	{
		deleteList(graph->vertices[i]);
	}
	delete[] graph->vertices;

}