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
	while (!file.eof())
	{
		//std::cout << "Hey";
		previous = current;
		file.get(current);
		std::cout << previous << current << " ";
		if (isInOneStringComment)
			std::cout << current;
		if (current == '*' && previous == '/')
			isInManyStringComment = true;
		if (current == '/' && previous == '*')
			isInManyStringComment = false;
		if (current == previous && current == '/' && !(isInManyStringComment) && !(isInOneStringComment))
		{
			//if (!(isInManyStringComment) && !(isInOneStringComment))
				isInOneStringComment = true;
		}
		if (current == previous && current == '/' && ((isInOneStringComment) || (isInManyStringComment)))
		{
			isInOneStringComment = false;
		}
	}
	system("pause");
	file.close();
}