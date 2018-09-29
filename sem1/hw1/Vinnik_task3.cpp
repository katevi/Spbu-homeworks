#include <iostream>

void swap(int &a, int &b)
{
	int t = a;
	a = b;
	b = t;
}

void reverse(int currentArray[], int start, int end)
{
	{
		int j = 0;
		for (int i = start; i <= (end + start) / 2; i++)
		{
			j = j + 1;
			swap(currentArray[i], currentArray[end - j + 1]);
		}
	}

}

int main()
{
	std::cout << "Enter pointer (m)";
	int m = 0;
	std::cin >> m;
	int a[10];
	std::cout << "Start array (before reverse): ";
	for (int i = 0; i < 10; i++)
	{
		a[i] = i;
		std::cout << a[i] << " ";
	}
	std::cout << "\n";
	reverse(a, 0, m - 1);
	reverse(a, m, 10 - 1);
	reverse(a, 0, 10 - 1);

	std::cout << "Final array (after reverse): ";
	for (int i = 0; i < 10; i++)
		std::cout << a[i] << " ";
}