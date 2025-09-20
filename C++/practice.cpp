#include <vector>
#include <iostream>

using namespace std;

int main() {

    vector<int> sort = {5, 3, 8, 1, 4, 7, 9, 2, 6};
    int j;
    int i;
    int temp = 0;

    for (i = 0; i < sort.size() - 1; ++i) {

    j = i + 1;
    
    while (j > 0 && sort[j] < sort[j - 1]) {

        temp = sort[j];
        sort[j] = sort[j - 1];
        sort[j - 1] = temp;
        --j;
    }
 }

 for (i = 0; i < sort.size(); ++i) {

    cout << sort[i] << " ";
 }

 return 0;
}