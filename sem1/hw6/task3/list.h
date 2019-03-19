#pragma once

struct elementOfPolynomial
{
	char sign;
	int coefficient;
	int degree;
	elementOfPolynomial *next;
};

struct Polynomial {
	elementOfPolynomial *first;
};

Polynomial *createList();
void deleteList(Polynomial *polynomial);
void add(Polynomial *polynomial, int degree, int coefficient, char sign);