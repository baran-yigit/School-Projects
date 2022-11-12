#include "FileNameNode.h"
#include <iostream>
#include <string>
using namespace std;

FileNameNode::FileNameNode(string s) :next(NULL), below(NULL), word(s) { }

FileNameNode::~FileNameNode() { }
