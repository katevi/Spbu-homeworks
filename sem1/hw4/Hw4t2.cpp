#include <iostream>
#include <cstring>

struct subScriber {
	char name[50];
	char surname[50];
	char number[50];
};


void saveToFile()
{
	int c;
	FILE *tempFile = fopen("buffer.txt", "r");
	FILE *finalFile = fopen("Telephones.txt", "a");
	while ((c = getc(tempFile)) != EOF) {
		fputc(c, finalFile);
	}
	fclose(tempFile);
	fclose(finalFile);
}

void addingSubscriber(struct subScriber newSubscriber)
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
	fclose(file);
	std::cout << "The subscriber was successfully added into buffer. \n";
}

void findingNumber(char nameOfSubscriber[], struct subScriber array[100])
{
	std::cout << "Enter the name:";
	std::cin >> nameOfSubscriber;
	int i = 0;
	FILE *file = fopen("Telephones.txt", "r");
	int countCell = 0;
	while (!feof(file))
	{
		if (i % 3 == 0)
			fgets(array[countCell].number, 50, file);
		if (i % 3 == 1)
			fgets(array[countCell].name, 50, file);
		if (i % 3 == 2)
		{
			fgets(array[countCell].surname, 50, file);
			countCell++;
		}
		i++;
	}
	bool isSameName = true;
	bool isCoincidence = false;
	for (int i = 0; i < countCell; i++)
	{
		for (int j = 0; j < strlen(nameOfSubscriber); j++)
			if (nameOfSubscriber[j] != array[i].name[j])
				isSameName = false;
		if (isSameName)
		{
			std::cout << nameOfSubscriber << " " << array[i].number;
			isCoincidence = true;
		}
		isSameName = true;
	}
	if (!isCoincidence)
		std::cout << "Subscriber not found.\n";
	fclose(file);
}

void findingName(char numberOfSubscriber[], struct subScriber arrayOfSubscribers[100])
{
	std::cout << "Enter telephone number:";
	std::cin >> numberOfSubscriber;
	int i = 0;
	FILE *file = fopen("Telephones.txt", "r");
	int countCell = 0;
	while (!feof(file))
	{
		if (i % 2 == 0)
			fgets(arrayOfSubscribers[countCell].number, 50, file);
		if (i % 2 == 1)
		{
			fgets(arrayOfSubscribers[countCell].name, 50, file);
			countCell++;
		}
		i++;
	}
	bool isSameName = true;
	bool isCoincidence = false;
	for (int i = 0; i < countCell; i++)
	{
		for (int j = 0; j < strlen(numberOfSubscriber); j++)
			if (numberOfSubscriber[j] != arrayOfSubscribers[i].number[j])
			{
				isSameName = false;
			}
		if (isSameName)
		{
			std::cout << numberOfSubscriber << " " << arrayOfSubscribers[i].name;
			isCoincidence = true;;
		}
		isSameName = true;
	}
	if (!isCoincidence)
		std::cout << "Subscriber not found.\n";
	fclose(file);
	
}

int main()
{
	std::cout << "Welcome to the interactive phone book! Press: \n '0' - if you want to exit \n '1' - if you want to add subscriber \n '2' - if you want to find number \n '3' - if you want to find name \n '4' - if you want to save it into the file \n";
	int option = 0;
	std::cin >> option;
	struct subScriber arrayOfSubscribers[100]{ "","" };
	char nameCurrent[50];
	char numberCurrent[50];
	if ((option > 4) or (option < 0))
		std::cout << "Choose 0, 1, 2, 3 or 4!";
	else
	{
		while (option != 0)
		{
			switch (option)
			{
				case 1:
				{
					struct subScriber newSubscriber{ };
					addingSubscriber(newSubscriber);
					break;
				}
				case 2:
				{
					findingNumber(nameCurrent, arrayOfSubscribers);
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
	system("pause");
}