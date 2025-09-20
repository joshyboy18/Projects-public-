#include <iostream>
#include <vector>
#include <string>
#include <fstream>

using namespace std;

struct Moves {

    string category;
    string type;
    string name;
    int power;
    int accuracy;
    int pp;
    int priority;
    string effect;

};

struct Pokemon {

    string name;
    string ability;
    vector<string> types;
    vector<Moves> moves;
    vector<string> weaknesses;
    vector<string> resistances;
    int hp;
    int atk;
    int def;
    int spAtk;
    int spDef;
    int speed;
};

class Player {

    private:

        vector<Pokemon> team;

    public:

        Player() {

            team = vector<Pokemon>();

        }

        Player(vector<Pokemon> group) {

            team = group;

        }

        vector<Pokemon> getTeam() {

            return team;
        }

        void setPokemon(Pokemon newPokemon, int index) {

            team[index] = newPokemon;
        }

        void switchPokemon(int index) {

            Pokemon temp = team[0];
            team[0] = team[index];
            team[index] = temp;

        }

        void faintedPokemon(int index) {

            team.erase(team.begin() + index); // Removes the fainted Pokemon from the team

        }

        int calculateDamage(Pokemon attacker, Pokemon defender, Moves move) {

            int newDamage;
            int effectiveness = 1;
            int stab = 1;
            
            for (int i = 0; i < attacker.types.size(); ++i) {

                if (move.type == attacker.types[i]) {

                    stab = 1.5;
                }

            }

            for (int i = 0; i < defender.weaknesses.size(); ++i) {

                if (move.type == defender.weaknesses[i]) {

                    effectiveness *= 2;
                }

            }

            for (int i = 0; i < defender.resistances.size(); ++i) {

                if (move.type == defender.resistances[i]) {

                    effectiveness *= 0.5;
                }

            }

            if (move.category == "physical") {

                newDamage = ((((((2 * 50)/5) + 2) * move.power * (attacker.atk / defender.def)) / 50) + 2) * effectiveness * stab;

            }

            else if (move.category == "special") {

                newDamage = ((((((2 * 50)/5) + 2) * move.power * (attacker.spAtk / defender.spDef)) / 50) + 2) * effectiveness * stab;
            
            }

            return newDamage;

        }
 
};

int main() {

    vector<Moves> moves(4);

    moves[0] = {"Special", "Fire", "Flamethrower", 90, 100, 15, 0, "Burns the target"};
    moves[1] = {"Physical", "Water", "Waterfall", 80, 100, 15, 0, "May cause flinching"};
    moves[2] = {"Special", "Electric", "Thunderbolt", 90, 100, 15, 0, "May cause paralysis"};
    moves[3] = {"Special", "Dark", "Dark Pulse", 80, 100, 15, 0, "May cause fiinching"};

    Pokemon Mewtwo = {"Mewtwo", "Pressure", {"Psychic"}, moves, {"Bug", "Ghost", "Dark"}, {"Fighting", "Psychic"}, 106, 110, 90, 154, 90, 130};

    vector<Pokemon> team1 = {Mewtwo};
    vector<Pokemon> team2 = {Mewtwo};

    Player player1(team1);
    Player player2(team2);

    cout << "Player 2 health: " << player2.getTeam()[0].hp << endl;

    int newDamage = player1.calculateDamage(player1.getTeam()[0], player2.getTeam()[0], player1.getTeam()[0].moves[3]);

    player2.getTeam()[0].hp = newDamage;
    
    cout << "Player 2 health updated: " << player2.getTeam()[0].hp << endl;


}