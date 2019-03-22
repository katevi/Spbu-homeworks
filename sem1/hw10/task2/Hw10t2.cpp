#include <iostream>
#include <fstream>
#include <cstring>

using namespace std;

int const coefficient = 2;
int const prime = 10007;
int const stringSize = 256;

int binPow(int number, int degree) 
{
	if (degree == 0)
	{
		return 1;
	}
	if (degree % 2 == 1)
	{
		return binPow(number, degree - 1) * number;
	}
	else 
	{
		int result = binPow(number, degree / 2);
		return result * result % prime;
	}
}

int hashFunction(char* substring, int length)
{
	int result = 0;
	for (int i = 0; i < length; i++)
	{
		result = (result * coefficient % prime + int(substring[i])) % prime;
	}
	return result % prime;
}

void inputLength(int &lengthString, int &lengthSubstring)
{
	std::cout << "Enter the length of string:\n";
	std::cin >> lengthString;
	std::cout << "Enter the length of substring:\n";
	std::cin >> lengthSubstring;
}

void inputStrings(char* stringChar, char* substringChar)
{
	std::cout << "Enter string:\n";
	std::cin >> stringChar;
	std::cout << "Enter substring:\n";
	std::cin >> substringChar;
}

bool isSame(char* substring, char* string, int shift)
{
	int length = strlen(substring);
	for (int i = 0; i < length; i++)
	{
		if (string[i + shift] != substring[i])
			return false;
	}
	return true;
}

int main()
{
	ifstream file("input.txt");
	char* string = new char[stringSize];
	char* substring = new char[stringSize];
	file.getline(string, stringSize);
	file.getline(substring, stringSize);
	int lengthSubstring = strlen(substring);
	int lengthString = strlen(string);
	long int y = binPow(coefficient, lengthSubstring);

	std::cout << "First indices of all occurrences of a substring in a string:\n";
	int hashSubstring = hashFunction(substring, lengthSubstring);
	int currentHash = hashFunction(string, lengthSubstring);

	for (int i = 0; i < lengthString - lengthSubstring + 1; i++)
	{
		if (i != 0)
		{
			currentHash = ((((currentHash * coefficient) - (int)string[i - 1] * y) % prime + prime) % prime + (int)string[i + lengthSubstring - 1]) % prime;
		}
		if ((currentHash == hashSubstring) && isSame(substring, string, i))
		{
			std::cout << i << " ";
		}
	}

	delete[] substring;
	delete[] string;
	file.close();
}