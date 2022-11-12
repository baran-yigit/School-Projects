/*Baran Yiğit 201711071
    CENG 218 Project 2:Document Indexing and Posting Lists: Binary Search Tree Based */

//#pragma warning(disable : 4996)

//compiled at Code::Blocks 20.03
//also works at vs 17 community with #pragma warning(disable : 4996).
//search part appeared under 50 seconds on my command prompt
#include <iostream>
#include <fstream>
#include <cstring>
#include <algorithm>
#include <time.h>
using namespace std;
const int total = 9598;

template<class T>
class FileNameNode {
public:
	T data;
	FileNameNode *next;
	FileNameNode() : next(NULL) { }
	FileNameNode(const T &d) : data(d), next(NULL) { }
};

template <class T>
class LinkedList {
private:
	FileNameNode<T> *head;
	int size;
public:
	LinkedList() : size(0), head(NULL) { }

    ~LinkedList() {
		FileNameNode<T> *walk;
		while (head != NULL) {
			walk = head;
			head = head->next;
			delete walk;
			size--;
		}
	}

    bool operator == (const LinkedList &l1)const {
		if (&l1 == this)
			return true;
		else if (size != l1.size)
			return false;
		FileNameNode<T> *walkl1 = l1.head;
		FileNameNode<T> *walk = head;
		for(int i=0; i<size; i++) {
			if(walk->data != walkl1->data)
				return false;
			walk = walk->next;
			walkl1 = walkl1->next;
		}
		return true;
	}

    void traverse() const{
		FileNameNode<T> *walk = head;
		if(walk != NULL){
			while(walk != NULL){
				cout<<walk->data<<"->";
				walk = walk->next;
			}
			cout<<"NULL"<<endl;
		}


		else
			cout<<"Void"<<endl;
	}

	bool setFunction (const int num) {
		FileNameNode<T> *walk = head;
		bool found = false;
		if (walk != NULL) {
			while (walk != NULL) {
				if (walk->data == num) {
					found = true;
					break;
				}
				walk = walk->next;
			}
		}
		return found;
	}

	void appendEnd(const T &data) {
		if(setFunction(data) == false) {
			FileNameNode<T> *newNode = new FileNameNode<T>(data);
			FileNameNode<T> *walk = head;
			if(walk == NULL) {
				head = newNode;
				return;
			}
			while(walk->next != NULL) {
				walk = walk->next;
			}
			walk->next = newNode;
		}
	}
};

template<class T>
class WordTypeBinaryTreeNode {
public:
	WordTypeBinaryTreeNode *left;
	WordTypeBinaryTreeNode *right;
	T word;
	LinkedList<int> files;
	WordTypeBinaryTreeNode() : left(NULL), right(NULL) { }
	WordTypeBinaryTreeNode(const T &w) : left(NULL), right(NULL), word(w) { }
};

template<class T>
class IndexBinaryTreeList {
private:
	WordTypeBinaryTreeNode<T> *root;
public:
	IndexBinaryTreeList() : root(NULL) { }

    void setWord(const string &r, int fname) {
		if (root == NULL) {
			root = new WordTypeBinaryTreeNode<T>(r);
			root->files.appendEnd(fname);
        }
		else {
			WordTypeBinaryTreeNode<T> *walk = root;
			while (walk != NULL) {
				if (r < walk->word) {
					if (walk->left == NULL) {
						walk->left = new WordTypeBinaryTreeNode<T>(r);
                        walk->files.appendEnd(fname);
						break;
					}
					walk = walk->left;
				}
				else if (r > walk->word) {
					if (walk->right == NULL) {
						walk->right = new WordTypeBinaryTreeNode<T>(r);
                        walk->files.appendEnd(fname);
						break;
					}
					walk = walk->right;
				}
				else if (walk->word == r) {
                    walk->files.appendEnd(fname);
					break;
				}
			}
		}
	}

	void printFiles(const string &r) {
		WordTypeBinaryTreeNode<T> *walk = root;
		int found = false;
		while (walk != NULL) {
			if (r == walk->word) {
                walk->files.traverse();
				cout << endl;
                found = true;
				break;
			}
			else if (r < walk->word) {
				walk = walk->left;
			}
			else {
				walk = walk->right;
			}
		}
        if (found == false) {
			cout << "Not found!" << endl << endl;
		}
	}
};

string toLower(string words) {
    char str[100];
    string temp;
    strcpy(str, words.c_str());
    char ch;
    int length = strlen(str);
    for (int i = 0; i < length; i++) {
        strncpy(&ch, str + i, 1);
        if (((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '?' && ch <= '@') || (ch >= '{' && ch <= '}' || (ch >= '!' && ch <= '/'))) && !isalnum(ch)) {
            words.erase(remove_if(words.begin(), words.end(), [](char ch)
			{ return ch == ',' || ch == '.' || ch == '!' || ch == '"' || ch == '?' || ch == '-' || ch == ':' || ch == ';'  || ch == '\''; }), words.end());
            memcpy(str + i, &ch, 1);
        }
    }
    temp = str;
	return temp;
}

bool check(const string w) {
    bool found = false;
    string low = toLower(w);
	return found;
}

double get_CPU_time_usage(clock_t clock1, clock_t clock2) {
	double diffticks = clock1 - clock2;
	double diffms = (diffticks * 1000) / (CLOCKS_PER_SEC * 1000);
	return diffms;
}

int main() {
	clock_t startTime, endTime;
	startTime = clock();
	IndexBinaryTreeList<string> index;
	string w;
	int i = 1;
	cout << "            ------------------------------" << endl << "            {{{{{INDEX SEARCH PROCESS}}}}}" << endl << "            ------------------------------" << endl << endl;
	while (i < total) {
		string path = "AllDocs//";
		string name = path.append(to_string(i)).append(".txt");
		string txt;
		ifstream inFile;
		inFile.open(name);

		while (inFile >> txt) {
			if (check(txt) == false) {
				index.setWord(toLower(txt), i);
			}
		}
		i++;
	}

	do {
		string w;
		cout << "Input to search texts for a word (Input '4' to exit! ) : ";
		cin >> w;
		if (toLower(w) == "4") {
			break;
		}
		else {
			index.printFiles(toLower(w));
		}
	} while (w != "4");
	endTime = clock();
	double elapseTime = get_CPU_time_usage(endTime, startTime);
	cout << endl << "This search process took "<< elapseTime << " seconds" << endl;
	return 0;
}
