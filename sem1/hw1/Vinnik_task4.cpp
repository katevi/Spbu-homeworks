#include <iostream>

int main()
{
	int counters[27];
	for (int i = 0; i <= 27; i++)
		counters[i] = 0;
	
	for (int i = 0; i <= 9; i++)
		for (int j = 0; j <= 9; j++)
			for (int k = 0; k <= 9; k++)
				counters[i + j + k] = counters[i + j + k] + 1;
	
	int sum = 0;
	for (int i = 0; i <= 27; i++)
		sum = sum + counters[i] * counters[i];

	std::cout << "number of lucky tickets = " << sum;
}