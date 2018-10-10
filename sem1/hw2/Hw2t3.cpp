#include <iostream>

int gcd(int a, int b)
{
	while (a != b)
	{
		if (a > b)
		{
			int tmp = a;
			a = b;
			b = tmp;
		}
		b = b - a;
	}
	return a;
}

int findingCommonDenominator(int number)
{
	int result = 1;
	for (int i = 2; i <= number; i++)
		result = result * i;
	return result;
}

int sort(int numbers[], int lengthOfArray)
{
	for (int i = 0; i < lengthOfArray; i++)
		for (int j = i; j < lengthOfArray; j++)
			if (numbers[i] > numbers[j])
			{
				int t = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = t;
			}
}

int bringingToCommonDenominator(int a[], int b[], int bMax, int numberOfFractions)
{
	for (int i = 0; i < numberOfFractions; i++)
	{
		a[i] = a[i] * bMax / b[i];
		b[i] = bMax;
	}
}

int fractionReduction(int a[], int b[], int numberOfFractions)
{
	for (int i = 0; i < numberOfFractions; i++)
	{
		int t = a[i];
		a[i] = a[i] / gcd(a[i], b[i]);
		b[i] = b[i] / gcd(t, b[i]);
	}
}

int output(int a[], int b[], int numberOfFractions)
{
	std::cout << "Fractions:  0 ";
	for (int i = 0; i < numberOfFractions; i++)
		std::cout << a[i] << "/" << b[i] << " ";
	std::cout << "1";
}

int main()
{
	int maxDenominator = 0;
	std::cout << "Enter max denominator (n): ";
	std::cin >> maxDenominator;

	int numerator[100];
	int denominator[100];
	int k = 0;
	for (int i = 1; i <= maxDenominator; i++)
		for (int j = i; j <= maxDenominator; j++)
			if ((gcd(i, j) == 1) && (j != 1))
			{
				numerator[k] = i;
				denominator[k] = j;
				k++;
			}

	bringingToCommonDenominator(numerator, denominator, findingCommonDenominator(maxDenominator), k);
	sort(numerator, k);
	fractionReduction(numerator, denominator, k);
	output(numerator, denominator, k);
}