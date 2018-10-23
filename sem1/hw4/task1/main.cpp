#include <stdio.h>
#include "list.h"
#include <iostream>
#include "list.cpp"

int main()
{
	std::cout << "Enter n - the number of soldiers:";
	int n = 0;
	std::cin >> n;

	std::cout << "Enter m - the number that must be a multiple of the number of the soldier to be killed:";
	int m = 0;
	std::cin >> m;

	List *list = createList();
	for (int i = 0; i < n; i++)
		add(list, i);
	cicle(list);
	deleteElements(list, m - 1);
	std::cout << "Number of soldier left alive:";
	print(list, m - 1);
	deleteList(list);
	system("pause");
}
