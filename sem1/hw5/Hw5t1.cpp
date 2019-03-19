#include <iostream>

void printTheArray(int** array, int n)
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			std::cout << array[i][j] << " ";
			if (j == n - 1)
			{
				std::cout << "\n";
			}
		}
	}
}

void fillingTheArray(int **numbers, int sideOfArray)
{
	int j = 0;
	int currentCoil = 0;
	int numberOfCoils = sideOfArray / 2;
	int i = sideOfArray * sideOfArray;
	for (currentCoil = 1; currentCoil <= numberOfCoils; currentCoil++)
	{
		for (j = currentCoil - 1; j < sideOfArray - currentCoil + 1; j++)
		{
			numbers[currentCoil - 1][j] = i--;
		}
		for (j = currentCoil; j < sideOfArray - currentCoil + 1; j++)
		{
			numbers[j][sideOfArray - currentCoil] = i--;
		}
		for (j = sideOfArray - currentCoil - 1; j >= currentCoil - 1; --j)
		{
			numbers[sideOfArray - currentCoil][j] = i--;
		}
		for (j = sideOfArray - currentCoil - 1; j >= currentCoil; j--)
		{
			numbers[j][currentCoil - 1] = i--;
		}
	}
	numbers[numberOfCoils][numberOfCoils] = 1;
}

void arrayDelete(int** &numbers, int sideOfArray)
{
	for (int i = 0; i < sideOfArray; i++)
	{
		delete[] numbers[i];
	}
	delete[] numbers;
}

int main()
{
	int sideOfArray = 0;
	std::cout << "Enter side of array n*n (side is not even!)";
	std::cin >> sideOfArray;
	int **numbers = new int*[sideOfArray] {0};
	for (int i = 0; i < sideOfArray; i++)
	{
		numbers[i] = new int[sideOfArray] {0};
	}

	fillingTheArray(numbers, sideOfArray);
	std::cout << "Array, obtained by spiraling from the center: \n";
	printTheArray(numbers, sideOfArray);
	arrayDelete(numbers, sideOfArray);
}