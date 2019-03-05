#include <iostream>
#include <fstream>
#include "list.h"
#include "graph.h"

using namespace std;

int main()
{
	Graph* graph = load("input.txt");
	findAccessory(graph);
	printStates(graph);
	deleteGraph(graph);
}