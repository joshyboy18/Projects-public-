#include <iostream>
#include <array>

using namespace std;

int OversizeFlowers(string array[], int size, int number) {

    int i = size;
    string answer;
    int start = 0;

    while (start < number) {

        cout << "Enter the flower you would like to add \n";
        cin >> answer;

        array[i] = answer;
        cout << "Added \n";

        ++start;
        ++i;
    }

    return i;

}

int main() {

    cout << "Welcome to Robinson Roses! What is your order of flowers today? (enter quit to stop adding flowers) \n";

    int index = 0;
    string name;
    string flowers[100];
    int amount;

    cin >> name;

    while (name != "quit") {


        cout << "added - enter the next flower \n";
        flowers[index] = name; 
        ++index;
        cin >> name;
    }

    cout<< "\n";

    cout<< "FlowerList: \n";

    for (int i = 0; i < index; ++i) {

        cout << (i + 1) << ". " << flowers[i] << "\n";
    }
    
    cout << "How many flowers do you want to add now? \n";

    cin >> amount;

    int newSize = OversizeFlowers(flowers, index, amount);

     cout << "New flowerlist \n";
     cout << "------------------ \n";

    for (int i = 0; i < newSize; ++i) {

        cout << (i + 1) << ". " << flowers[i] << "\n";

    }
    
    return 0;
}

