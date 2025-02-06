#include <iostream>
#include <vector>
#include <string>

using namespace std;

class TicTacToe {

    private:
        vector<vector<char>> board;
        string player1;
        string player2;
        int turn;

    public:

    TicTacToe(string playerOne, string playerTwo) {

        player1 = playerOne;
        player2 = playerTwo;
        turn = 0;
        board = vector<vector<char>>(3, vector<char>(3, ' '));
    }

    void printBoard() {

        cout << board[0][0] << " | " << board[0][1] << " | " << board[0][2] << endl;
        cout << "---------" << endl;
        cout << board[1][0] << " | " << board[1][1] << " | " << board[1][2] << endl;
        cout << "---------" << endl;
        cout << board[2][0] << " | " << board[2][1] << " | " << board[2][2] << endl;

    }

    int getTurn() {
        return turn;
    }

    void addTurn() {

        turn++;
    }

    void setTurn(int t) {
        turn = t;
    }

    string getPlayer1() {
        return player1;
    }

    void setPlayer1(string p) {
        player1 = p;
    }

    string getPlayer2() {
        return player2;
    }

    void setPlayer2(string p) {
        player2 = p;
    }

    vector<vector<char>> getBoard() {
        return board;
    }

    void setBoard(vector<vector<char>> b) {
        board = b;
    }

    void makeMove(int row, int col) {

        if (turn % 2 == 0) {

            board[row][col] = 'X';
        } 
        
        else {

            board[row][col] = 'O';
        }
     }

     bool win() {

        for (int i = 0; i < 3; ++i) {

            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ' && board[i][1] != ' ' && board[i][2] != ' ') {
                
                return true;
            }

            else if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ' && board[1][i] != ' ' && board[2][i] != ' ') {

                return true;
            }

            else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ' && board[1][1] != ' ' && board[2][2] != ' ') {

                return true;
            }

            else if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != ' ' && board[1][1] != ' ' && board[0][2] != ' ') {

                return true;
            }

            else {

                return false;
            }
        }
     }
};

int main() {

    TicTacToe game("Player 1", "Player 2");
    bool gameRunning = true;
    int row, col;

    while(gameRunning) {

        game.printBoard();
        if (game.getTurn() % 2 == 0) {

            cout << "Player 1, enter row and column: ";
        }

        else {

            cout << "Player 2, enter row and column: ";
        }

        cin >> row >> col;
        game.makeMove(row, col);
        game.win();

        if (game.win()) {

            game.printBoard(); // Print the board one last time

            if (game.getTurn() % 2 == 0) {

                cout << "Player 1 wins!" << endl;
                gameRunning = false;
            }

            else {

                cout << "Player 2 wins!" << endl;
                gameRunning = false;
            }
        }

        else if (game.getTurn() == 9) {

            cout << "It's a tie!" << endl;
            gameRunning = false;
        }

        game.addTurn();

    }

    return 0;
}


