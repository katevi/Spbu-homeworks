#include <iostream>
int main()
{
	std::cout << "Enter x, when x - integer number ";
	int x = 0;
	std::cin >> x;
	int xsquare = x * x;
	int result = (xsquare + x) * (xsquare + 1) + 1;
	std::cout << "Result = " << result;
}