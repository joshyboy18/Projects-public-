#include <iostream>
#include <vector>
#include <string>

using namespace std;

struct Coordinates {

    int x;
    int y;

};

class Piece {

    private:
    Coordinates position;
    string color;
    string letter;
    bool isKing;

    public:

    Piece() {

        position.x = 0;
        position.y = 0;
        color = "";
        isKing = false;
        letter = "";
    }

    Piece(int x, int y, string color, bool king, string let) {

        position.x = x;
        position.y = y;
        this->color = color;
        isKing = king;
        letter = let;
    }

    void setPosition(int x, int y) {

        position.x = x;
        position.y = y;
    }

    void setColor(string color) {

        this->color = color;
    }

    int getX() {

        return position.x;
    }

    int getY() {

        return position.y;
    }

    string getColor() {

        return color;
    }

    string getLetter() {

        return letter;
    }

};

class Board {

    private:

    Piece* black[12];
    Piece* white[12];

    public:

    Board() {


        int placeholder = 0;
        int placeholder2 = 0; 

        for (int i = 0; i < 10; ++i) { // rows

            for (int j = 0; j < 10; ++j) { // columns 

                if ((i > 0 && i < 4) && (j > 0 && j < 9)) {

                        if (i % 2 == 0) { // even row number 
                            black[placeholder] = new Piece(i, j + 1, "black", false, "B");
                            ++placeholder;
                            ++j;
                        }

                        else if (i % 2 != 0) {

                            black[placeholder] = new Piece(i, j, "black", false, "B"); // odd row number
                            ++placeholder;
                            ++j;

                        }

                    }

                else if ((i > 5 && i < 9) && (j > 0 && j < 9)) {

                    if (i % 2 == 0) {

                        white[placeholder2] = new Piece(i, j + 1, "white", false, "W");
                        ++placeholder2;
                        ++j;
                    }

                    else {

                        white[placeholder2] = new Piece(i, j, "white", false, "W");
                        ++placeholder2;
                        ++j;
                    }
                }

            }

        }
             
    }

    void printBoard(int oldx, int oldy, int newx, int newy, int turn) {

        int placeholder = 0; 
        int placeholder2 = 0;

        if (oldx != 0 && oldy != 9) {

            if (turn % 2 != 0 && turn != 0) {
            
                for (int index = 0; index < 12; ++index) {

                    if (black[index]->getX() == oldx && black[index]->getY() == oldy)  {

                        black[index]->setPosition(newx, newy);
                        break;

                    }
                }
            }

            else  {

                for (int index = 0; index < 12; ++index) {
                    
                    if (white[index]->getX() == oldx && white[index]->getY() == oldy)  {

                        white[index]->setPosition(newx, newy); 
                        
                        for (int index2 = 0; index2 < 12; index2++) {
                            
                            if (oldx == black[index2]->getX() + 1 && oldy == black[index2]->getY()-1) {

                                if (newx == black[index2]->getX() - 1 && newy == black[index2]->getY() + 1) {

                                    black[index2]->setPosition(-1,-1);
                                    break;
                                }
                                
                            }

                            else if (oldx == black[index2]->getX() + 1 && oldy == black[index2]->getY() + 1) {

                                if (newx == black[index2]->getX() - 1 && newy == black[index2]->getY() - 1) {

                                    black[index2]->setPosition(-1,-1);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 10; ++i) {

            for (int j = 0; j < 10; ++j) {

                if (i == 0 || i == 9) {

                    cout << "#";
                }

                else if (j == 0 || j == 9) {

                    cout << "#";

                }

                else if (black[placeholder]->getX() == i && black[placeholder]->getY() == j) {

                    cout << black[placeholder]->getLetter();
                    ++placeholder;
                      
                }

                else if (white[placeholder2]->getX() == i && white[placeholder2]->getY()==j) {
                    
                    cout << white[placeholder2]->getLetter();
                    ++placeholder2;
                }

                else {

                    cout << "*";
                }
                
            }

            cout << endl;
        }

        for (int i = 0; i < 12; ++i) {

            cout << "Black position " << i << ": " << black[i]->getX() << " " << black[i]->getY() << endl;
            
        }
    }

    
};

int main() {

    Board* board = new Board();

    board->printBoard(0, 0, 0, 0, 0, 0, 0);
    int turn = 1;
    int x1, y1, x2, y2, x3, y3;

    bool gameOver = false;

    while (!gameOver) {

        if (turn % 2 == 0) {

            cout << "White's turn! Type the current coordinate and the desired coordinate (format: oldX, oldY, newX, newY)" << endl;
            cin >> x1 >> y1 >> x2 >> y2, x3, y3;
            board->printBoard(x1, y1, x2, y2, turn, x3, y3);
            ++turn;
        }

        else {
            
            cout << "Black's turn! Type the current coordinate and the desired coordinate (format: oldX, oldY, newX, newY)" << endl;
            cin >> x1 >> y1 >> x2 >> y2;
            board->printBoard(x1, y1, x2, y2, turn, x3, y3);
            ++turn;
        }

    }
    

    return 0;
}