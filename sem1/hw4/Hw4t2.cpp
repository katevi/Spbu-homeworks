#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>

struct Subscriber {
	char name[50];
	char surname[50];
	char number[50];
};

int readingFile(Subscriber array[])
{
	int countCell = 0;
	FILE *file = fopen("Telephones.txt", "r");
	if (file == NULL)
		std::cout << "No subscribers. Please, add somebody before press 2 or 3.";
	else
	{
		while (!feof(file))
		{
			fgets(array[countCell].number, 50, file);
			fgets(array[countCell].name, 50, file);
			fgets(array[countCell].surname, 50, file);
			countCell++;
		}
	}
	return countCell;
	fclose(file);
}

void saveToFile()
{
	int c = 0;
	FILE *tempFile = fopen("buffer.txt", "r");
	FILE *finalFile = fopen("Telephones.txt", "a");
	while ((c = getc(tempFile)) != EOF) {
		fputc(c, finalFile);
	}
	fclose(tempFile);
	fclose(finalFile);
}

void addingSubscriber(Subscriber newSubscriber)
{
	FILE *file = fopen("buffer.txt", "a");
	std::cout << "Enter name:";
	std::cin >> newSubscriber.name;
	std::cout << "Enter surname:";
	std::cin >> newSubscriber.surname;
	std::cout << "Enter number:";
	std::cin >> newSubscriber.number;
	fputs(newSubscriber.number, file);
	fputs("\n", file);
	fputs(newSubscriber.name, file);
	fputs("\n", file);
	fputs(newSubscriber.surname, file);
	fputs("\n", file);
	fclose(file);
	std::cout << "The subscriber was successfully added into buffer. \n";
}

void findingNumber(char nameOfSubscriber[], char surnameOfSubscriber[], Subscriber arrayOfSubscribers[])
{
	std::cout << "Enter the name:";
	std::cin >> nameOfSubscriber;
	std::cout << "Enter the surname:";
	std::cin >> surnameOfSubscriber;
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
				isSameName = false;
		if (isSameName)
		{
			std::cout << nameOfSubscriber << "\n" << surnameOfSubscriber << "\n" << arrayOfSubscribers[i].number;
			isCoincidence = true;
		}
		isSameName = true;
	}
	if (!isCoincidence)
		std::cout << "Subscriber not found.\n";
}

void findingName(char numberOfSubscriber[], Subscriber arrayOfSubscribers[])
{
	std::cout << "Enter telephone number:";
	std::cin >> numberOfSubscriber;
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
			std::cout << numberOfSubscriber << "\n" << arrayOfSubscribers[i].name << arrayOfSubscribers[i].surname;
			isCoincidence = true;;
		}
		isSameName = true;
	}
	if (!isCoincidence)
		std::cout << "Subscriber not found.\n";
}

int main()
{
	remove("buffer.txt");
	std::cout << "Welcome to the interactive phone book! Press: \n '0' - if you want to exit \n '1' - if you want to add subscriber \n '2' - if you want to find number \n '3' - if you want to find name \n '4' - if you want to save it into the file \n";
	int option = 0;
	std::cin >> option;
	Subscriber arrayOfSubscribers[100]{ "","" };
	char nameCurrent[50];
	char numberCurrent[50];
	char surnameCurrent[50];
	if ((option > 4) || (option < 0))
		std::cout << "Choose 0, 1, 2, 3 or 4!";
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
					std::cout << "Saved successfully. \n";
					break;
				}
				default:
				{
					std::cout << "Choose 0, 1, 2, 3 or 4!";
					break;
				}
			}
			std::cout << "Enter option:";
			std::cin >> option;
		}
		std::cout << "Phone book exit...";
	}
}