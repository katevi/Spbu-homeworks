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
	std::cout << "Enter length of first stack";
	int length1 = 0;
	std::cin >> length1;
	std::cout << "Enter first stack";
	int *stack1 = new int[length1];
	for (int i = 0; i < length1; i++)
		std::cin >> stack1[i];

	std::cout << "Enter length of second stack";
	int length2 = 0;
	std::cin >> length2;
	std::cout << "Enter first stack";
	int *stack2 = new int[length2];
	for (int i = 0; i < length2; i++)
		std::cin >> stack2[i];

	int k = 0;
	int *stack0 = new int[length1 + length2];
	for (int i = 0; i < length1; i++)
		stack0[i] = stack1[i];
	for (int i = length1; i < length2; i++)
	{
		stack0[i] = stack1[k];
		k++;
	}
	for (int i = 0; i < length1 + length2; i++)
		std::cout << stack0[i];
	quickSort(stack0, 0, length1 + length2);
	for (int i = 0; i < length1 + length2; i++)
		std::cout << stack0[i] << " ";
	system("pause");
}