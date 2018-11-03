#include <iostream>
#include <string.h>
#include "StackChar.h"
#include "StackFloat.h"
#include "Calculator.h"


int main()
{
	char finalString[100] {' '};
	fromExpressionToPostfix(finalString);
	fromPostfixToAnswer(finalString);
}
