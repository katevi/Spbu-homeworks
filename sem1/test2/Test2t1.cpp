#include <iostream>

int findNumberFibonacci(int number)
{
	int previousNumber = 0;
	int currentNumber = 1;
	for (int i = 2; i <= number; i++)
	{
		currentNumber = currentNumber + previousNumber;
		previousNumber = currentNumber - previousNumber;
	}
	return currentNumber;
}

int main()
{
	int number = 0;
	std::cout << "Enter the number of Fibonacci's number:\n";
	std::cin >> number;
	std::cout << number << " number of Fibonacci series = " << findNumberFibonacci(number);
}