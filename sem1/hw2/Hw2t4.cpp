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
    const int numberOfCells = 10;
    std::cout << "Enter the number:";
    int number;
    std::cin >> number;
    
    int digitsOfNumber[numberOfCells];
    for (int i = 0; i < numberOfCells; i++)
    digitsOfNumber[i] = -1;
    
    int i = number;
    int j = 0;
	int countZero;
    while (i > 0)
    {
		if (i % 10 == 0)
		{
			countZero++;
			i = i / 10;
		}
		else
		{
			digitsOfNumber[j] = i % 10;
			i = i / 10;
			j++;
		}
    }
    
    digitsSort(digitsOfNumber);
    
    i = 0;
    while (digitsOfNumber[i] == -1)
        i++;

    std::cout << "The smallest number formed by the digits of a given number:";
	std::cout << digitsOfNumber[i];
	for (int k = 1; k <= countZero; k++)
		std::cout << 0;
    for (int j = i + 1; j < numberOfCells; j++)
        std::cout << digitsOfNumber[j];
}