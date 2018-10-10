#include <iostream>

int computeIterative(int numEnt)
{
	int resultIn = 1;
	for (int i = 1; i <= numEnt; i++)
		resultIn = resultIn * i;
	return resultIn;
}

int computeRekursively(int numEnt)
{
	int resultIn;
	if ((numEnt == 1) || (numEnt == 0))
		return 1;
	resultIn = computeRekursively(numEnt - 1) * numEnt;
	return resultIn;
}

int main()
{
	std::cout << "Choose method to compute the factorial (1 - rekursively; 2 - iterative):";
	int method;
	std::cin >> method;
	std::cout << "Enter number:";
	int number;
	std::cin >> number;
	
	if (method == 2)
	{
		int result = computeIterative(number);
		std::cout << "Result by iterative method =" << result;
	}
	
	if (method == 1)
	{
		int result = computeRekursively(number);
		std::cout << "Result by rekursively method =" << result;
	}
}