#include <iostream>

void siftDown(int numbers[10], int root, int upperBoundOfArray)
{
	int maxChildIndex;
	bool isHeap = false;
	while ((root * 2 <= upperBoundOfArray) && (!isHeap))
	{
		if (root * 2 == upperBoundOfArray)
			maxChildIndex = root * 2;
		else
			if (numbers[root * 2] > numbers[root * 2 + 1])
				maxChildIndex = root * 2;
			else
				maxChildIndex = root * 2 + 1;

		if (numbers[root] < numbers[maxChildIndex])
		{
			int t = numbers[root];
			numbers[root] = numbers[maxChildIndex];
			numbers[maxChildIndex] = t;
			root = maxChildIndex;
		}
		else
			isHeap = true;
	}
}

void heapSort(int numbers[10], int arrayLength)
{
	for (int i = (arrayLength / 2) - 1; i >= 0; i--)
		siftDown(numbers, i, arrayLength - 1);

	for (int i = arrayLength - 1; i >= 1; i--)
	{
		int temp = numbers[0];
		numbers[0] = numbers[i];
		numbers[i] = temp;
		siftDown(numbers, 0, i - 1);
	}
}

int main()
{
	int a[10];
	std::cout << "Enter 10 numbers";
	for (int i = 0; i < 10; i++)
		std::cin >> a[i];
	heapSort(a, 10);
	for (int i = 0; i < 10; i++)
		std::cout << a[i] << " ";
}