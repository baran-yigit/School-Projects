#pragma once

#include <iostream>
#include <string>
using namespace std;

class FileNameNode {
public:
	FileNameNode(string s);
	~FileNameNode();
	FileNameNode *next;
	FileNameNode *below;
	string word;
};