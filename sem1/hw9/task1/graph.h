#pragma once
#include "list.h"
#include <fstream>

using namespace std;

struct Graph
{
	List** cities;
	int size;
	int* accessory;
};

Graph* load(const char* path);
bool isIsolated(List* list, int* accessory);
bool isAllDistributed(int* accessory, int length);
bool isOwnedByCurrentCapital(int numberOfCity, int numberOfCapital, Graph* graph);
void joinCity(Graph* graph, List* state, int numberOfCapital);
bool isForeign(Graph* graph, int numberOfCity, int numberOfCapital);
void findAccessory(Graph* graph);
bool isCapital(int* accessory, int value);
void printStates(Graph* graph);
void deleteGraph(Graph* graph);