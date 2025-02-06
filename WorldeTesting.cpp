#include <iostream>
#include <fstream>
#include <string>
#include <cctype>
#include <algorithm>
#include <cstring>

using namespace std;

class WordFinder {

    public:

    string oldword;

    WordFinder(string word) {

        oldword = word;

    }

    string getWord() {

        return oldword;
    }

    void setWord(string word) {

        oldword = word;

    }

};

int main () {

    cout << "Enter in a word";
    string otherWord;
    string firstWord = "GREAT";

    getline(cin, otherWord);

    toupper(otherWord);
    WordFinder worder(otherWord);

    if (firstWord.contains(worder.getWord()[0])) {

        cout << "Found it!";
    }

    else {

        cout << "Not available";
    }

    return 0;
}