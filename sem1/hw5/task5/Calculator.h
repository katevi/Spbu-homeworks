#pragma once
#include <iostream>
#include "StackChar.h"
#include "StackFloat.h"
#include "string.h"

void writePriority1Operand(StackChar* stack, char array[], int i, char finalString[], int &count);
void writePriority2Operand(StackChar* stack, char array[], int i, char finalString[], int &count);
void fromExpressionToPostfix(char finalString[]);
void fromPostfixToAnswer(char finalString[]);