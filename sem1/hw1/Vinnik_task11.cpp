#include <iostream>

void quickSort(int numbers[], int left, int right)
{
	int pivot; 
	int leftPointer = left; 
	int rightPointer = right; 
	pivot = numbers[left];

	while (left < right) 
	{
		while ((numbers[right] >= pivot) && (left < right))
			right--;

		if (left != right)
		{
			numbers[left] = numbers[right];
			left++;
		}

		while ((numbers[left] <= pivot) && (left < right))
			left++;

		if (left != right)
		{
			numbers[right] = numbers[left];
			right--;
		}
	}

	numbers[left] = pivot;
	pivot = left;
	left = leftPointer;
	right = rightPointer;

	if (left < pivot)
		quickSort(numbers, left, pivot - 1);
	if (right > pivot)
		quickSort(numbers, pivot + 1, right);
}

int main()
{
	int numbersEntered[6];
	std::cout << "Enter cells of array (from 0 to 5)";
	for (int i = 0; i < 6; i++)
		std::cin >> numbersEntered[i];

	quickSort(numbersEntered, 0, 5); 
	for (int i = 0; i < 6; i++)
		std::cout << numbersEntered[i];
}