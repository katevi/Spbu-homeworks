#include <iostream>

struct Student {
	int number;
	int variant;
};

int hash(Student array[], int variant, int &index)
{
	if (((variant >= 1) && (variant <= 3)) || (variant == -1))
	{
		return variant;
	}
	else
	{
		int newVariant = 0;
		newVariant = (&array[variant])->variant;
		index = variant;
		variant = newVariant;
		hash(array, variant, index);
	}
}

void insertionSort(Student array[], int length) 
{
	int temporaryNumber = 0;
	int temporaryVariant = 0;
	int index = 0;
	for (int counter = 1; counter <= length; counter++)
	{
		temporaryNumber = (&array[counter])->number; 
		temporaryVariant = (&array[counter])->variant;
		index = counter - 1; 
		while (index >= 1 && (&array[index])->number > temporaryNumber) 
		{
			array[index + 1] = array[index]; 
			(&array[index])->number = temporaryNumber;
			(&array[index])->variant = temporaryVariant;
			index--;
		}
	}
}

void output(Student array[], int size)
{
	std::cout << "Initial variants:\n";
	for (int i = 1; i <= size; i++)
	{
		std::cout << (&array[i])->number << " " << (&array[i])->variant << "\n";
	}
}

void input(Student* array, int numberOfStudents)
{
	std::cout << "Enter pairs: student - variant\n";
	for (int i = 1; i <= numberOfStudents; i++)
	{
		std::cin >> (&array[i])->number >> (&array[i])->variant;
	}
}

void findingVariants(Student startArray[], Student finalArray[], int numberOfStudents)
{
	for (int i = 1; i <= numberOfStudents; i++)
	{
		int temp = i;
		int currentVariant = (&startArray[i])->variant;
		(&finalArray[i])->number = (&startArray[i])->number;
		(&finalArray[i])->variant = hash(startArray, currentVariant, temp);
	}
}

int main()
{
	int numberOfStudents = 0;
	std::cout << "Enter number of students:\n";
	std::cin >> numberOfStudents;

	Student* startArrayOfVariants = new Student[numberOfStudents + 1];
	input(startArrayOfVariants, numberOfStudents);

	insertionSort(startArrayOfVariants, numberOfStudents);

	Student* finalArrayOfVariants = new Student[numberOfStudents + 1];
	findingVariants(startArrayOfVariants, finalArrayOfVariants, numberOfStudents);

	output(finalArrayOfVariants, numberOfStudents);

	delete[] startArrayOfVariants;
	delete[] finalArrayOfVariants;
}