import java.util.Scanner;
import java.io.*;
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

class Moves {

    private String name;
    private String type;
    private int power;
    private int accuracy;
    private int pp;
    private String category;
    private String effect;
 
    public Moves() {
 
         this.name = "";
         this.type = "";
         this.power = 0;
         this.accuracy = 0;
         this.pp = 0;
         this.category = "";
         this.effect = "";
    }
 
    public Moves(String name, String type, int power, int accuracy, int pp, String category, String effect) {
 
         this.name = name;
         this.type = type;
         this.power = power;
         this.accuracy = accuracy;
         this.pp = pp;
         this.category = category;
         this.effect = effect;
    }
 
     public String getName() {
     
           return this.name;
     }
 
     public String getType() {
     
           return this.type;
     }
 
 
     public int getPower() {
     
           return this.power;
     }
 
     public int getAccuracy() {
     
           return this.accuracy;
     }
 
     public int getPP() {
     
           return this.pp;
     }
 
     public String getCategory() {
     
           return this.category;
     }
 
     public String getEffect() {
     
           return this.effect;
     }
 
     public void setName(String name) {
     
           this.name = name;
     }
 
     public void setType(String type) {
     
           this.type = type;
     }
 
     public void setPower(int power) {
     
           this.power = power;
     }
 
     public void setAccuracy(int accuracy) {
     
           this.accuracy = accuracy;
     }
 
     public void setPP(int pp) {
     
           this.pp = pp;
     }
 
     public void setCategory(String category) {
     
           this.category = category;
     }
 
     public void setEffect(String effect) {
     
           this.effect = effect;
     }
 
 }
 
 class Pokemon {
 
     private String name;
     private ArrayList<String> types;
     private ArrayList<Moves> moves;
     private HashMap<String, Integer> stats;
     private String ability;
     private ArrayList<String> weaknesses;
     private ArrayList<String> resistances;
     private ArrayList<String> immunities; // Optional: You can add immunities if needed
     private boolean fainted;
 
     public Pokemon() {
 
         this.name = "";
         this.types = new ArrayList<String>();
         this.moves = new ArrayList<Moves>();
         this.stats = new HashMap<String, Integer>();
         this.ability = "";
         this.immunities = new ArrayList<String>();
         this.weaknesses = new ArrayList<String>();
         this.resistances = new ArrayList<String>(); // Optional: Initialize immunities if needed
         fainted = false;
     }
 
     public Pokemon(String name, ArrayList<String> types, ArrayList<Moves> moves, HashMap<String, Integer> stats, String ability, ArrayList<String> weaknesses, ArrayList<String> resistances, ArrayList<String> immunities) {
 
         this.name = name;
         this.types = types;
         this.moves = moves;
         this.stats = stats;
         this.ability = ability;
         this.immunities = immunities; // Optional: You can add immunities if needed
         this.weaknesses = weaknesses;
         this.resistances = resistances; // Optional: Initialize resistances if needed
         fainted = false;

     }
 
     public String getName() {
     
           return this.name;
     }
 
     public ArrayList<String> getTypes() {
     
           return this.types;
     }
 
     public ArrayList<Moves> getMoves() {
     
           return this.moves;
     }
 
     public HashMap<String, Integer> getStats() {
     
           return this.stats;
     }
 
     public String getAbility() {
     
           return this.ability;
     }
 
     public ArrayList<String> getWeaknesses() {
     
           return this.weaknesses;
     }
 
     public ArrayList<String> getResistances() {
     
           return this.resistances;
     }

     public ArrayList<String> getImmunities() {
     
           return this.immunities; // Optional: You can add immunities if needed
     }

     public void setImmunities(ArrayList<String> immunities) {
     
           this.immunities = immunities; // Optional: You can add immunities if needed
     }
 
     public void setWeaknesses(ArrayList<String> weaknesses) {
     
           this.weaknesses = weaknesses;
     }
 
     public void setResistances(ArrayList<String> resistances) {
     
           this.resistances = resistances;
     }
 
 
     public void setName(String name) {
     
           this.name = name;
     }
 
     public void setTypes(ArrayList<String> types) {
     
           this.types = types;
     }
 
     public void setMoves(ArrayList<Moves> moves) {
     
           this.moves = moves;
     }
 
     public void setStats(HashMap<String, Integer> stats) {
     
           this.stats = stats;
     }
 
     public void setAbility(String ability) {
     
           this.ability = ability;
     }
 
     public int battle(Pokemon attacker, Pokemon defender, Moves move) {
 
         double stab = 1;;
         double effectiveness = 1;
         int i;
         int defenderHp = 0;;
        
        if (defender.getImmunities().contains(move.getType())) {
            // If the move's type is immune to the defender, return 0 damage
            return defender.getStats().get("hp"); // No damage if the move is immune
        }

         if (attacker.getTypes().contains(move.getType())) {
            
             stab = 1.5; // Same Type Attack Bonus (STAB)
         }
 
         for (i = 0; i < defender.getWeaknesses().size(); i++) {
 
             if (defender.getWeaknesses().get(i).equals(move.getType())) {
      
                 effectiveness *= 2.0; // Super effective against weaknesses

             }
         }
 
         for (i = 0; i < defender.getResistances().size(); i++) {
            
      
             if (defender.getResistances().get(i).equalsIgnoreCase(move.getType())) {
 
                 effectiveness *= 0.5; // Not very effective against resistances
             }
         } 
 
         if (move.getCategory().equalsIgnoreCase("physical")) {
             
             defenderHp =  (int) (((((2 * 100 * 1)/5 + 2) * move.getPower() * (attacker.getStats().get("attack") / defender.getStats().get("defense"))) / 50 + 2) * stab * effectiveness);
         }
 
         else if (move.getCategory().equalsIgnoreCase("special")) {
 
             defenderHp = (int) (((((2 * 100 * 1)/5 + 2) * move.getPower() * (attacker.getStats().get("spAtk") / defender.getStats().get("spDef"))) / 50 + 2) * stab * effectiveness);
         }
         
         return defender.getStats().get("hp") - defenderHp; // Return the calculated damage to be dealt to the defender's HP
     }

     public void setfainted() {

            fainted = true;
     }

     public boolean isFainted() {

            return fainted;
     }

     public void printPokemonInfo(Pokemon pokemon) {

      System.out.println("Name: " + pokemon.getName());
      System.out.println("Types: " + pokemon.getTypes().get(0) + ", " + pokemon.getTypes().get(1));
      System.out.println("Moves: " + pokemon.getMoves().get(0).getName() + ", " + pokemon.getMoves().get(1).getName() + ", " + pokemon.getMoves().get(2).getName() + ", " + pokemon.getMoves().get(3).getName());
      System.out.println("Stats: " + pokemon.getStats().get("hp") + ", " + pokemon.getStats().get("attack") + ", " + pokemon.getStats().get("defense") + ", " + pokemon.getStats().get("spAtk") + ", " + pokemon.getStats().get("spDef") + ", " + pokemon.getStats().get("speed"));
      System.out.println("Ability: " + pokemon.getAbility());

     }


}


public class PokemonMain {

    public static void main(String [] args) throws FileNotFoundException, IOException {

      BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\joshy\\OneDrive\\Desktop\\Coding projects\\pokemonPicker\\src\\PokemonData.txt")); // Create a BufferedReader to read the input file
      
      Moves move = new Moves(); // Create a new Moves object to store move details
      ArrayList<Moves> movesList = new ArrayList<Moves>(); // Create an ArrayList to store multiple Moves objects
      String moveName = "";
      String moveType = "";
      int movePower = 0;
      int moveAccuracy = 0;
      int movePP = 0;
      String moveCategory = "";
      String moveEffect = "";

      // All the move related details^

      String winner = ""; // Initialize winner variable
      Pokemon poke = new Pokemon();
      String pokeName = "";
      ArrayList<String> typesList = new ArrayList<String>(); // Create an ArrayList to store types of the Pokemon
      ArrayList<String> weaknessess = new ArrayList<String>(); // Create an ArrayList to store weaknesses of the Pokemon
      ArrayList<String> resistances = new ArrayList<String>(); // Create an ArrayList to store resistances of the Pokemon
      ArrayList<String> immunities = new ArrayList<String>(); // Create an ArrayList to store immunities of the Pokemon (optional)
      HashMap<String, Integer> statsMap = new HashMap<String, Integer>(); // Create a HashMap to store stats of the Pokemon
      int hp = 0; // Initialize HP variable
      int attack = 0; // Initialize attack variable
      int defense = 0;
      int spAtk = 0; // Initialize special attack variable
      int spDef = 0; // Initialize special defense variable
      int speed = 0;
      String ability = ""; // Initialize ability variable
      String pokeType = "";
      int i = 0;
      int j = 0;

      ArrayList<Pokemon> team1 = new ArrayList<Pokemon>(); // Create an ArrayList to store the first team of Pokemon
      ArrayList<Pokemon> team2 = new ArrayList<Pokemon>(); // Create an ArrayList to store the second team of Pokemon

      int rCount = 0;
      int wCount = 0; 
      String pokemonInfo = "";
      String moveLine = "";

      
      Scanner scnr = new Scanner(System.in);
      // All the Pokemon related details^

      while (reader.ready()) {

            for (i = 0; i < 12; ++i) {

                  pokemonInfo = reader.readLine();
                  scnr = new Scanner(pokemonInfo);

                  pokeName = scnr.next();
                  hp = scnr.nextInt();
                  attack = scnr.nextInt();
                  defense = scnr.nextInt();
                  spAtk = scnr.nextInt();
                  spDef = scnr.nextInt();
                  speed = scnr.nextInt();

                  statsMap.put("hp", hp); // Add the HP to the statsMap HashMap
                  statsMap.put("attack", attack); // Add the attack to the statsMap HashMap
                  statsMap.put("defense", defense); // Add the defense to the statsMap HashMap
                  statsMap.put("spAtk", spAtk); // Add the special attack to the statsMap HashMap
                  statsMap.put("spDef", spDef); // Add the special defense to the statsMap HashMap
                  statsMap.put("speed", speed); // Add the speed to the statsMap HashMap


                  for (j = 0; j < 2; ++j) {

                        pokeType = scnr.next();
                        typesList.add(pokeType); // Add the type to the typesList ArrayList
                  }

                  rCount = scnr.nextInt(); // Read the number of resistances

                  for (j = 0; j < rCount; ++j) {

                        pokeType = scnr.next();
                        resistances.add(pokeType); // Add the resistance to the resistances ArrayList
                  }

                  wCount = scnr.nextInt(); // Read the number of weaknesses

                  for (j = 0; j < wCount; ++j) {

                        pokeType = scnr.next();
                        weaknessess.add(pokeType); // Add the weakness to the weaknesses ArrayList
                  }     

                  for (j = 0; j < 4; ++j) {

                        moveLine = reader.readLine();
                        scnr = new Scanner(moveLine);
                        moveName = scnr.next();
                        moveType = scnr.next();
                        movePower = scnr.nextInt();
                        moveAccuracy = scnr.nextInt();
                        movePP = scnr.nextInt();
                        moveCategory = scnr.next();
                        moveEffect = scnr.next();

                        move = new Moves(moveName, moveType, movePower, moveAccuracy, movePP, moveCategory, moveEffect); // Create a new Moves object with the read details
                        movesList.add(move); // Add the move to the movesList ArrayList

                  }

                  poke = new Pokemon(pokeName, typesList, movesList, statsMap, ability, weaknessess, resistances, immunities);

                  if (i < 6) {
                        
                        team1.add(poke); // Add the Pokemon to team1 ArrayList)
                  }

                  else {

                        team2.add(poke); // Add the Pokemon to team2 ArrayList)
                        
                  }

                  weaknessess = new ArrayList<String>(); // Reset the weaknesses ArrayList for the next Pokemon
                  resistances = new ArrayList<String>(); // Reset the resistances ArrayList for the next Pokemon
                  movesList = new ArrayList<Moves>(); // Reset the movesList ArrayList for the next Pokemon
                  typesList = new ArrayList<String>(); // Reset the typesList ArrayList for the next Pokemon
                  statsMap = new HashMap<String, Integer>(); // Reset the statsMap HashMap for the next Pokemon
                  immunities = new ArrayList<String>(); // Reset the immunities ArrayList for the next Pokemon (optional)

                  reader.readLine(); // Read the empty line between Pokemon entries
            }    
      }

      reader.close(); // Close the BufferedReader
      scnr.close();

      System.out.println("Team 1:");
      for (i = 0; i < team1.size(); ++i) {

            System.out.println("Pokemon " + (i + 1) + ":");
            team1.get(i).printPokemonInfo(team1.get(i));  // Print the details of the Pokemon in team1

      }

      System.out.println("Team 2: ");

      for (i = 0; i < team2.size(); ++i) {

            System.out.println("Pokemon " + (i + 1) + ":");
            team1.get(i).printPokemonInfo(team1.get(i));  // Print the details of the Pokemon in team2

      }

      scnr = new Scanner(System.in);

      boolean gameOver = false;

      int firstOption = 0;
      int secondOption = 0;

      int moveOneOp = 0;
      int moveTwoOp = 0;

      int turn = 0;

      boolean SwitchOne = false;
      boolean SwitchTwo = false;

      int HP = 0;
      String answer1 = "";
      String answer2 = "";

      while (!gameOver) {
            
            for (i = 0; i < team1.size(); ++i) {

                  System.out.println("Pokemon " + (i + 1) + ": " + team1.get(i).getName());
      
            }
      
            System.out.println("Team 2: ");
      
            for (i = 0; i < team2.size(); ++i) {
      
                  System.out.println("Pokemon " + (i + 1) + ": " + team2.get(i).getName());
      
            }

            
            if (turn == 0) {

                  System.out.println("Player 1, Choose a pokemon to lead with (1 - 5)");
                  firstOption = scnr.nextInt(); // Read the first option from the user
                  firstOption -= 1;
                  System.out.println("Player 2, Choose a pokemon to lead with (1 - 5)");
                  secondOption = scnr.nextInt(); // Read the second option from the user
                  secondOption -= 1;
                  turn += 1;
            }

            else {

                  

                  if (answer1.equalsIgnoreCase("yes")) {

                        System.out.println("Choose a Pokemon to switch to (1 - 5)");
                        firstOption = scnr.nextInt(); // Read the first option from the user
                        SwitchOne = true;
                  }

                  else {

                        SwitchOne = false;
                  }

                  if (answer2.equalsIgnoreCase("yes")) {

                        System.out.println("Choose a Pokemon to switch to (1 - 5)");
                        secondOption = scnr.nextInt(); // Read the second option from the user
                        SwitchTwo = true;
                  }

                  else {

                        SwitchTwo = false;
                  }


            }
            
            System.out.println(team1.get(firstOption).getName());// Print the details of the Pokemon in team1
            System.out.println(team2.get(secondOption).getName());// Print the details of the Pokemon in team2

            System.out.println(team1.get(firstOption).getStats().get("hp") + " HP Left1");
            System.out.println(team2.get(secondOption).getStats().get("hp") + " HP Left2");

            if (!SwitchTwo) {


            System.out.println("Player 2, choose your move to use (1 - 4)");
            team1.get(secondOption).getMoves().get(0).getName(); // Print the details of the move in team1
            team1.get(secondOption).getMoves().get(1).getName(); // Print the details of the move in team1
            team1.get(secondOption).getMoves().get(2).getName(); // Print the details of the move in team1
            team1.get(secondOption).getMoves().get(3).getName(); // Print the details of the move in team1
                 
            moveTwoOp = scnr.nextInt(); // Read the first option from the user
            moveTwoOp -= 1; // Decrement the move option by 1 to match the index

            }

            if (!SwitchOne) {

                  System.out.println("Player 1, Choose a move to use (1 - 4)");
                  team1.get(firstOption).getMoves().get(0).getName(); // Print the details of the move in team1
                  team1.get(firstOption).getMoves().get(1).getName(); // Print the details of the move in team1
                  team1.get(firstOption).getMoves().get(2).getName(); // Print the details of the move in team1
                  team1.get(firstOption).getMoves().get(3).getName(); // Print the details of the move in team1
                 
                  moveOneOp = scnr.nextInt(); // Read the first option from the user
                  moveOneOp -= 1; // Decrement the move option by 1 to match the index


                  

            }

            if (team1.get(firstOption).getStats().get("speed") > team2.get(secondOption).getStats().get("speed"))  {

                  System.out.println("Player 2 poke HP: " + team2.get(secondOption).getStats().get("hp"));

                  if (team1.get(firstOption).isFainted()) {

                        System.out.println(team1.get(firstOption).getName() + " fainted! Pick another pokemon" ); // Print the details of the Pokemon in team1
                        firstOption = scnr.nextInt();
                        firstOption -= 1;

                  }
                  

                  else if (SwitchOne) {

                        System.out.println(team1.get(firstOption).getName() + " switched out ");
                        
                  }

                  else {

                      HP =  team1.get(firstOption).battle(team1.get(firstOption), team2.get(secondOption), team1.get(firstOption).getMoves().get(moveOneOp)); // Call the battle method to calculate damage
                        
                      team2.get(secondOption).getStats().replace("hp", HP);

                      System.out.println("Player 1 poke HP: " + team1.get(firstOption).getStats().get("hp"));

                  }

                  
                  if (team2.get(secondOption).isFainted()) {

                        System.out.println(team2.get(secondOption).getName() + " fainted! Pick another pokemon" ); // Print the details of the Pokemon in team1
                        secondOption = scnr.nextInt();
                        secondOption -= 1;

                  }

                  else {

                          HP =  team2.get(secondOption).battle(team2.get(secondOption), team1.get(firstOption), team2.get(secondOption).getMoves().get(moveTwoOp)); // Call the battle method to calculate damage
                              
                          team1.get(firstOption).getStats().replace("hp", HP);

                              System.out.println("Player 1 poke HP: " + team1.get(firstOption).getStats().get("hp"));
                  }
                  

            }

            else if (team2.get(secondOption).getStats().get("speed") > team1.get(firstOption).getStats().get("speed"))  {

                  System.out.println("Player 1 poke HP: " + team2.get(firstOption).getStats().get("hp"));

                  if (team2.get(secondOption).isFainted()) {

                        System.out.println(team1.get(firstOption).getName() + " fainted! Pick another pokemon" ); // Print the details of the Pokemon in team1
                        secondOption = scnr.nextInt();
                        secondOption -= 1;

                  }
                  

                  else if (SwitchTwo) {

                        System.out.println(team2.get(secondOption).getName() + " switched out ");
                        
                  }

                  else {

                      HP =  team2.get(secondOption).battle(team2.get(secondOption), team1.get(firstOption), team2.get(secondOption).getMoves().get(moveTwoOp)); // Call the battle method to calculate damage
                        
                      team1.get(firstOption).getStats().replace("hp", HP);

                        System.out.println("Player 1 poke HP: " + team1.get(firstOption).getStats().get("hp"));

                        
                  }

                  if (team1.get(firstOption).isFainted()) {

                        System.out.println(team1.get(firstOption).getName() + " fainted! Pick another pokemon" ); // Print the details of the Pokemon in team1
                        firstOption = scnr.nextInt();
                        firstOption -= 1;

                  }

                  else {

                          HP =  team1.get(firstOption).battle(team1.get(firstOption), team2.get(secondOption), team1.get(firstOption).getMoves().get(moveOneOp)); // Call the battle method to calculate damage
                              
                          team2.get(secondOption).getStats().replace("hp", HP);

                              System.out.println("Player 2 poke HP: " + team2.get(secondOption).getStats().get("hp"));
                  }


            }

            else {

                  Random random = new Random();

                  int ranNum = random.nextInt(2) + 1;

                  if (ranNum == 1) {
      
                              System.out.println("Player 1 poke HP: " + team2.get(firstOption).getStats().get("hp"));
      
                              if (team1.get(firstOption).isFainted()) {
      
                                    System.out.println(team1.get(firstOption).getName() + " fainted! Pick another pokemon" ); // Print the details of the Pokemon in team1
                                    firstOption = scnr.nextInt();
                                    firstOption -= 1;
      
                              }
                              
      
                              else if (SwitchOne) {
      
                                    System.out.println(team1.get(firstOption).getName() + " switched out ");
                                    
                              }
      
                              else {
      
                              HP =  team1.get(firstOption).battle(team1.get(firstOption), team2.get(secondOption), team1.get(firstOption).getMoves().get(moveOneOp)); // Call the battle method to calculate damage
                                    
                              team2.get(secondOption).getStats().replace("hp", HP);
      
                              System.out.println("Player 2 poke HP: " + team2.get(secondOption).getStats().get("hp"));
      
                              }
      
                              if (team2.get(secondOption).isFainted()) {
      
                                    System.out.println(team2.get(secondOption).getName() + " fainted! Pick another pokemon" ); // Print the details of the Pokemon in team1
                                    secondOption = scnr.nextInt();
                                    secondOption -= 1;
      
                              }
      
                              else {
      
                                    HP =  team2.get(secondOption).battle(team2.get(secondOption), team1.get(firstOption), team2.get(secondOption).getMoves().get(moveTwoOp)); // Call the battle method to calculate damage
                                    
                                    team1.get(firstOption).getStats().replace("hp", HP);

                                    System.out.println("Player 1 poke HP: " + team1.get(firstOption).getStats().get("hp"));
                              }
      
      
                        }
      
                        else if (ranNum == 2) {

                              System.out.println("Player 2 poke HP: " + team2.get(firstOption).getStats().get("hp"));
      
                              if (team2.get(secondOption).isFainted()) {
      
                                    System.out.println(team1.get(firstOption).getName() + " fainted! Pick another pokemon" ); // Print the details of the Pokemon in team1
                                    secondOption = scnr.nextInt();
                                    secondOption -= 1;
      
                              }
                              
      
                              else if (SwitchTwo) {
      
                                    System.out.println(team2.get(secondOption).getName() + " switched out ");
                                    
                              }
      
                              else {
      
                              HP =  team2.get(secondOption).battle(team2.get(secondOption), team1.get(firstOption), team2.get(secondOption).getMoves().get(moveTwoOp)); // Call the battle method to calculate damage
                                    
                              team1.get(firstOption).getStats().replace("hp", HP);
      
                              System.out.println("Player 1 poke HP: " + team1.get(firstOption).getStats().get("hp"));
      
                              }
      
                              if (team1.get(firstOption).isFainted()) {
      
                                    System.out.println(team1.get(firstOption).getName() + " fainted! Pick another pokemon" ); // Print the details of the Pokemon in team1
                                    firstOption = scnr.nextInt();
                                    firstOption -= 1;
      
                              }
      
                              else {
      
                                    HP =  team1.get(firstOption).battle(team1.get(firstOption), team2.get(secondOption), team1.get(firstOption).getMoves().get(moveOneOp)); // Call the battle method to calculate damage
                                    
                                    team2.get(secondOption).getStats().replace("hp", HP);

                                    System.out.println("Player 2 poke HP: " + team2.get(secondOption).getStats().get("hp"));
                              }
                              
                        }

                  }


            for (i = 0; i < team1.size(); i++) {
                  if (team1.get(i).isFainted()) {

                        gameOver = true;
                        winner = "Player 2 wins!"; // Set the winner to Player 2
                       
                  }

                  else {
                        
                        gameOver = false;
                       
                  }
            }

            for (i = 0; i < team2.size(); i++) {

                  if (team2.get(i).isFainted()) {

                        gameOver = true;
                        winner = "Player 1 wins!"; // Set the winner to Player 1
                  }

                  else {
                        
                        gameOver = false;
                        
                  }
            }

            System.out.println("Player 1, would you like to switch your Pokemon? (yes or no)" );
            answer1 = scnr.next(); // Read the answer from the user
            System.out.println("Player 2, would you like to switch your Pokemon? (yes or no)" );
            answer2 = scnr.next(); // Read the answer from the user


            }

                  
      }
}
