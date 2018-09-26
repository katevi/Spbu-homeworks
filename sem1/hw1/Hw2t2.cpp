#include <iostream>

int countingNumberOfWays(int number, int upperBound)
{
	if ((number == 0) and (upperBound == 0))
		return 1;
	if ((upperBound == 0) and (number != 0))
		return 0;
	if (upperBound > number)
		return countingNumberOfWays(number, number);
	if ((0 < upperBound) and (upperBound <= number))
		return (countingNumberOfWays(number, upperBound - 1) + countingNumberOfWays(number - upperBound, upperBound));
}

int main()
{
	std::cout << "Enter number";
	int numberEntered = 0;
	std::cin >> numberEntered;
	int result = countingNumberOfWays(numberEntered, numberEntered);
	std::cout << result;
}