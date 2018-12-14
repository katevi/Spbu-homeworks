#include <iostream>
#include <fstream>
#include "list.h"

 using namespace std;

 int main()
{
	ifstream file("input.txt");
	int number = 0;
	List* list = createList();
	while (!file.eof())
	{
		file >> number;
		add(list, number);
	}
	std::cout << "Elements of list:\n";
	print(list);
	if (isSymmetrical(list))
	{
		std::cout << "List is symmetrical\n";
	}
	else
	{
		std::cout << "List is not symmetrical\n";
	}
	file.close();
	deleteList(list);
}