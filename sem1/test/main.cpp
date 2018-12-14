#include <stdio.h>
#include "saddlePoint.h"
#include <iostream>
using namespace std;

void printMatrix(int** matrix, int m, int n)
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			std::cout << matrix[i][j] << " ";
		}
		std::cout << "\n";
	}
}

int main()
{
	std::cout << "Enter height of array:\n";
	int n = 0;
	std::cin >> n;
	int m = 0;
	std::cout << "Enter width of array:\n";
	std::cin >> m;
	int** matrix = new int*[n];
	for (int i = 0; i < n; i++)
	{
		matrix[i] = new int[m];
	}

	std::cout << "Fill matrix:\n";
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			std::cin >> matrix[i][j];
		}
	}

	printMatrix(matrix, m, n);
	printSaddlePoints(matrix, m, n);

	for (int i = 0; i < n; i++)
	{
		delete[] matrix[i];
	}
	delete[] matrix;
}
