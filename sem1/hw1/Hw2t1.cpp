#include <iostream>

int computeRekursively(int number)
{
	if (number == 1) return 1;
	if (number < 0) return 0;
	return computeRekursively(number - 1) + computeRekursively(number - 2);
}

void computeIteratively(int number)
{
	int i = 3;
	int nextNumber = 1;
	int currentNumber = 1;
	int previousNumber = 0;
	while (i <= number )
	{
		previousNumber = currentNumber;
		currentNumber = nextNumber;
		nextNumber = currentNumber + previousNumber;
		i++;
	}
	std::cout << "By method 2: " << nextNumber;
}

void numberOutput(int methodNumber, int number)
{
	if (methodNumber == 1)
		std::cout << "By method 1: " << computeRekursively(number);
	if (methodNumber == 2)
		computeIteratively(number);
}

void dataInput(int &number, const char text[])
{
	std::cout << text;
	std::cin >> number;
}

int main()
{
	int method = 0;
	dataInput(method, "Enter method to compute Fibonacci number (1 - rekursively, 2 - iteratively):");
	int numberMember = 0;
	dataInput(numberMember, "Enter the sequence member number:");
	numberOutput(method, numberMember);
}