#include <stdio.h>

int main()
{
	FILE* file = fopen("Words.txt", "r");
	char currentSymbol = ' ';
	char lettersOfWord[50];
	int size = 0;
	printf("The first occurrence of the letters in the words: \n");
	while (!feof(file))
	{
		currentSymbol = fgetc(file);
		if (currentSymbol == ' ') 
		{
			for (int i = 0; i < size; i++)
			{
				lettersOfWord[i] = ' ';
			}
			size = 0;
			printf("%c", ' ');
		}
		else
		{
			size++;
			bool isFirst = true;
			for (int i = 0; i < size; i++)
			{
				if (currentSymbol == lettersOfWord[i])
					isFirst = false;
			}
			if (isFirst)
			{
				lettersOfWord[size - 1] = currentSymbol;
				printf("%c", currentSymbol);
			}
		}
	}
	fclose(file);
}