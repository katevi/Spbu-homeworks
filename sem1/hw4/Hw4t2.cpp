#define _CRT_SECURE_NO_WARNINGS
#include <cstring>
#include <cstdio>
#include "list.h"

/*int readingFile(Subscriber array[])
{
	int countCell = 0;
	FILE *file = fopen("Telephones.txt", "r");
	if (file == NULL)
	{
		printf("No subscribers. Please, add somebody before press 2 or 3.");
	}
	else
	{
		while (!feof(file))
		{
			add(list, )
			fgets(array[countCell].number, 50, file);
			fgets(array[countCell].name, 50, file);
			//fgets(array[countCell].surname, 50, file);
			countCell++;
		}
	}
	return countCell;
	fclose(file);
}*/

/*void saveToFile()
{
	int c = 0;
	FILE *tempFile = fopen("buffer.txt", "r");
	FILE *finalFile = fopen("Telephones.txt", "a");
	while ((c = getc(tempFile)) != EOF) 
	{
		fputc(c, finalFile);
	}
	fclose(tempFile);
	fclose(finalFile);
}

void addingSubscriber(Subscriber newSubscriber)
{
	FILE *file = fopen("buffer.txt", "a");
	printf("Enter name:");
	scanf("%s", newSubscriber.name);
	printf("Enter surname:");
	scanf("%s", newSubscriber.surname);
	printf("Enter number:");
	scanf("%s", newSubscriber.number);
	fputs(newSubscriber.number, file);
	fputs("\n", file);
	fputs(newSubscriber.name, file);
	fputs("\n", file);
	fputs(newSubscriber.surname, file);
	fputs("\n", file);
	fclose(file);
	printf("The subscriber was successfully added into buffer. \n");
}

void findingNumber(char nameOfSubscriber[], char surnameOfSubscriber[], Subscriber arrayOfSubscribers[])
{
	printf("Enter the name:");
	scanf("%s", nameOfSubscriber);
	printf("Enter the surname:");
	scanf("%s", surnameOfSubscriber);
	int countCell = 0;
	countCell = readingFile(arrayOfSubscribers);
	bool isSameName = true;
	bool isCoincidence = false;
	int lengthOfName = strlen(nameOfSubscriber);
	for (int i = 0; i < countCell; i++)
	{
		for (int j = 0; j < lengthOfName; j++)
			if ((nameOfSubscriber[j] != arrayOfSubscribers[i].name[j])
				|| (surnameOfSubscriber[j] != arrayOfSubscribers[i].surname[j]))
			{
				isSameName = false;
			}
		if (isSameName)
		{
			printf("%s\n%s\n%s", nameOfSubscriber, surnameOfSubscriber, arrayOfSubscribers[i].number);
			isCoincidence = true;
		}
		isSameName = true;
	}
	if (!isCoincidence)
	{
		printf("Subscriber not found.\n");
	}
}

void findingName(char numberOfSubscriber[], Subscriber arrayOfSubscribers[])
{
	printf("Enter telephone number:");
	scanf("%s", numberOfSubscriber);
	bool isSameName = true;
	bool isCoincidence = false;
	int countCell = 0;
	countCell = readingFile(arrayOfSubscribers);
	int lengthOfNumber = strlen(numberOfSubscriber);
	for (int i = 0; i < countCell; i++)
	{
		for (int j = 0; j < lengthOfNumber; j++)
			if (numberOfSubscriber[j] != arrayOfSubscribers[i].number[j])
			{
				isSameName = false;
			}
		if (isSameName)
		{
			printf("%s\n%s%s", numberOfSubscriber, arrayOfSubscribers[i].name, arrayOfSubscribers[i].surname);
			isCoincidence = true;;
		}
		isSameName = true;
	}
	if (!isCoincidence)
	{
		printf("Subscriber not found.\n");
	}
}*/

int main()
{
	List *list = createList();
	char name[10];
	char number[10];
	for (int i = 0; i < 3; i++)
	{
		std::cin >> name;
		std::cin >> number;
		//std::cout << name;
		//std::cout << number;
		add(list, number, name);
	}
	printf("%d", size(list));
	print(list);
	system("pause");
	/*remove("buffer.txt");
	printf("Welcome to the interactive phone book! Press: \n '0' - if you want to exit \n '1' - if you want to add subscriber \n '2' - if you want to find number \n '3' - if you want to find name \n '4' - if you want to save it into the file \n");
	int option = 0;
	scanf("%d", &option);
	Subscriber arrayOfSubscribers[100]{ "","" };
	char nameCurrent[50];
	char numberCurrent[50];
	char surnameCurrent[50];
	if ((option > 4) || (option < 0))
	{
		printf("Choose 0, 1, 2, 3 or 4!");
	}
	else
	{
		while (option != 0)
		{
			switch (option)
			{
				case 1:
				{
					Subscriber newSubscriber { };
					addingSubscriber(newSubscriber);
					break;
				}
				case 2:
				{
					findingNumber(nameCurrent, surnameCurrent, arrayOfSubscribers);
					break;
				}
				case 3:
				{
					findingName(numberCurrent, arrayOfSubscribers);
					break;
				}
				case 4:
				{
					saveToFile();
					remove("buffer.txt");
					printf("Saved successfully. \n");
					break;
				}
				default:
				{
					printf("Choose 0, 1, 2, 3 or 4!");
					break;
				}
			}
			printf("Enter option:");
			scanf("%d", &option);
		}
		printf("Phone book exit...");
	}*/
}