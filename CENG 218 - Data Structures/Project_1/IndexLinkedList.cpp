#include "IndexLinkedList.h"
#include "FileNameNode.h"
#include <string>
#include <chrono>
using namespace std;

IndexLinkedList::IndexLinkedList() : head(NULL),curr(NULL), rtval(0), ltval(0) { }
IndexLinkedList::~IndexLinkedList() { }

void IndexLinkedList::printRight()const {
	FileNameNode *walk = head;
	while (walk != NULL) {
		cout << " -> " << walk->word;
		walk = walk->next;
	}
}

void IndexLinkedList::printWord()const {
	FileNameNode *walk = head;
	FileNameNode *b_walk = curr;
	int count = 0;
	while (walk != NULL) {
		b_walk = walk;
		while (b_walk != NULL) {
			cout << " -> " << b_walk->word;
			b_walk = b_walk->below;
		}
		cout << endl;
		count++;
		walk = walk->next;
	}
}

int IndexLinkedList::getRight()const {
	return rtval;
}

void IndexLinkedList::setRight(string s) {
	FileNameNode *newptr = new FileNameNode(s);
	FileNameNode *walk = head;
	if (head == NULL && rtval == 0) {
		head = newptr;
		curr = head;
	}
	else {
		while (walk != NULL) {
			if (walk->next == NULL) {
				walk->next = newptr;
				break;
			}
			walk = walk->next;
		}
	}
	curr = newptr;
	rtval++;
}

bool IndexLinkedList::setWord(string s) {
	FileNameNode *newptr = new FileNameNode(s);
	FileNameNode *walk = curr;
	if (curr == NULL) {
		return false;
	}
	else {
		while (walk != NULL) {
			if (walk->below == NULL) {
				walk->below = newptr;
				break;
			}
			walk = walk->below;
		}
		return true;
	}
}