#include <iostream>
int main()
{

	std::cout << "Enter a ";
	int a = 0;
	std::cin >> a;

	std::cout << "Enter b ";
	int b = 0;
	std::cin >> b;

	if (b == 0)
		std::cout << "b<>0, the end ";

	if (b != 0)
	{
		int aRemainder = abs(a);
		int i = 0;

		while (aRemainder >= abs(b))
		{
			aRemainder = aRemainder - abs(b);
			i++;
		}

		int incompleteQuotient = ((abs(a) - aRemainder) / abs(b));

		/* вывод в зависимости от знака а и b*/
		if ((a < 0) and (b > 0) and (aRemainder != 0))
			std::cout << "Incomplete quotient of a by b = " << -incompleteQuotient - 1; /* -67=-23*3+2 when a=-67, b =3*/
		if ((a < 0) and (b > 0) and (aRemainder == 0))
			std::cout << "Incomplete quotient of a by b = " << -incompleteQuotient; /* -66=-22*3+0 when a=-66, b =3*/

		if ((a > 0) and (b > 0))
			std::cout << "Incomplete quotient of a by b = " << incompleteQuotient; /* 67=22*3+1 when a=67, b =3*/

		if ((a < 0) and (b < 0) and (aRemainder != 0))
			std::cout << "Incomplete quotient of a by b = " << incompleteQuotient + 1; /* -67=23*(-3)+2 when a=-67, b =-3*/
		if ((a < 0) and (b < 0) and (aRemainder == 0))
			std::cout << "Incomplete quotient of a by b = " << incompleteQuotient; /* -66=-22*3 when a=-67, b =-3*/

		if ((a > 0) and (b < 0))
			std::cout << "Incomplete quotient of a by b = " << -incompleteQuotient; /* 67=-22*(-3)+1 when a=67, b =-3*/

	}
}