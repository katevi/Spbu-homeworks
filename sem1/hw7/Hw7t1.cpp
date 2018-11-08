#include <iostream>

int main()
{
	int sideOfArray = 0;
	std::cout << "Enter side of array n*n (side is not even!)";
	std::cin >> sideOfArray;
	int **numbers = new int*[sideOfArray] {0};

	for (int i = 0; i < sideOfArray; i++)
		numbers[i] = new int[sideOfArray] {0};

	int i = sideOfArray * sideOfArray;
	int j = 0; 
	int currentCoil = 0;
	int numberOfCoils = sideOfArray / 2;
	for (currentCoil = 1; currentCoil <= numberOfCoils; currentCoil++)
	{
		for (j = currentCoil - 1; j < sideOfArray - currentCoil + 1; j++) 
			numbers[currentCoil - 1][j] = i--;
		for (j = currentCoil; j < sideOfArray - currentCoil + 1; j++) 
			numbers[j][sideOfArray - currentCoil] = i--;
		for (j = sideOfArray - currentCoil - 1; j >= currentCoil - 1; --j) 
			numbers[sideOfArray - currentCoil][j] = i--;
		for (j = sideOfArray - currentCoil - 1; j >= currentCoil; j--) 
			numbers[j][currentCoil - 1] = i--;
	}
	numbers[numberOfCoils][numberOfCoils] = 1;
	std::cout << "Array, obtained by spiraling from the center: \n";
	for (int i = 0; i < sideOfArray; i++)
		for (int j = 0; j < sideOfArray; j++)
		{
			std::cout << numbers[i][j] << " ";
			if (j == sideOfArray - 1)
				std::cout << "\n";
		}
	for (int i = 0; i < sideOfArray; i++)
		delete[] numbers[i];
	delete[] numbers;
}