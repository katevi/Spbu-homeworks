#include <iostream>
#include <cstring>                       
int main()
{
	std::cout << "Enter string ";
	char str[256];
	for (int i = 0; i < 256; i++)
		str[i] = ' ';
	std::cin >> str;
   
    	bool isSame = true;
	int length = strlen(str);
	int count = 0;
	while (count <= length)
	{
	    if (str[count] != str[length-1-count])
	        isSame = false;
	   count++;
	}	

	if (isSame)
		std::cout << "This string is palindrome";
	if (!isSame)
		std::cout << "This string is not palindrome";
}