#include <iostream>

int binPow(int number, int degree) {
	if (degree == 0)
		return 1;
	if (degree % 2 == 1)
		return binPow(number, degree - 1) * number;
	else {
		int result = binPow(number, degree / 2);
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