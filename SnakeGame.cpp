#include <iostream>
#include <random>

using namespace std;

class Coordinates {

private:
    int x;
    int y;

    public:
    Coordinates(int xVal, int yVal) {

        int x = xVal;
        int y = yVal;

    }

    Coordinates(const Coordinates& coord) {

        x = coord.x;
        y = coord.y;

    }

    ~Coordinates() {

        cout << "Destructor called" << endl;

    }

    int getx() {

        return x;

    }

    int gety() {

        return y;

    }

    void setx(int xVal) {

        x = xVal;

    }

    void sety(int yVal) {

        y = yVal;

    }
};

class Snake {

private:
    string snake = "O";
    Coordinates head;
    int length;

public:

    Snake(int xVal, int yVal) : head(xVal, yVal) {
    
        length = 1;
    }

    Snake(const Snake& snake) : head(snake.getHead()) {

        length = snake.length;

    }

    void addSegment() {

        length++;

    }

    void move(char direction) {

        if (direction == 'w') {

            head.sety((head).gety() + 1);

        }

        else if (direction == 'a') {

            head.setx((head).getx() - 1);

        }

        else if (direction == 's') {

            head.sety((head).gety() - 1);

        }

        else if (direction == 'd') {

            head.setx((head).getx() + 1);

        }

    }

    Coordinates getHead() const {

        return head;

    }

    string getSnake() {

        return snake;

    }

    int getLength() {

        return length;

    }
};

int main() {
    
    Coordinates grid(50, 50); // Grid size
    Snake snake(25, 25); // Snake starting position

    for (int i = 0; i < grid.gety(); ++i) {

        for (int j = 0; j < grid.getx(); ++j) {

            if (i == (snake.getHead()).gety() && j == (snake.getHead()).getx()) {

                cout << "O";

            }

            else if (i == 0 || j == 0 || i < grid.gety() || j < grid.getx()) {

                cout << "#";

            }

            else {

                cout << " ";

            }

        }

        cout << endl;
    }
    

}
