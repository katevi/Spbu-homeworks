#include <stdio.h>
#include "graph.h"
#include "aStar.h"
#include <iostream>
#include <fstream>


int main()
{
	Graph* graph = loadGraph("input.txt");

	int xStart = 0;
	int yStart = 0;
	std::cout << "Enter a starting point. x (from 0 to " << graph->weight - 1 << "), y (from 0 to " << graph->height - 1 << ")\n";
	std::cin >> xStart >> yStart;
	std::cout << "Enter an endpoint. x (from 0 to " << graph->weight - 1 << "), y (from 0 to " << graph->height - 1 << ")\n";
	int xFinish = 0;
	int yFinish = 0;
	std::cin >> xFinish >> yFinish;

	int **used = createAuxiliaryMatrix(graph->height, graph->weight, 0);
	int **distance = createAuxiliaryMatrix(graph->height, graph->weight, infinity);
	int **previous = createAuxiliaryMatrix(graph->height, graph->weight, -1000);
	int **heuristic = createAuxiliaryMatrix(graph->height, graph->weight, infinity);
	int **currents = createAuxiliaryMatrix(graph->height, graph->weight, 0);

	std::cout << "* - path algorithm founded:\n\n";
	aStar(graph, used, distance, previous, heuristic, currents, xStart, yStart, xFinish, yFinish);

	deleteAuxiliaryMatrix(used, graph->weight);
	deleteAuxiliaryMatrix(distance, graph->weight);
	deleteAuxiliaryMatrix(previous, graph->weight);
	deleteAuxiliaryMatrix(currents, graph->weight);
	deleteAuxiliaryMatrix(heuristic, graph->weight);

	deleteGraph(graph);
}

