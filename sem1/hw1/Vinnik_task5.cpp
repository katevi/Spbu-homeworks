#include <iostream>
#include <cstring>                       
int main()
{
	char str[256];
	for (int i = 0; i < 256; i++)
		str[i] = ' ';

	std::cout << "Enter string ";
	std::cin >> str;

	int length = strlen(str);
	bool checkWrong = true;
	int balans = 0;

	for (int i = 0; i < length; i++)
	{
		if ((balans == 0) and (str[i] == ')'))
			checkWrong = false;
		if (str[i] == '(')
			balans = balans + 1;
		if (str[i] == ')')
			balans = balans - 1;
	}

	if ((balans != 0) or (checkWrong == false))
		std::cout << "wrong bracket sequence";
	if ((balans == 0) and (checkWrong == true))
		std::cout << "right bracket sequence";
}