#pragma once
#include <iostream>
#include "list.h"

struct Graph
{
	List** vertices;
	int vertex;
	int edge;
};

void dfs(List** adjacencyMatrix, int amount, bool* &isUsed, int &current);

Graph* createGraph(const char* path);
void deleteGraph(Graph* graph);
//void dijkstra(Graph *graph);