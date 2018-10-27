#include <stdio.h>

int main()
{
	FILE* file = fopen("Words.txt", "r");
	char currentSymbol = ' ';
	char previousSymbol = ' ';
	//52 - number of big and small letters in english language
	char letters[52];
	for (int i = 0; i < 26; i++)
	{
		letters[i] = char(65 + i);
	}

	for (int i = 26; i < 52; i++)
	{
		letters[i] = char(97 + (i % 26));
	}

	printf("The first occurrence of the letters in the words: \n");
	int numberOfLetters[52] {0};
	while (!feof(file))
	{
		currentSymbol = fgetc(file);
		for (int i = 0; i < 52; i++)
		{
			if ((currentSymbol == letters[i]) && (numberOfLetters[i] == 0))
			{
				printf("%c", currentSymbol);
				numberOfLetters[i]++;
				break;
			}
		}
		if (currentSymbol == ' ')
		{
			for (int i = 0; i < 52; i++)
			{
				numberOfLetters[i] = 0;
			}
			printf(" ");
		}
	}

	fclose(file);
}