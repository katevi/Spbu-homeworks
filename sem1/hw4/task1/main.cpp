#include <stdio.h>
#include "list.h"
#include "list.cpp"
#include <iostream>


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
	deletingElements(list, m - 1);
	std::cout << "Numbers of soldiers left alive:";
	print(list, m - 1);
	system("pause");
}
