/* Baran Yiğit
   CENG 218			Project 1:Document Indexing  */

#include <iostream>
#include <string>
#include <fstream>
#include "FileNameNode.h"
#include "IndexLinkedList.h"
#include "FileNameNode.cpp"
#include "IndexLinkedList.cpp"
#include <string.h>
#include <algorithm>
#include <chrono>
#include <cctype>
//
using namespace std;
using namespace std::chrono;

int main() {
	auto start = high_resolution_clock::now();
	IndexLinkedList index;
	string str;
	string path = "AllDocs\\";
	string extension = ".txt";
	string space = " ";
	string input;
	int i = 0;
	bool found = false;

	cout << "            ------------------------------" << endl << "            {{{{{SIMPLE SEARCH ENGINE}}}}}" << endl << "            ------------------------------" << endl << endl;
	do {
		cout << "Input to search texts for a word ( Input '4' to exit! ) : ";
		cin >> input;
		cout << endl;
		found = false;
		if ((input >= "a" && input <= "z") || (input >= "A" && input <= "Z") || (input >= "?" && input <= "@") || (input >= "{" && input <= "}")) {
			index.setRight(input);
			for (i = 0; i < 9598; i++) {
				space = to_string(i + 1);
				ifstream infile(path + space + extension);
				if (infile.is_open()) {
					while (!infile.eof()) {
						infile >> str;
						str.erase(remove_if(str.begin(), str.end(), [](char c)
						{ return c == ',' || c == '.' || c == '!' || c == '"' || c == '?' || c == '-' || c == ':' || c == ';' || c == '...' || c == '\''; }), str.end());
						if (_stricmp(input.c_str(), str.c_str()) == 0) {
							cout << "Given word " << input << " is found in " << i + 1 << ".txt" << endl << endl;
							found = true;
							index.setWord(space);
							break;
						}
					}
				}
			}
			if (found == false) {
				cout << "Given word " << input << " is not located in textfiles!" << endl << endl;
			}
		}
	} while (input != "4");
	index.printWord();
	index.printRight();
	cout << endl;
	auto stop = high_resolution_clock::now();
	auto duration = duration_cast<seconds>(stop - start);
	cout << endl << "This search process took " << duration.count() << " seconds" << endl;
	return 0;
}
