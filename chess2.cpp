#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Coordinates {

private:

	int x;
	int y;

public:

	Coordinates() {
		x = 0;
		y = 0;
	}

	Coordinates(int xCor, int yCor) {

		x = xCor;
		y = yCor;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	void setX(int xCor) {
		x = xCor;
	}

	void setY(int yCor) {
		y = yCor;
	}

};

class Piece {

private:

	string name;
	string color;
	Coordinates position;

public:

	Piece() {

		name = " ";
		color = " ";
		position = Coordinates();
	}

	Piece(string type, string colour, int x, int y) {

		name = type;
		color = colour;
		position = Coordinates(x, y);
	}

	string getName() {

		return name;

	}

	string getColor() {
		return color;
	}

	Coordinates getPosition() {

		return position;
	}

	void setName(string type) {
		name = type;
	}

	void setColor(string colour) {
		color = colour;
	}

	void setPosition(int x, int y) {
		position.setX(x);
		position.setY(y);
	}

};

class Player {

private:

	Piece** blackPieces;
	Piece** whitePieces;

public:

	Player() {

		int place = 0; 

		blackPieces = new Piece * [16];
		whitePieces = new Piece * [16];

		for (int i = 0; i < 32; i++) {

				if (i >= 0 && i < 8) {

					blackPieces[i] = new Piece("P", "black", 2, i + 1);
				}

				else if (i == 8 || i == 15) {

					if (i == 8) {

						blackPieces[i] = new Piece("R", "black", 1, 1);
					}

					else {

						blackPieces[i] = new Piece("R", "black", 1, 8);
					}
				}

				else if (i == 9 || i == 14) {

					if (i == 9) {

						blackPieces[i] = new Piece("N", "black", 1, 2);
					}

					else {

						blackPieces[i] = new Piece("N", "black", 1, 7);
					}

				}
				else if (i == 10 || i == 13) {

					if (i == 10) {

						blackPieces[i] = new Piece("B", "black", 1, 3);
					}

					else {

						blackPieces[i] = new Piece("B", "black", 1, 6);
					}
				}

				else if (i == 11) {

					blackPieces[i] = new Piece("Q", "black", 1, 4);
				}

				else if (i == 12) {
					
					blackPieces[i] = new Piece("K", "black", 1, 5);
				}

				else if (i >= 16 && i < 24) {

					whitePieces[place] = new Piece("p", "white", 7, i - 15);
					place++;
				}

				else if (i == 24 || i == 31) {

					if (i == 24) {

						whitePieces[place] = new Piece("r", "white", 8, 1);
						place++;
					}

					else {

						whitePieces[place] = new Piece("r", "white", 8, 8);
						place++;
					}
				}

				else if (i == 25 || i == 30) {

					if (i == 25) {

						whitePieces[place] = new Piece("n", "white", 8, 2);
						place++;
					}

					else {

						whitePieces[place] = new Piece("n", "white", 8, 7);
						place++;
					}

				}
				else if (i == 26 || i == 29) {

					if (i == 26) {

						whitePieces[place] = new Piece("b", "white", 8, 3);
						place++;
					}

					else {

						whitePieces[place] = new Piece("b", "white", 8, 6);
						place++;
					}
				}

				else if (i == 27) {

					whitePieces[place] = new Piece("q", "white", 8, 4);
					place++;
				}

				else if (i == 28) {

					whitePieces[place] = new Piece("k", "white", 8, 5);
					place++;
			}

		}
	}

	Player(Piece** black) {

		blackPieces = black;
		
	}

	Piece** getBlackPieces() {

		return blackPieces;
	}

	Piece** getWhitePieces() {

		return whitePieces;
	}

	void setBlackPieces(Piece** black) {
		blackPieces = black;
	}

	void setWhitePieces(Piece** white) {
		whitePieces = white;
	}
};

class Board {

private:

	vector<vector<Coordinates>> board;
	Player* player1;
	Player* player2;
	bool gameOver;

public:
	Board() {

		board = vector<vector<Coordinates>>(10, vector<Coordinates>(10));
		player1 = new Player();
		player2 = new Player();
		gameOver = false;

		for (int i = 0; i < 10; ++i) {

			for (int j = 0; j < 10; ++j) {

				board[i][j] = Coordinates(i, j);
			}
		}
	}

	vector<vector<Coordinates>> getBoard() {

		return board;
	}

	void makeBoard() {

		for (int i = 0; i < 10; ++i) {

			for (int j = 0; j < 10; ++j) {

				if ((board[i][j]).getX() == 0 || board[i][j].getX() == 9) {

					cout << "#";
				}

				else if (board[i][j].getY() == 0 || board[i][j].getY() == 9) {


					cout << "#";
				}

				else if (board[i][j].getX() == 2) {

					if (board[i][j].getY() == 1 ) {

						cout << player1->getBlackPieces()[0]->getName();

					}

					else if (board[i][j].getY() == 2) {

						cout << player1->getBlackPieces()[1]->getName();
					}

					else if (board[i][j].getY() == 3) {

						cout << player1->getBlackPieces()[2]->getName();
					}

					else if (board[i][j].getY() == 4) {

						cout << player1->getBlackPieces()[3]->getName();
					}

					else if (board[i][j].getY() == 5) {

						cout << player1->getBlackPieces()[4]->getName();
					}

					else if (board[i][j].getY() == 6) {

						cout << player1->getBlackPieces()[5]->getName();
					}

					else if (board[i][j].getY() == 7) {

						cout << player1->getBlackPieces()[6]->getName();
					}

					else if (board[i][j].getY() == 8) {

						cout << player1->getBlackPieces()[7]->getName();
					}
	
				}

				else if (board[i][j].getX() == 1) {


						if (board[i][j].getY() == 1) {

							cout << player1->getBlackPieces()[8]->getName();
						}

						else if (board[i][j].getY() == 8) {

							cout << player1->getBlackPieces()[15]->getName();
						}

						else if (board[i][j].getY() == 2) {

							cout << player1->getBlackPieces()[9]->getName();
						}

						else if (board[i][j].getY() == 7) {

							cout << player1->getBlackPieces()[14]->getName();
						}

						else if (board[i][j].getY() == 3) {

							cout << player1->getBlackPieces()[10]->getName();
						}

						else if (board[i][j].getY() == 6) {

							cout << player1->getBlackPieces()[13]->getName();
						}

						else if (board[i][j].getY() == 4) {

							cout << player1->getBlackPieces()[11]->getName();
						}

						else if (board[i][j].getY() == 5) {

							cout << player1->getBlackPieces()[12]->getName();
						}
						
				}

				else if (board[i][j].getX() == 7) {

					if (board[i][j].getY() == 1) {

						cout << player2->getWhitePieces()[0]->getName();
					}

					else if (board[i][j].getY() == 2) {

						cout << player2->getWhitePieces()[1]->getName();
					}

					else if (board[i][j].getY() == 3) {

						cout << player2->getWhitePieces()[2]->getName();
					}

					else if (board[i][j].getY() == 4) {

						cout << player2->getWhitePieces()[3]->getName();
					}

					else if (board[i][j].getY() == 5) {

						cout << player2->getWhitePieces()[4]->getName();
					}

					else if (board[i][j].getY() == 6) {

						cout << player2->getWhitePieces()[5]->getName();
					}

					else if (board[i][j].getY() == 7) {

						cout << player2->getWhitePieces()[6]->getName();
					}

					else if (board[i][j].getY() == 8) {

						cout << player2->getWhitePieces()[7]->getName();
					}

				}

				else if (board[i][j].getX() == 8) {

					if (board[i][j].getY() == 1) {

						cout << player2->getWhitePieces()[8]->getName();
					}

					else if (board[i][j].getY() == 2) {

						cout << player2->getWhitePieces()[9]->getName();
					}

					else if (board[i][j].getY() == 3) {

						cout << player2->getWhitePieces()[10]->getName();
					}

					else if (board[i][j].getY() == 4) {

						cout << player2->getWhitePieces()[11]->getName();
					}

					else if (board[i][j].getY() == 5) {

						cout << player2->getWhitePieces()[12]->getName();
					}

					else if (board[i][j].getY() == 6) {

						cout << player2->getWhitePieces()[13]->getName();
					}

					else if (board[i][j].getY() == 7) {

						cout << player2->getWhitePieces()[14]->getName();
					}

					else if (board[i][j].getY() == 8) {

						cout << player2->getWhitePieces()[15]->getName();
					}
				}

				else {

					cout << " ";
				}
			}
	
			cout << "\n";
		}
	}

	void makeMove(int oldX, int oldY, int newX, int newY, string piece, int num) {

		if (num == 0) {

			for (int i = 0; i < 16; ++i) {
				
				if (player1->getBlackPieces()[i]->getName() == piece && (player1->getBlackPieces()[i]->getPosition().getX() == oldX && player1->getBlackPieces()[i]->getPosition().getY() == oldY)) {

					player1->getBlackPieces()[i]->setPosition(newX, newY);

					for (int i = 0; i < 16; ++i) {

						if (player2->getWhitePieces()[i]->getPosition().getX() == newX && player2->getWhitePieces()[i]->getPosition().getY() == newY) {

							if (player2->getWhitePieces()[i]->getName() == "k") {

								cout << "Player 1 wins!" << endl;
								gameOver = true;
							}

							else {

							player2->getWhitePieces()[i]->setPosition(11, 11);
							break;
							}
						}
					}

					break;
				}

			}
		}

		else if (num != 0) {

			for (int i = 0; i < 16; ++i) {

				if (player2->getWhitePieces()[i]->getName() == piece && (player2->getWhitePieces()[i]->getPosition().getX() == oldX && player2->getWhitePieces()[i]->getPosition().getY() == oldY)) {

					player2->getWhitePieces()[i]->setPosition(newX, newY);
					
					for (int i = 0; i < 16; ++i) {

						if (player1->getBlackPieces()[i]->getPosition().getX() == newX && player1->getBlackPieces()[i]->getPosition().getY() == newY) { 
							
							if (player1->getBlackPieces()[i]->getName() == "K") {

								cout << "Player 2 wins!" << endl;
								gameOver = true;
							}

							else {
							player1->getBlackPieces()[i]->setPosition(11, 11);
							break;
							}
						}
					}

					break;
				}

			}
		}

		for (int i = 0; i < 10; ++i) {

			for (int j = 0; j < 10; ++j) {

				if ((board[i][j]).getX() == 0 || board[i][j].getX() == 9) {

					cout << "#";
				}

				else if (board[i][j].getY() == 0 || board[i][j].getY() == 9) {

					cout << "#";
				}

				else if (board[i][j].getX() == player1->getBlackPieces()[0]->getPosition().getX() && board[i][j].getY() == player1->getBlackPieces()[0]->getPosition().getY()) {

					cout << player1->getBlackPieces()[0]->getName();
				}

				else if (board[i][j].getX() == player1->getBlackPieces()[1]->getPosition().getX() && board[i][j].getY() == player1->getBlackPieces()[1]->getPosition().getY()) {

					cout << player1->getBlackPieces()[1]->getName();
				}

				else if (board[i][j].getX() == player1->getBlackPieces()[2]->getPosition().getX() && board[i][j].getY() == player1->getBlackPieces()[2]->getPosition().getY()) {

					cout << player1->getBlackPieces()[2]->getName();
				}

				else if (board[i][j].getX() == player1->getBlackPieces()[3]->getPosition().getX() && board[i][j].getY() == player1->getBlackPieces()[3]->getPosition().getY()) {

					cout << player1->getBlackPieces()[3]->getName();
				}

				else if (board[i][j].getX() == player1->getBlackPieces()[4]->getPosition().getX() && board[i][j].getY() == player1->getBlackPieces()[4]->getPosition().getY()) {

					cout << player1->getBlackPieces()[4]->getName();
				}

				else if (board[i][j].getX() == player1->getBlackPieces()[5]->getPosition().getX() && board[i][j].getY() == player1->getBlackPieces()[5]->getPosition().getY()) {

					cout << player1->getBlackPieces()[5]->getName();
				}

				else if (board[i][j].getX() == player1->getBlackPieces()[6]->getPosition().getX() && board[i][j].getY() == player1->getBlackPieces()[6]->getPosition().getY()) {

					cout << player1->getBlackPieces()[6]->getName();
				}

				else if (board[i][j].getX() == player1->getBlackPieces()[7]->getPosition().getX() && board[i][j].getY() == player1->getBlackPieces()[7]->getPosition().getY()) {

					cout << player1->getBlackPieces()[7]->getName();
				}

				else if (board[i][j].getX() == player1->getBlackPieces()[8]->getPosition().getX() && board[i][j].getY() == player1->getBlackPieces()[8]->getPosition().getY()) {

					cout << player1->getBlackPieces()[8]->getName();
				}

				else if (board[i][j].getX() == player1->getBlackPieces()[9]->getPosition().getX() && board[i][j].getY() == player1->getBlackPieces()[9]->getPosition().getY()) {

					cout << player1->getBlackPieces()[9]->getName();
				}

				else if (board[i][j].getX() == player1->getBlackPieces()[10]->getPosition().getX() && board[i][j].getY() == player1->getBlackPieces()[10]->getPosition().getY()) {

					cout << player1->getBlackPieces()[10]->getName();
				}

				else if (board[i][j].getX() == player1->getBlackPieces()[11]->getPosition().getX() && board[i][j].getY() == player1->getBlackPieces()[11]->getPosition().getY()) {

					cout << player1->getBlackPieces()[11]->getName();
				}

				else if (board[i][j].getX() == player1->getBlackPieces()[12]->getPosition().getX() && board[i][j].getY() == player1->getBlackPieces()[12]->getPosition().getY()) {

					cout << player1->getBlackPieces()[12]->getName();
				}

				else if (board[i][j].getX() == player1->getBlackPieces()[12]->getPosition().getX() && board[i][j].getY() == player1->getBlackPieces()[12]->getPosition().getY()) {

					cout << player1->getBlackPieces()[12]->getName();
				}

				else if (board[i][j].getX() == player1->getBlackPieces()[13]->getPosition().getX() && board[i][j].getY() == player1->getBlackPieces()[13]->getPosition().getY()) {

					cout << player1->getBlackPieces()[13]->getName();
				}

				else if (board[i][j].getX() == player1->getBlackPieces()[14]->getPosition().getX() && board[i][j].getY() == player1->getBlackPieces()[14]->getPosition().getY()) {

					cout << player1->getBlackPieces()[14]->getName();
				}

				else if (board[i][j].getX() == player1->getBlackPieces()[15]->getPosition().getX() && board[i][j].getY() == player1->getBlackPieces()[15]->getPosition().getY()) {

					cout << player1->getBlackPieces()[15]->getName();
				}

				else if (board[i][j].getX() == player2->getWhitePieces()[0]->getPosition().getX() && board[i][j].getY() == player2->getWhitePieces()[0]->getPosition().getY()) {

					cout << player2->getWhitePieces()[0]->getName();
				}

				else if (board[i][j].getX() == player2->getWhitePieces()[1]->getPosition().getX() && board[i][j].getY() == player2->getWhitePieces()[1]->getPosition().getY()) {

					cout << player2->getWhitePieces()[1]->getName();
				}

				else if (board[i][j].getX() == player2->getWhitePieces()[2]->getPosition().getX() && board[i][j].getY() == player2->getWhitePieces()[2]->getPosition().getY()) {

					cout << player2->getWhitePieces()[2]->getName();
				}

				else if (board[i][j].getX() == player2->getWhitePieces()[3]->getPosition().getX() && board[i][j].getY() == player2->getWhitePieces()[3]->getPosition().getY()) {

					cout << player2->getWhitePieces()[3]->getName();
				}

				else if (board[i][j].getX() == player2->getWhitePieces()[4]->getPosition().getX() && board[i][j].getY() == player2->getWhitePieces()[4]->getPosition().getY()) {

					cout << player2->getWhitePieces()[4]->getName();
				}

				else if (board[i][j].getX() == player2->getWhitePieces()[5]->getPosition().getX() && board[i][j].getY() == player2->getWhitePieces()[5]->getPosition().getY()) {

					cout << player2->getWhitePieces()[5]->getName();
				}

				else if (board[i][j].getX() == player2->getWhitePieces()[6]->getPosition().getX() && board[i][j].getY() == player2->getWhitePieces()[6]->getPosition().getY()) {

					cout << player2->getWhitePieces()[6]->getName();
				}

				else if (board[i][j].getX() == player2->getWhitePieces()[7]->getPosition().getX() && board[i][j].getY() == player2->getWhitePieces()[7]->getPosition().getY()) {

					cout << player2->getWhitePieces()[7]->getName();
				}

				else if (board[i][j].getX() == player2->getWhitePieces()[8]->getPosition().getX() && board[i][j].getY() == player2->getWhitePieces()[8]->getPosition().getY()) {

					cout << player2->getWhitePieces()[8]->getName();
				}

				else if (board[i][j].getX() == player2->getWhitePieces()[9]->getPosition().getX() && board[i][j].getY() == player2->getWhitePieces()[9]->getPosition().getY()) {

					cout << player2->getWhitePieces()[9]->getName();
				}

				else if (board[i][j].getX() == player2->getWhitePieces()[10]->getPosition().getX() && board[i][j].getY() == player2->getWhitePieces()[10]->getPosition().getY()) {

					cout << player2->getWhitePieces()[10]->getName();
				}

				else if (board[i][j].getX() == player2->getWhitePieces()[11]->getPosition().getX() && board[i][j].getY() == player2->getWhitePieces()[11]->getPosition().getY()) {

					cout << player2->getWhitePieces()[11]->getName();
				}

				else if (board[i][j].getX() == player2->getWhitePieces()[12]->getPosition().getX() && board[i][j].getY() == player2->getWhitePieces()[12]->getPosition().getY()) {

					cout << player2->getWhitePieces()[12]->getName();
				}

				else if (board[i][j].getX() == player2->getWhitePieces()[13]->getPosition().getX() && board[i][j].getY() == player2->getWhitePieces()[13]->getPosition().getY()) {

					cout << player2->getWhitePieces()[13]->getName();
				}

				else if (board[i][j].getX() == player2->getWhitePieces()[14]->getPosition().getX() && board[i][j].getY() == player2->getWhitePieces()[14]->getPosition().getY()) {

					cout << player2->getWhitePieces()[14]->getName();
				}
		
				else if (board[i][j].getX() == player2->getWhitePieces()[15]->getPosition().getX() && board[i][j].getY() == player2->getWhitePieces()[15]->getPosition().getY()) {

					cout << player2->getWhitePieces()[15]->getName();
				}

				else {

					cout << " ";
				}
			}

			cout << "\n";
		}

	}

	bool getGameOver() {

		return gameOver;
	}

	void pieceInformation() {

	cout << "Chess information: \n";
	cout << "---------------------------------------------";
	cout << "p = pawn \n";
	cout << "r = rook \n";
	cout << "n = knight \n";
	cout << "b = bishop \n";
	cout << "q = queen \n";
	cout << "k = king \n";

	cout << "The board is an 8x8 grid, so enter the row and column as appropriate: \n";	
	cout << "--------------------------------------------- \n";

	}	
};

int main() {

	Board* board = new Board();
	board->makeBoard();
	int turn = 1;
	bool gameOver = false;

	board->pieceInformation();

	while(!gameOver) {
	string piece;
	int oldX, oldY, newX, newY;

	cout << "Enter the piece you want to move, the old coordinates, and the new coordinates" << endl;
	
	cin >> piece >> oldX >> oldY >> newX >> newY;

	if (turn % 2 != 0) {

		board->makeMove(oldX, oldY, newX, newY, piece, 0);
		turn++;
	}

	else if (turn % 2 == 0) {

		board->makeMove(oldX, oldY, newX, newY, piece, 1);
		turn++;
	}

	gameOver = board->getGameOver();

	}

	return 0;
}
