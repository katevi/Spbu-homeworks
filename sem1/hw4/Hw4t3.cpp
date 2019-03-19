#define _CRT_SECURE_NO_WARNINGS
#include <iostream>   
#include <cstdio>

int main()
{
	FILE* file;
	file = fopen("cppstudio.txt", "r");
	char currentSymbol = ' ';
	int count = 0;
	bool isNotEmpty = false;
	if (file == NULL) 
		perror("Error opening file");
	else
	{
		while (!feof(file))
		{
			currentSymbol = fgetc(file);
			if ((currentSymbol != ' ') && (currentSymbol != '\n') && (currentSymbol != '\t'))
				isNotEmpty = true;
			if ((currentSymbol == '\n') && (isNotEmpty))
			{
				count++;
				isNotEmpty = false;
			}
			if ((currentSymbol == EOF) && (isNotEmpty) and (count > 0))
				count++;
		}
	}
	std::cout << "Number of non-empty rows:" << count;
	fclose(file);
}