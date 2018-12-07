#include <iostream>
#include "list.h"

int main()
{
	List* list = createList();
	int x = 0;
	std::cout << "enter 10 element of list:\n";
	for (int i = 0; i < 10; i++)
	{
		std::cin >> x;
		add(list, x);
	}
	insertionSortList(list);
	std::cout << "sorted list:\n";
	print(list);
	deleteList(list);
}