#include <iostream>
#include <iomanip>

void outputInExponentialForm(double number)
{
	std::cout << "Number in exponential form:" << std::setprecision(20);
	if (number == 0)
	{
		std::cout << 0;
	}
	else
	{
		unsigned char *binaryNumber = reinterpret_cast<unsigned char*>(&number);

		unsigned char sign = 0b10000000;
		if (binaryNumber[7] & sign)
		{
			std::cout << "-";
		}
		else
		{
			std::cout << "+";
		}
		unsigned char exponent = 0b01111111;
		unsigned char mantissa = 0b00001111;
		int order = (binaryNumber[7] & exponent) * 16 + (binaryNumber[6] & ~mantissa) / 16 - 1023;
		binaryNumber[6] = binaryNumber[6] & 0b00001111;
		binaryNumber[6] = binaryNumber[6] | 0b11110000;
		binaryNumber[7] = 0b00111111;

		std::cout << number;
		if (order > 0)
		{
			std::cout << "*2^" << order;
		}
		else
		{
			std::cout << "*2^(" << order << ")";
		}
	}

}

int main()
{
	std::cout << "Enter the number:\n";
	double number = 0;
	std::cin >> number;
	outputInExponentialForm(number);
}