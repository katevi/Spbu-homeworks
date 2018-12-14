#include "saddlePoint.h"
#include <iostream>

bool isMaximumInColumn(int** matrix, int i, int j, int m)
{
	for (int k = 0; k < m; k++)
	{
		if ((matrix[k][j]) > matrix[i][j])
		{
			return false;
		}
	}
	return true;
}

bool isMinimumInString(int** matrix, int i, int j, int n)
{
	for (int k = 0; k < n; k++)
	{
		if ((matrix[i][k]) < matrix[i][j])
		{
			return false;
		}
	}
	return true;
}


bool isSaddlePoint(int** matrix, int i, int j, int n, int m)
{
	if (isMaximumInColumn(matrix, i, j, n) && (isMinimumInString(matrix, i, j, m)))
	{
		return true;
	}
	return false;
}

void printSaddlePoints(int** matrix, int m, int n)
{
	bool isExists = false;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			if (isSaddlePoint(matrix, i, j, n, m))
			{
				std::cout << "[" << i << "][" << j << "] " << matrix[i][j] << "\n";
				isExists = true;
			}
		}
	}
	if (!(isExists))
	{
		std::cout << "No points\n";
	}
}