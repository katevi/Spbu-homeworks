#include <iostream>

int binPow(int aEntered, int nEntered) {
	if (nEntered == 0)
		return 1;
	if (nEntered % 2 == 1)
		return binPow(aEntered, nEntered - 1) * aEntered;
	else {
		int result = binPow(aEntered, nEntered / 2);
		return result * result;
	}
}

int main()
{
	int a = 0;
	int n = 0;
	std::cout << "Basis ";
	std::cin >> a;
	std::cout << "Degree ";
	std::cin >> n;
	std::cout << a << "^" << n << "=" << binPow(a, n);
}