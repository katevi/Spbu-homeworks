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
	if (file == NULL) perror("Error opening file");
	else
	{
		while (!feof(file))
		{
			currentSymbol = fgetc(file);
			if ((currentSymbol != ' ') and (currentSymbol != '\n') and (currentSymbol != '\t'))
				isNotEmpty = true;
			if ((currentSymbol == '\n') and (isNotEmpty))
			{
				count++;
				isNotEmpty = false;
			}
			if ((currentSymbol == EOF) and (isNotEmpty) and (count > 0))
				count++;
		}
	}
	std::cout << "Number of non-empty rows:" << count;
	fclose(file);
	system("pause");
}