#include <iostream>

void convertToAnAdditionalCode(int* array, int number)
{
	int temp = number;
	for (int i = 31; i >= 0; i--) 
	{
		array[i] = (number >> i) & 1;
	}
	for (int i = 31; i >= 0; i--)
		std::cout << array[i];
}

void sum(int* arrayFirst, int* arraySecond)
{
	bool isOverFlow = false;
	for (int i = 0; i < 31; i++)
	{
		arrayFirst[i + 1] = arrayFirst[i + 1] + (arrayFirst[i] + arraySecond[i]) / 2;
		arrayFirst[i] = (arrayFirst[i] + arraySecond[i]) % 2;
	}
	if ((arrayFirst[31] + arraySecond[31]) / 2 == 1)
	{
		isOverFlow = true;
	}
	arrayFirst[31] = (arrayFirst[31] + arraySecond[31]) % 2;
	for (int i = 31; i >= 0; i--)
		std::cout << arrayFirst[i];
}

int main()
{
	int arrayFirst[32]{ 0 };
	int arraySecond[32]{ 0 };
	std::cout << "Enter first number ";
	int first = 0;
	std::cin >> first;
	std::cout << "Enter second number ";
	int second = 0;
	std::cin >> second;
	std::cout << "\nFirst number in reverse code:\n";
	convertToAnAdditionalCode(arrayFirst, first);
	std::cout << "\nSecond number in reverse code:\n";
	convertToAnAdditionalCode(arraySecond, second);
	std::cout << "\nResult of addition in the binary notation:\n";
	sum(arrayFirst, arraySecond);
	std::cout << "\nResult of addition in the decimal notation:\n";
	std::cout << first + second;
}