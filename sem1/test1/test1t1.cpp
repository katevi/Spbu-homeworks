#include <iostream>
#include <fstream>

using namespace std;

int main()
{
	ifstream file("input.txt");
	char current {' '};
	char previous {' '};
	bool isInOneStringComment = false;
	bool isInManyStringComment = false;
	previous = current;
	file.get(current);
	while (!file.eof())
	{
		//std::cout << "Hey";
		//std::cout << previous << current << " ";
		if (isInOneStringComment)
			std::cout << current;
		if (current == '*' && previous == '/')
			isInManyStringComment = true;
		if (current == '/' && previous == '*')
			isInManyStringComment = false;
		if (current == previous && current == '/' && ((isInOneStringComment) || (isInManyStringComment)))
		{
			isInOneStringComment = false;
		}
		if (current == previous && current == '/' && !(isInManyStringComment) && !(isInOneStringComment))
		{
			//if (!(isInManyStringComment) && !(isInOneStringComment))
			isInOneStringComment = true;
		}
		previous = current;
		file.get(current);
	}
	system("pause");
	file.close();
}