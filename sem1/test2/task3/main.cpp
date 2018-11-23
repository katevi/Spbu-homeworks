#include <iostream>
#include <fstream>
#include "queue.h"
using namespace std;

void input(int &a, int &b)
{
	std::cout << "Enter number a (a < b): ";
	std::cin >> a;
	std::cout << "Enter number b: ";
	std::cin >> b;
}

void writeGroupsToFile(Queue*  numbersLessA, Queue* numbersBiggerALessB, Queue* numbersBiggerB, ofstream &file)
{
	while (!isEmpty(numbersLessA))
		file << pop(numbersLessA) << " ";
	file << endl;
	while (!isEmpty(numbersBiggerALessB))
		file << pop(numbersBiggerALessB) << " ";
	file << endl;
	while (!isEmpty(numbersBiggerB))
		file << pop(numbersBiggerB) << " ";
	file << endl;
}

void splitIntoGroups(int a, int b, Queue* numbersLessA, Queue* numbersBiggerALessB, Queue* numbersBiggerB, ifstream &file)
{
	while (!file.eof())
	{
		int current = 0;
		file >> current;
		if (current < a)
		{
			push(numbersLessA, current);
		}
		if ((current >= a) && (current <= b))
		{
			push(numbersBiggerALessB, current);
		}
		if (current > b)
		{
			push(numbersBiggerB, current);
		}
	}
}

int main()
{
	int a = 0;
	int b = 0;
	input(a, b);
	Queue* numbersLessA = createQueue();
	Queue* numbersBiggerB = createQueue();
	Queue* numbersBiggerAlessB = createQueue();
	ifstream f("f.txt");
	ofstream g("g.txt");

	splitIntoGroups(a, b, numbersLessA, numbersBiggerAlessB, numbersBiggerB, f);
	writeGroupsToFile(numbersLessA, numbersBiggerAlessB, numbersBiggerB, g);

	f.close();
	g.close();
	deleteQueue(numbersLessA);
	deleteQueue(numbersBiggerAlessB);
	deleteQueue(numbersBiggerB);
}