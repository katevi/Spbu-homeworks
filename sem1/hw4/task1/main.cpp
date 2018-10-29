#include "list.h"
#include <iostream>
#include <stdio.h>

void toKillTheSoldier(List *list, int m)
{
	ListElement *current = list->head;
	int i = 0;
	while (list->size > 1)
	{
		i++;
		if (i % m == 0)
		{
			if (current->next == list->head)
			{
				list->head = current->next->next;
			}
			ListElement *elementToDelete = current->next;
			current->next = current->next->next;
			delete elementToDelete;
			list->size--;
		}
		current = current->next;
	}
}

int main()
{
	std::cout << "Enter n - the number of soldiers:";
	int n = 0;
	std::cin >> n;

	std::cout << "Enter m - the number that must be a multiple of the number of the soldier to be killed:";
	int m = 0;
	std::cin >> m;

	List *list = createList();
	for (int i = 1; i <= n; i++)
	{
		add(list, i);
	}
	toKillTheSoldier(list, m - 1);
	std::cout << "Number of soldier left alive:";
	print(list);
	deleteList(list);
}
