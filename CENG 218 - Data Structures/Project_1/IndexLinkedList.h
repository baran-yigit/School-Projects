#pragma once
#include "FileNameNode.h"
#include <string>
#include <chrono>
using namespace std;

class IndexLinkedList {
public:
	IndexLinkedList();
	~IndexLinkedList();
	int getRight()const;
	void setRight(string s);
	bool setWord(string s);
	void printRight() const;
	void printWord() const;
private:
	FileNameNode *head;
	FileNameNode *curr;
	int rtval;
	int ltval;
};