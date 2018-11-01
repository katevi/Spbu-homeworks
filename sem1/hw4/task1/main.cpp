#include "list.h"
#include <iostream>
#include <stdio.h>

void findingLastSoldier(List *list, int m)
{
	int i = 0;
	while (printListSize(list) > 1)
	{
		i++;
		if (i % m == 0)
		{
			killTheSoldier(list);
			listSizeDecrease(list);
		}
		changingPosition(list);
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
	findingLastSoldier(list, m - 1);
	std::cout << "Number of soldier left alive:";
	print(list);
	deleteList(list);
	system("pause");
}
