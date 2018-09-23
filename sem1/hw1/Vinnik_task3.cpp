#include <iostream>

void swap(int &currentCellOfArray1, int &currentCellOfArray2)
{
    int t = currentCellOfArray1;
    currentCellOfArray1 = currentCellOfArray2;
    currentCellOfArray2 = t;
}

void reverse(int currentArray[], int start, int end)
{
    {
        int j = 0;
        for (int i = start; i <= (end + start) / 2; i++)
        {
            j = j + 1;
            swap(currentArray[i], currentArray[end - j + 1]);
        }
    }
    
}

int main() 
{
    std::cout << "Enter length of array (n)";
    int n;
    std::cin >> n;
    std::cout << "Enter pointer (m)";
    int m;
    std::cin >> m;
    int a[n];
    std::cout << "Start array: ";
    for (int i = 1; i <= n; i++)
    {
        a[i] = i;
    }
    
    reverse(a, 1, m);
    reverse(a, m + 1, n);
    reverse(a,1,n);

    std::cout << "Final array: ";
    for (int i = 1; i <= n; i++)
    std::cout << a[i];
}