#include "graph.h"
#include "list.h"
#include <iostream>

Graph* load(const char* path)
{
	ifstream file(path);
	int numberOfCities = 0;
	int numberOfRoads = 0;
	file >> numberOfCities >> numberOfRoads;
	Graph* graph = new Graph {nullptr};
	graph->cities = new List*[numberOfCities];
	graph->size = numberOfCities;
	for (int k = 0; k < numberOfCities; k++)
	{
		graph->cities[k] = createList();
	}
	int lengthOfRoad = 0;
	int i = 0;
	int j = 0;
	for (int k = 0; k < numberOfRoads; k++)
	{
		file >> i >> j >> lengthOfRoad;
		add(graph->cities[i], j, lengthOfRoad);
		add(graph->cities[j], i, lengthOfRoad);
	}
	int numberOfCapitals = 0;
	file >> numberOfCapitals;
	graph->accessory = new int[graph->size];
	for (int k = 0; k < graph->size; k++)
		graph->accessory[k] = -1;
	int numberOfCurrentCapital = 0;
	for (int k = 0; k < numberOfCapitals; k++)
	{
		file >> numberOfCurrentCapital;
		graph->accessory[numberOfCurrentCapital] = numberOfCurrentCapital;
	}
	file.close();
	return graph;
}

bool isAllDistributed(int* accessory, int length)
{
	//if all cities belongs states
	for (int i = 0; i < length; i++)
	{
		if (accessory[i] == -1)
			return false;
	}
	return true;
}

bool isIsolated(List* list, int* accessory)
{
	//if city has not distributed neighbours
	ListElement* current = list->first;
	while (current)
	{
		if (accessory[current->city] == -1)
		{
				return false;
		}
		current = current->next;
	}
	return true;
}

bool isOwnedByCurrentCapital(int numberOfCity, int numberOfCapital, Graph* graph)
{
	//checking city belongs to the current capital
	return ((graph->accessory[numberOfCity] == numberOfCapital));
}

bool isCapital(int* accessory, int value)
{
	return (accessory[value] == value);
}

bool isForeign(Graph* graph, int numberOfCity, int numberOfCapital)
{
	//since we can't join to the state his own capital, we'll consider this case true
	if (numberOfCity == numberOfCapital)
		return true;
	if (graph->accessory[numberOfCity] != numberOfCapital && (graph->accessory[numberOfCity] != -1))
		return true;
	return false;
}

void joinCity(Graph* graph, List* state, int numberOfCapital)
{
	ListElement* current1 = state->first;
	int count = 0;
	while (current1)
	{
		if (isIsolated(graph->cities[current1->city], graph->accessory) && isOwnedByCurrentCapital(current1->city, numberOfCapital, graph)
			|| isForeign(graph, current1->city, numberOfCapital))
		{
			current1 = current1->next;
			count++;
		}
		else
		{
			break;
		}
	}
	if (count == size(state))
	{
		return;
	}
	if (graph->accessory[current1->city] == -1)
	{
		graph->accessory[current1->city] = numberOfCapital;
		return;
	}
	ListElement* current2 = graph->cities[current1->city]->first;
	while (current2->next)
	{
		if (isForeign(graph, current2->city, numberOfCapital) || isIsolated(graph->cities[current2->city], graph->accessory) && isOwnedByCurrentCapital(current2->city, numberOfCapital, graph))
		{
			current2 = current2->next;
		}
		else
		{
			break;
		}
	}
	graph->accessory[current2->city] = numberOfCapital;
	add(graph->cities[numberOfCapital], current2->city, current2->lengthOfRoad);
}

void findAccessory(Graph* graph)
{
	int i = 0;
	int numberOfCities = graph->size;
	while (!isAllDistributed(graph->accessory, graph->size))
	{
		if (isCapital(graph->accessory, i % numberOfCities))
		{
			joinCity(graph, graph->cities[i % numberOfCities], i % numberOfCities);
		}
		i++;
	}
}
void printStates(Graph* graph)
{
	for (int k = 0; k < graph->size; k++)
	{
		if (isCapital(graph->accessory, k))
		{
			std::cout << "State with capital number " << k << "\n";
			ListElement *current = graph->cities[k]->first;
			while (current)
			{
				if (graph->accessory[current->city] == k)
					std::cout << "number of city: " << current->city << "\n";
				current = current->next;
			}
			std::cout << "\n";
		}
	}
}

void deleteGraph(Graph* graph)
{
	for (int k = 0; k < graph->size; k++)
	{
		deleteList(graph->cities[k]);
	}
	delete[] graph->cities;
	delete[] graph->accessory;
	graph->size = 0;
	delete graph;
}