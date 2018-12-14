#include <iostream>
#include "HashTable.h"
#include <fstream>

using namespace std;

int main()
{
	HashTable* table = createTable();
	int number = 0;
	std::cout << "Please, enter numbers, if you want to finish, press 0\n";
	std::cin >> number;
	addElement(table, number);
	while (number != 0)
	{
		std::cin >> number;
		if (number != 0)
			addElement(table, number);
	}
	std::cout << "Output numbers:\n";
	printNumberOfWords(table);
	deleteTable(table);
}