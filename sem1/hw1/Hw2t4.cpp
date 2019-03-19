#include <iostream>

int digitsSort(int digits[])
{
    for (int i = 0; i < 10; i++)
		for (int j = 0; j < 9; j++)
			if (digits[j] > digits[j + 1])
			{
				int t = 0;
				t = digits[j + 1];
				digits[j + 1] = digits[j];
				digits[j] = t;
			}
    return digits[10];
}

int main()
{
    const int _NUMBER = 10;
    std::cout << "Enter the number:";
    int number;
    std::cin >> number;
    
    int digitsOfNumber[_NUMBER];
    for (int i = 0; i < _NUMBER; i++)
    digitsOfNumber[i] = -1;
    
    int i = number;
    int j = 0;
    while (i > 0)
    {
        digitsOfNumber[j] = i % 10;
        i = i / 10;
        j = j + 1;
        
    }
    
    digitsSort(digitsOfNumber);
    
    i = 0;
    while (digitsOfNumber[i] == -1)
        i++;

    std::cout << "The smallest number formed by the digits of a given number:";
    for (int j = i; j < _NUMBER; j++)
        std::cout << digitsOfNumber[j];
}