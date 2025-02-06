#include <iostream>
#include <vector> 
#include <string>

using namespace std;

struct Values {

    int value;
    string color;

};

class BlackMatrix {
    
    private:

        vector<vector<Values>> matrix;
        int rows;
        int cols;
    
    public:

        BlackMatrix() {

            rows = 0;
            cols = 0;
            matrix = vector<vector<Values>>(1, vector<Values>(1));
        }

        BlackMatrix(int row, int col, vector<vector<Values>> mat) {

            rows = row;
            cols = col;
            matrix = mat;
        }

        void setMatrix(vector<vector<Values>> mat) {

            matrix = mat;

        }

        Values getValue(int row, int col) {

            return matrix[row][col];

        }

        void setRows(int row) {

            rows = row;
        }

        void setCols(int col) {

            cols = col;
        }

        int getRows() {

            return rows;
        }

        int getCols() {

            return cols;
        }

};

int main() {

    int value;
    string color;
    int rows;
    int columns;
    Values val;

    cin >> rows >> columns;

    vector<vector<Values>> matrix(rows, vector<Values>(columns));
    
    cout << rows << " " << columns << endl;

    for (int i = 0; i < rows; i++) {

        for (int j = 0; j < columns; j++) {

            cin >> value;
            cout << value << " ";

            if (value < 100) {

                val.color = "black";
            }

            else {

                val.color = "";
            }

            val.value = value;

            matrix[i][j] = val;

        }

        cout << endl;
        
    }
    
    BlackMatrix blackMatrix(rows, columns, matrix);

    cout << blackMatrix.getRows() << " " << blackMatrix.getCols() << endl;

    for (int i = 0; i < rows; ++i) {

        for (int j = 0; j < columns; ++j) {

            if (blackMatrix.getValue(i,j).color != "black") {

                cout << blackMatrix.getValue(i,j).value << " ";

            }
        }
    }

    return 0;
}