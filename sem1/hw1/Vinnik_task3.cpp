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
	const int _ARRAYLENGTH = 10;
	std::cout << "Enter pointer (m)";
	int m = 0;
	std::cin >> m;
	int a[_ARRAYLENGTH];
	std::cout << "Start array (before reverse): ";
	for (int i = 0; i < _ARRAYLENGTH; i++)
	{
		a[i] = i;
		std::cout << a[i] << " ";
	}
	std::cout << "\n";
	reverse(a, 0, m - 1);
	reverse(a, m, _ARRAYLENGTH - 1);
	reverse(a, 0, _ARRAYLENGTH - 1);

	std::cout << "Final array (after reverse): ";
	for (int i = 0; i < _ARRAYLENGTH; i++)
		std::cout << a[i] << " ";
}