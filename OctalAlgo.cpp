#include <iostream>

using namespace std;

int main () {

    cout << "Enter a starting number" << endl;

    int startingNum;
    int newValue;
    cin >> startingNum;

    int* remainders = new int[100];
    int size = 0;
    int i = 0;

    newValue = startingNum;

    while (newValue > 0) {
        
        if (newValue < 8) {

            ++size;
            remainders[size - 1] = newValue;
            break;
        }

        else {

            ++size;
            remainders[size - 1] = newValue % 8;
            newValue = newValue / 8;

        }
    }

    cout << "Octal Representation: ";
    
    while (i < size) {

        cout << remainders[size - 1];
        --size;
    }

    return 0;
    
}