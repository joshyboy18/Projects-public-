package Java;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.util.HashMap;

class Player {


    private ArrayList<String> itemSet = new ArrayList<>(3);
    private String playerName;
    private int coins;
    private int stars;
    private boolean DK;
    private boolean Booster;
    private boolean ShyHide;
    private boolean CaptainToadCoin;
    private boolean BlankaBall;
    private boolean pitStop;
    private boolean boom;

    public Player() {

        for (int i = 0; i < 3; ++i) {

            itemSet.add(i, "nothing");
        }

        playerName = "Mario";
        coins = 20;
        stars = 0;
        DK = false;
        Booster = false;
        ShyHide = false;
        CaptainToadCoin = false;
        BlankaBall = false;
        pitStop = false;
        boom = false;
    }
    public Player(String name) {

        for (int i = 0; i < 3; ++i) {

            itemSet.add(i, "Cooper Cane");
        }
        playerName = name;
        coins = 20;
        stars = 0;
        DK = false;
        Booster = false;
        ShyHide = false;
        CaptainToadCoin = false;
        BlankaBall = false;
        pitStop = false;
        boom = false;
        
    }

    public boolean fullInventory() {

        for (int i = 0; i < itemSet.size(); ++i) {

            if (itemSet.get(i).equals("nothing")) {

                return false;
            }

        }

        return true;
    }

    public void setBoom(boolean impact) {

        boom = impact;
    }

    public void setDK(boolean impact) {

        DK = impact;
    }

    public void setBooster(boolean impact) {

        Booster = impact;
    }

    public void setShyHide(boolean impact) {

        ShyHide = impact;
    }

    public void setCptToad(boolean impact) {

        CaptainToadCoin = impact;
    }

    public void setBlankaBall(boolean impact) {

        BlankaBall = impact;
    }

    public boolean getDK() {

        return DK;

    }

    public boolean getBoom() {

        return boom;
    }

    public boolean getBooster() {

        return Booster;
    }

    public boolean getShyHide() {

        return ShyHide;
    }

    public boolean getCptToad() {

        return CaptainToadCoin;
    }

    public boolean getBlankaBall() {

        return BlankaBall;
    }

    public boolean getPitStop() {

        return pitStop;
    }

    public void setPitStop(boolean Stop) {

        pitStop = Stop;
        
    }

    public void setName(String player) {

        playerName = player;

    }

    public void useItem(int index) {

        itemSet.set(index, "nothing");
    }

    public void addItem(String itemToAdd) {

        itemSet.add(itemToAdd);

    } 

    public String getItem(int index) {

        return itemSet.get(index);
    }

    public void replaceItem(String itemToAdd, int placement) {

        itemSet.set(placement, itemToAdd);
    }

    public int getCoins() {

        return coins;
    }

    public void addCoins(int amount) {

        coins += amount;
    }

    public void takeCoins(int amount) {

        if (coins == 0 || coins < amount) {

            coins = 0;
        }
        
        else {

        coins -= amount;
        
        }
    }

    public  void giveStars(int amount) {
    
        stars += amount;
    }

    public void takeStars(int amount) {

        stars -= amount;
    }

    public int getStars() {

        return stars;
    }

    public String getPlayerName() {

        return playerName;
    }

    public ArrayList<String> getItems() {

        return itemSet;
    }

    public String toString() {

        return "" + playerName + "- coins: " + coins + " | stars: " + stars + " | items: " + itemSet + "";
    }

    public String getCharacter() {

        return playerName;
    }

    public Player winner(Player player1, Player player2) {

        Random ran = new Random();
        int num;

        if (player1.getStars() > player2.getStars()) {

            return player1;
        }

        else if (player1.getStars() == player2.getStars()) {

            if (player1.getCoins() > player2.getCoins()) {

                return player1;
            }
            
            else if (player1.getCoins() == player2.getCoins()) {

                num = ran.nextInt(1);

                if (num == 0) {

                return player1;
                }

                else {

                return player2;
                
                }
            }

            else if (player2.getCoins() > player1.getCoins()) {

            return player2;

            }

        }

        else if (player2.getStars() > player1.getStars()) {

            return player2;
        }

        return player1;
        
    }

    public void display() {

        System.out.println("" + playerName + "- coins: " + coins + " | stars: " + stars + " | items: " + itemSet + "");
    }

}


public class MarioParty2 {

    public static void main(String [] args) {
        Scanner scnr = new Scanner(System.in);
        Scanner stdin = new Scanner(System.in);

        Player p1;
        Player p2;
        Player p3;
        Player p4;
        String response = "";

        String peteTake = "";
        String word = "";
        String newItem = ""; 
        String answer = "";
        Random ran = new Random();

        int change = 0;
        int num = 0;
        int peteChoice;
        int fullSlots;
        int turnAmounts;

        ArrayList<Player> players = new ArrayList<>(4);

        System.out.println("Welcome to Mario Party 2! Get ready for loads of fun!");
        System.out.println();

        System.out.println("First, choose your characters!");

        for (int i = 0; i < 4; ++i) {
        
        System.out.println("Go player " + (i + 1));
        String character = scnr.nextLine();

        if (i == 0) {

            p1 = new Player(character);
            players.add(i, p1);
        }

        else if (i == 1) {

            p2 = new Player(character);
            players.add(i, p2);
        }

        else if (i == 2) {

            p3 = new Player(character);
            players.add(i, p3);
        }

        else {

            p4 = new Player(character);
            players.add(i, p4);
        }

    }

    System.out.println("Before we begin, how many turns do you want to have?");
    turnAmounts = scnr.nextInt();

    System.out.println("Alright, now that we have everyone nice and settled, lets see who were partying with!");
    System.out.println("--------------------------------------");

    for (int i = 0; i < 4; ++i) {

        System.out.println(players.get(i).toString());
        System.out.println();

    }


    System.out.println("Now Let's PAAAAARTYYY!!!!!");
    System.out.println("----------------------------------------");
    System.out.println();
    ListOFItems();

    for (int i = 0; i < turnAmounts; ++i) {

        System.out.println("Turn " + (i + 1) + " / " + turnAmounts);
        System.out.println();
        players.get(0).display();
        players.get(1).display();
        players.get(2).display();
        players.get(3).display();
        System.out.println();
        
        for (int j = 0; j < 4; ++j) {

            System.out.println("" + players.get(j).getCharacter() + ", what would you like to do?");
            System.out.println();

            players.get(j).display();
            answer = scnr.next();

            if (answer.equalsIgnoreCase("item")) {

                if (players.get(j).getItem(0).equalsIgnoreCase("nothing") && players.get(j).getItem(1).equalsIgnoreCase("nothing") && players.get(j).getItem(2).equalsIgnoreCase("nothing")) {

                    System.out.println("Oh no! looks like you do not have any items to use");
                    
                }

                else {

                    System.out.println("What item do you want to use?");
                    System.out.println("" + players.get(j).getItems());
                    int itemSlot = scnr.nextInt();
                    itemSlot = itemSlot - 1;

                    if (players.get(j).getItem(itemSlot).equalsIgnoreCase("Scrooge's blessing")) {

                        players.get(j).replaceItem("nothing", itemSlot); // remove item from inventory
                        System.out.println("Scrooge McDuck: Hey there old chap, I see you've called upon old Scrooge to give ya some quick cash. Well, here. Don't go wasting it all in one place now!");
                        players.get(j).addCoins(30);
                        
                        
                    }

                    else if (players.get(j).getItem(itemSlot).equalsIgnoreCase("DK BK")) {

                        players.get(j).replaceItem("nothing", itemSlot);
                        System.out.println("DK: OOOOOOOOO!!! OO OO (Hey there friend! Dk is here to protect you from that pesky bowser. King of the Koopas my butt!)");
                        System.out.println();
                        System.out.println("" + players.get(j).getCharacter() + ", you are now protected from bowser when you land on his space.");
                        players.get(j).setDK(true);
                        
                        
                    }

                    else if (players.get(j).getItem(itemSlot).equalsIgnoreCase("Cooper Cane")) {

                        System.out.println("Sly Cooper: Someone called? Legendary Sly Cooper is on the job. Now, just what player do I borrow from? (type in the number of the player you want to steal from)");
                        int steal = scnr.nextInt();

                        if (steal == 1) {

                            if (players.get(steal - 1).getShyHide()) {

                                System.out.println("Sorry " + players.get(2).getCharacter() + ", I have a jo- wait, where the heck are you? I can't see you! Oh well, I guess I'll just move on then");
                                players.get(steal-1).setShyHide(false);
        
                            }

                            else {

                            System.out.println("Sorry " + players.get(0).getCharacter() + ", I have a job to do.");

                            fullSlots = 0; 
                            for (int k = 0; k < players.get(0).getItems().size(); ++k) {

                                if (!(players.get(0).getItem(k).equalsIgnoreCase("nothing"))) {

                                    ++fullSlots;
                                }

                            }
                            int itemStole = ran.nextInt(fullSlots);

                            
                            newItem = players.get(0).getItem(itemStole);
                            players.get(0).replaceItem("nothing", itemStole);
                            players.get(j).replaceItem(newItem, itemSlot);
                                    
                            System.out.println("There ya go! A job perfectly done by yours truly");
                                    
                                   
                        }

                            
                    }

                    else if (steal == 2) {

                        if (players.get(steal - 1).getShyHide()) {

                            System.out.println("Sorry " + players.get(2).getCharacter() + ", I have a jo- wait, where the heck are you? I can't see you! Oh well, I guess I'll just move on then");
                            players.get(steal-1).setShyHide(false);
    
                        }

                        else {

                        System.out.println("Sorry " + players.get(1).getCharacter() + ", I have a job to do.");

                        fullSlots = 0;

                            for (int k = 0; k < players.get(1).getItems().size(); ++k) {

                                if (!(players.get(1).getItem(k).equalsIgnoreCase("nothing"))) {

                                    ++fullSlots;
                                }

                            }

                        int itemStole = ran.nextInt(fullSlots);

                        newItem = players.get(1).getItem(itemStole);
                        players.get(1).replaceItem("nothing", itemStole);

                        players.get(j).replaceItem(newItem, itemSlot);

                        System.out.println("There ya go! A job perfectly done by yours truly");
                               
                                
                           
                    }

                }


                else if (steal == 3) {

                    if (players.get(steal - 1).getShyHide()) {

                        System.out.println("Sorry " + players.get(2).getCharacter() + ", I have a jo- wait, where the heck are you? I can't see you! Oh well, I guess I'll just move on then");
                        players.get(steal-1).setShyHide(false);

                    }

                    else {

                    System.out.println("Sorry " + players.get(2).getCharacter() + ", I have a job to do.");

                    fullSlots = 0; 

                            for (int k = 0; k < players.get(2).getItems().size(); ++k) {

                                if (!(players.get(2).getItem(k).equalsIgnoreCase("nothing"))) {

                                    ++fullSlots;
                                }

                            }

                    int itemStole = ran.nextInt(fullSlots);
                    newItem = players.get(2).getItem(itemStole);
                    players.get(2).replaceItem("nothing", itemStole);
                    players.get(j).replaceItem(newItem, itemSlot);

                    System.out.println("There ya go! A job perfectly done by yours truly");
                            
                }

                    
            }

                else if (steal == 4) {
                    
                    if (players.get(steal - 1).getShyHide()) {

                        System.out.println("Sorry " + players.get(2).getCharacter() + ", I have a jo- wait, where the heck are you? I can't see you! Oh well, I guess I'll just move on then");
                        players.get(steal-1).setShyHide(false);

                    }
    
                    else {

                    System.out.println("Sorry " + players.get(3).getCharacter() + ", I have a job to do.");

                    fullSlots = 0; 
                            for (int k = 0; k < players.get(3).getItems().size(); ++k) {

                                if (!(players.get(3).getItem(k).equalsIgnoreCase("nothing"))) {

                                    ++fullSlots;
                                }

                            }

                    int itemStole = ran.nextInt(fullSlots);
                    newItem = players.get(3).getItem(itemStole);
                    players.get(3).replaceItem("nothing", itemStole);
                    players.get(j).replaceItem(newItem, itemSlot);

                    
                    System.out.println("There ya go! A job perfectly done by yours truly");
                            
                        
                    
                }
            }

        }

                else if (players.get(j).getItem(itemSlot).equalsIgnoreCase("Booster Pass")) {

                    System.out.println("BOOOOOOOSTERRIIIFIC!!! It's your favorite time traveling hero, Booster Gold!!!  I'll let you take another turn! ");
                    players.get(j).replaceItem("nothing", itemSlot);
                    players.get(j).setBooster(true);

                }

                else if (players.get(j).getItem(itemSlot).equalsIgnoreCase("Shy hide")) {

                    System.out.println("Shy Guy: oh...hi, my name is shy guy, and you're welcome to hide here with me for a bit. I'll protect you from other items/effects...except for bowser. He's a big guy, I can't do much about him");
                    players.get(j).replaceItem("nothing", itemSlot);
                    players.get(j).setShyHide(true);

                }

                else if (players.get(j).getItem(itemSlot).equalsIgnoreCase("Captain Toad Coin")) {

                    System.out.println("Captain Toad: Oh, hello there! I see you've found my coin! Well, I'll give you a discount! Star is gonna be only 10 coins!");
                    players.get(j).replaceItem("nothing", itemSlot);
                    players.get(j).setCptToad(true);
                }

                else if (players.get(j).getItem(itemSlot).equalsIgnoreCase("Petey Pounce")) {

                    players.get(j).replaceItem("nothing", itemSlot);
                    System.out.println("Petey Piranha: RAWWWWW! rar rar (I petey and I here to steal coins or star from player! What you want me to steal? coins - free | star - 40 coins)");
                    peteTake = scnr.next();

                    if (peteTake.equalsIgnoreCase("coins")) {

                        System.out.println("OK, I take coins from player? What player do I take from? (type the player number you want to take from)");
                        players.get(0).display();
                        players.get(1).display();
                        players.get(2).display();
                        players.get(3).display();

                        peteChoice = scnr.nextInt();
                        boolean taken = false;
                        int coinsTaken;
                        
                        coinsTaken = ran.nextInt(2);
                        while (!taken) {
                            

                            if (players.get(peteChoice - 1).getShyHide()) {

                                System.out.println("I can't take from that player, they are hiding! Pick another!");
                                players.get(peteChoice - 1).setShyHide(false);
                            }

                            else if (players.get(peteChoice - 1).getCoins() == 0) {

                                System.out.println("I can't take from that player, they have no coins! Pick another!");
                                peteChoice = scnr.nextInt();
                            }

                            else {

                                
                                taken = true;
                                System.out.println("OK, I take coins from " + players.get(peteChoice - 1).getCharacter());
                                
                                switch(coinsTaken) {

                                    case 0:

                                        players.get(peteChoice - 1).takeCoins(10);
                                        players.get(j).addCoins(10);
                                        break;

                                    case 1:

                                        players.get(peteChoice - 1).takeCoins(15);
                                        players.get(j).addCoins(15);
                                        break;

                                    case 2:

                                        players.get(peteChoice - 1).takeCoins(20);
                                        players.get(j).addCoins(20);
                                        break;

                                    default:

                                        players.get(peteChoice - 1).takeCoins(20);
                                        players.get(j).addCoins(20);
                                        break;
                                }
                            }
                        }
                        
                    }

                    else if (peteTake.equalsIgnoreCase("Star")) {

                        System.out.println("OK, I take stars from player? If  What player do I take from? (type the player number you want to take from)");
                        players.get(0).display();
                        players.get(1).display();
                        players.get(2).display();
                        players.get(3).display();
                        
                        peteChoice = scnr.nextInt();
                        boolean taken = false;

                        if (players.get(j).getCoins() < 40) {

                            System.out.println("Oh no! you don't have enough coins! Sorry, you cannot buy that");
                        }

                        else {
                        
                        while (!taken) {

                            if (players.get(peteChoice - 1).getShyHide()) {

                                System.out.println("I can't take from that player, they are hiding! Pick another!");
                                players.get(peteChoice - 1).setShyHide(false);
                            }

                            else if (players.get(peteChoice - 1).getStars() == 0) {

                                System.out.println("I can't take from that player, they have no stars! Pick another!");
                                peteChoice = scnr.nextInt();
                            }

                            else {

                                players.get(change).setShyHide(false);
                                taken = true;
                                System.out.println("OK, I take star from " + players.get(peteChoice - 1).getCharacter());
                                players.get(peteChoice - 1).takeStars(1);
                                players.get(j).giveStars(1);
                                players.get(j).takeCoins(40);
                            }

                        }

                    }
                }
            }

                else if (players.get(j).getItem(itemSlot).equalsIgnoreCase("Pit Stop")) {

                    players.get(j).setPitStop(true);
                    players.get(j).replaceItem("nothing", itemSlot);
                    
                }

                else if (players.get(j).getItem(itemSlot).equalsIgnoreCase("Blanka Ball")) {

                    System.out.println("Blanka: It me, blanka! I ready to shock a player to stop them! Who I shock??");
                    int playerInfo = scnr.nextInt();
                    players.get(j).replaceItem("nothing", itemSlot);
                    
                    if (players.get(playerInfo - 1).getShyHide()) {

                        System.out.println("RAAAW! ea- ooh? Where " + players.get(playerInfo - 1) + " at? Well, time go home" );
                        players.get(playerInfo - 1).setShyHide(false);
                        
                    }

                    else {
                    switch (playerInfo) {

                        case 1:

                            System.out.println("RAAAAW! eat lightning " + players.get(playerInfo - 1).getCharacter() + "! ");
                            players.get(playerInfo - 1).setBlankaBall(true);

                            break;
                        
                        case 2:

                            System.out.println("RAAAAW! eat lightning " + players.get(playerInfo - 1).getCharacter() + "! ");
                            players.get(playerInfo - 1).setBlankaBall(true);

                            break;
                        
                        case 3:

                            System.out.println("RAAAAW! eat lightning " + players.get(playerInfo - 1).getCharacter() + "! ");
                            players.get(playerInfo - 1).setBlankaBall(true);

                            break;

                        case 4:
                            
                            System.out.println("RAAAAW! eat lightning " + players.get(playerInfo - 1).getCharacter() + "! ");
                            players.get(playerInfo - 1).setBlankaBall(true);

                            break;
                        
                        default:

                            System.out.println("What? no shock???? oh...ok");
                            break;       
                    }   

                }

                }
            }
            
            answer = "";
        }
                   
                System.out.println("Alright, lets roll");
                
                if (players.get(j).getBlankaBall()) {

                    System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ, you've been blanka balled!!! You cannot move");
                    players.get(j).setBlankaBall(false);
                    num = 111;

                }

                else if (players.get(j).getPitStop()) {

                    System.out.println("Hey, Lady Palutena said that you needed help! which space do you want to go to? (blue, bowser, red, lucky, event, star, item, shop)");
                    String space = scnr.next();
                    players.get(j).setPitStop(false);

                    switch (space) {
                        
                        case "blue": 
                        
                            num = 15;   
                            break;

                        case "red":

                            num = 17;
                            break;

                        case "lucky":

                            num = 25;
                            break;
                        
                        case "shop":

                            num = 50;
                            break;
                        
                        case "bowser":

                            num = 57;
                            break;
                        
                        case "star":

                            num = 65;
                            break;
                        
                        case "event":

                            num = 77;
                            break;
                        
                        case "item":

                            num = 90;
                            break;

                        default:

                            System.out.println("Huh...well, if you don't wanna go to a space at all ig");
                            break;
                            
                    
                    }

                }

                else {

                    num = ran.nextInt(100);
                }
                  
                if (num <= 15) {

                    System.out.println("You got three coins!");
                    players.get(j).addCoins(3);
                }

                else if (num > 15 && num <= 20) {

                    System.out.println("Aww, you just lost 3 coins");
                    players.get(j).takeCoins(3);
                }

                else if (num > 20  && num <= 40) {

                    System.out.println("Hey, you got a lucky space! let's see what you can get");
                    num = ran.nextInt(4);

                        if (num == 0) {

                            System.out.println("You just got 5 coins");
                            players.get(j).addCoins(5);
                        }

                        else if (num == 1) {

                            System.out.println("You just got 10 coins");
                            players.get(j).addCoins(10);
                        }

                        else if (num == 2) {

                            System.out.println("You just got 15 coins");
                            players.get(j).addCoins(15);

                        }

                        else if (num == 3) {

                            System.out.println("You just got 20 coins");
                            players.get(j).addCoins(20);
                        }

                        else if (num == 4) {

                            num = ran.nextInt(8);

                            if (num == 0) {

                                System.out.println("You just got a Scrooge's blessing!");
                                
                                if (players.get(j).getItems().get(0).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Scrooge's blessing", 0);
                                    System.out.println("Your item was added");
                                }

                                else if (players.get(j).getItems().get(1).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Scrooge's blessing", 1);
                                    System.out.println("Your item was added");
                                }

                                else if (players.get(j).getItems().get(2).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Scrooge's blessing", 2);
                                    System.out.println("Your item was added");
                                }

                                else {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace and item?");

                                    response = scnr.next();
                                    

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Scrooge's blessing", replace);
                                    }

                                    else {

                                        System.out.println("Ok, well we will just continue on!");
                                    }
                                }

                            }

                            if (num == 1) {

                                System.out.println("You just got a Booster Pass!");
                                
                                if (players.get(j).getItems().get(0).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Booster Pass", 0);
                                    System.out.println("Your item was added");

                                }

                                else if (players.get(j).getItems().get(1).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Booster Pass", 1);
                                    System.out.println("Your item was added");
                                }

                                else if (players.get(j).getItems().get(2).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Booster Pass", 2);
                                    System.out.println("Your item was added");
                                }

                                else {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace and item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Booster Pass", replace);
                                    }

                                    else {

                                        System.out.println("Ok, well we will just continue on!");
                                    }
                                }
                            }
                            
                            if (num == 2) {

                                System.out.println("You just got a DK BK!");
                                
                                if (players.get(j).getItems().get(0).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("DK BK", 0);
                                    System.out.println("Your item was added");

                                }

                                else if (players.get(j).getItems().get(1).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("DK BK", 1);
                                    System.out.println("Your item was added");
                                }

                                else if (players.get(j).getItems().get(2).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("DK BK", 2);
                                    System.out.println("Your item was added");
                                }

                                else {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace and item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("DK BK", replace);
                                    }

                                    else {

                                        System.out.println("Ok, well we will just continue on!");
                                    }
                                }
                            }

                            if (num == 3) {

                                System.out.println("You just got a Cooper Cane!");
                                
                                if (players.get(j).getItems().get(0).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Cooper Cane", 0);
                                    System.out.println("Your item was added");

                                }

                                else if (players.get(j).getItems().get(1).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Cooper Cane", 1);
                                    System.out.println("Your item was added");
                                }

                                else if (players.get(j).getItems().get(2).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Cooper Cane", 2);
                                    System.out.println("Your item was added");
                                }

                                else {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace and item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Cooper Cane", replace);
                                    }

                                    else {

                                        System.out.println("Ok, well we will just continue on!");
                                    }
                                }
                            }

                            if (num == 4) {

                                System.out.println("You just got a Pit Stop!");
                                
                                if (players.get(j).getItems().get(0).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Pit Stop", 0);
                                    System.out.println("Your item was added");

                                }

                                else if (players.get(j).getItems().get(1).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Pit Stop", 1);
                                    System.out.println("Your item was added");
                                }

                                else if (players.get(j).getItems().get(2).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Pit Stop", 2);
                                    System.out.println("Your item was added");
                                }

                                else {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace and item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Pit Stop", replace);
                                    }

                                    else {

                                        System.out.println("Ok, well we will just continue on!");
                                    }
                                }
                            }

                            if (num == 5) {

                                System.out.println("You just got a Blanka Ball!");
                                
                                if (players.get(j).getItems().get(0).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Blanka Ball", 0);
                                    System.out.println("Your item was added");

                                }

                                else if (players.get(j).getItems().get(1).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Blanka Ball", 1);
                                    System.out.println("Your item was added");
                                }

                                else if (players.get(j).getItems().get(2).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Blanka Ball", 2);
                                    System.out.println("Your item was added");
                                }

                                else {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace and item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Blanka Ball", replace);
                                    }

                                    else {

                                        System.out.println("Ok, well we will just continue on!");
                                    }
                                }
                            }

                            if (num == 6) {

                                System.out.println("You just got a Captain Toad Coin!");
                                
                                if (players.get(j).getItems().get(0).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Captain Toad Coin", 0);
                                    System.out.println("Your item was added");

                                }

                                else if (players.get(j).getItems().get(1).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Captain Toad Coin", 1);
                                    System.out.println("Your item was added");
                                }

                                else if (players.get(j).getItems().get(2).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Captain Toad Coin", 2);
                                    System.out.println("Your item was added");
                                }

                                else {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace and item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Captain Toad Coin", replace);
                                    }

                                    else {

                                        System.out.println("Ok, well we will just continue on!");
                                    }
                                }
                            }

                            if (num == 7) {

                                System.out.println("You just got a Shy hide!");
                                
                                if (players.get(j).getItems().get(0).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Shy hide", 0);
                                    System.out.println("Your item was added");

                                }

                                else if (players.get(j).getItems().get(1).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Shy hide", 1);
                                    System.out.println("Your item was added");
                                }

                                else if (players.get(j).getItems().get(2).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Shy hide", 2);
                                    System.out.println("Your item was added");
                                }

                                else {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace and item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Shy hide", replace);
                                    }

                                    else {

                                        System.out.println("Ok, well we will just continue on!");
                                    }
                                }
                            }

                            if (num == 8) {

                                System.out.println("You just got a Shy hide!");
                                
                                if (players.get(j).getItems().get(0).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Shy hide", 0);
                                    System.out.println("Your item was added");

                                }

                                else if (players.get(j).getItems().get(1).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Shy hide", 1);
                                    System.out.println("Your item was added");
                                }

                                else if (players.get(j).getItems().get(2).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Shy hide", 2);
                                    System.out.println("Your item was added");
                                }

                                else {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace and item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Shy hide", replace);
                                    }

                                    else {

                                        System.out.println("Ok, well we will just continue on!");
                                    }

                            }
                        } 

                    }  
                }
                        else if (num > 40 &&  num <= 55) {


                            System.out.println("Wiggler: Hi, welcome to my item shop, what do you wanna buy?");

                            
                            System.out.println("-------------------------------------------------------");
                            ListOFItems();

                            word = stdin.nextLine();

                            if (word.equalsIgnoreCase("Scrooge's blessing")) {

                                if (players.get(j).getCoins() < 8) {

                                    System.out.println("Oh no! you don't have enough coins! Sorry, you cannot buy that");

                                }

                                else {


                                System.out.println("Ok, here is your Scrooge's blessing (-8 coins)");

                                if (players.get(j).getItems().get(0).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Scrooge's blessing", 0);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(8);

                                }

                                else if (players.get(j).getItems().get(1).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Scrooge's blessing", 1);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(8);
                                }

                                else if (players.get(j).getItems().get(2).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Scrooge's blessing", 2);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(8);
                                }

                                else {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace an item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Scrooge's blessing", replace);
                                        players.get(j).takeCoins(8);
                                    }

                                    else {

                                        System.out.println("Oh, ok, we will just continue the game. BYE!");

                                    }

                                }
                            }
                        }

                        else if (word.equalsIgnoreCase("Petey Pounce")) {

                            if (players.get(j).getCoins() < 15) {

                                System.out.println("Oh no! you don't have enough coins! Sorry, you cannot buy that");
                            }

                            else {

                                System.out.println("Ok, here is your Petey Pounce (-15 coins)");
                                players.get(j).takeCoins(15);

                                for (int w = 0; i < players.get(j).getItems().size(); ++w) {

                                    if (players.get(j).getItem(w).equalsIgnoreCase("nothing")) {

                                        players.get(j).replaceItem("Petey Pounce", w);
                                        System.out.println("Your item was added");
                                        break;
                                    }

                                    else if (players.get(j).fullInventory()) {

                                        System.out.println("Oh, looks like your inventory is full, do you want to replace an item?");

                                        response = scnr.next();

                                        if (response.equalsIgnoreCase("yes")) {

                                            System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                            System.out.println(players.get(j).getItems());

                                            int replace = scnr.nextInt();
                                            replace = replace - 1;
                                            players.get(j).replaceItem("Petey Pounce", replace);
                                            break;
                                        }

                                        else {

                                            System.out.println("Oh, ok, we will just continue the game. BYE!");
                                            break;

                                        }

                                    }
                                }
                            }
                        }
                            else if (word.equalsIgnoreCase("DK BK")) {

                                if (players.get(j).getCoins() < 6) {

                                    System.out.println("Oh no! you don't have enough coins! Sorry, you cannot buy that");
                                }

                                else {
                                System.out.println("Ok, here is your DK BK (-6 coins)");


                                
                                if (players.get(j).getItems().get(0).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("DK BK", 0);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(6);

                                }

                                else if (players.get(j).getItems().get(1).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("DK BK", 1);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(6);
                                }

                                else if (players.get(j).getItems().get(2).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("DK BK", 2);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(6);
                                }

                                else {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace an item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("DK BK", replace);
                                        players.get(j).takeCoins(6);
                                    }

                                    else {

                                        System.out.println("Oh, ok, we will just continue the game. BYE!");

                                    }

                                }
                            }
                        }

                            else if (word.equalsIgnoreCase("Booster Pass")) {

                                if (players.get(j).getCoins() < 12) {

                                    System.out.println("Oh no! you don't have enough coins! Sorry, you cannot buy that");
                                }

                                else {
                                System.out.println("Ok, here is your Booster Pass (-12 coins)");

                                if (players.get(j).getItems().get(0).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Booster Pass", 0);
                                    System.out.println("Your item was added");
                                

                                }

                                else if (players.get(j).getItems().get(1).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Booster Pass", 1);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(12);
                                }

                                else if (players.get(j).getItems().get(2).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Booster Pass", 2);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(12);
                                }

                                else {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace an item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Booster Pass", replace);
                                        players.get(j).takeCoins(12);
                                    }

                                    else {

                                        System.out.println("Oh, ok, we will just continue the game. BYE!");

                                    }

                                }
                            }
                        }

                            else if (word.equalsIgnoreCase("Cooper Cane")) {

                                if (players.get(j).getCoins() < 10) {

                                    System.out.println("Oh no! you don't have enough coins! Sorry, you cannot buy that");
                                }
                                
                                else {
                                System.out.println("Ok, here is your Cooper Cane (-10 coins)");
                                

                                if (players.get(j).getItems().get(0).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Cooper Cane", 0);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(10);

                                }

                                else if (players.get(j).getItems().get(1).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Cooper Cane", 1);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(10);
                                }

                                else if (players.get(j).getItems().get(2).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Cooper Cane", 2);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(10);
                                }

                                else {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace an item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Cooper Cane", replace);
                                        players.get(j).takeCoins(10);
                                    }

                                    else {

                                        System.out.println("Oh, ok, we will just continue the game. BYE!");

                                    }

                                }
                            }
                        }

                            else if (word.equalsIgnoreCase("Pit Stop")) {

                                if (players.get(j).getCoins() < 20) {

                                    System.out.println("Oh no! you don't have enough coins! Sorry, you cannot buy that");
                                }

                                else {

                                System.out.println("Ok, here is your Pit Stop (-20 coins)");

                                if (players.get(j).getItems().get(0).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Pit Stop", 0);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(20);

                                }

                                else if (players.get(j).getItems().get(1).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Pit Stop", 1);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(20);
                                }

                                else if (players.get(j).getItems().get(2).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Pit Stop", 2);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(20);
                                }

                                else {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace an item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Pit Stop", replace);
                                        players.get(j).takeCoins(20);
                                    }

                                    else {

                                        System.out.println("Oh, ok, we will just continue the game. BYE!");

                                    }

                                }
                            }
                        }

                            else if (word.equalsIgnoreCase("Blanka Ball")) {

                                if (players.get(j).getCoins() < 5) {

                                    System.out.println("Oh no! you don't have enough coins! Sorry, you cannot buy that");
                                }

                                else {
                                System.out.println("Ok, here is your Blanka Ball (-5 coins)");

                                if (players.get(j).getItems().get(0).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Blanka Ball", 0);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(5);

                                }

                                else if (players.get(j).getItems().get(1).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Blanka Ball", 1);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(5);
                                }

                                else if (players.get(j).getItems().get(2).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Blanka Ball", 2);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(5);
                                }

                                else {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace an item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Blanka Ball", replace);
                                        players.get(j).takeCoins(5);
                                    }  

                                    else {

                                        System.out.println("Oh, ok, we will just continue the game. BYE!");

                                    }

                                }
                            }
                        }

                            else if (word.equalsIgnoreCase("Captain Toad Coin")) {

                                if (players.get(j).getCoins() < 12) {

                                    System.out.println("Oh no! you don't have enough coins! Sorry, you cannot buy that");
                                }

                                else {
                                System.out.println("Ok, here is your Captain Toad Coin (-12 coins)");
                                

                                if (players.get(j).getItems().get(0).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Captain Toad Coin", 0);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(12);

                                }

                                else if (players.get(j).getItems().get(1).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Captain Toad Coin", 1);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(12);
                                }

                                else if (players.get(j).getItems().get(2).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Captain Toad Coin", 2);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(12);
                                }

                                else {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace an item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Captain Toad Coin", replace);
                                        players.get(j).takeCoins(12);
                                    }

                                    else {

                                        System.out.println("Oh, ok, we will just continue the game. BYE!");

                                    }

                                }
                            }
                        }

                        else if (word.equalsIgnoreCase("Shy Hide")) {

                                if (players.get(j).getCoins() < 8) {

                                    System.out.println("Oh no! you don't have enough coins! Sorry, you cannot buy that");
                                }

                                else {
                                System.out.println("Ok, here is your Shy hide (-8 coins)");
                                

                                if (players.get(j).getItems().get(0).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Shy Hide", 0);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(8);

                                }

                                else if (players.get(j).getItems().get(1).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Shy Hide", 1);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(8);
                                }

                                else if (players.get(j).getItems().get(2).equalsIgnoreCase("nothing")) {

                                    players.get(j).replaceItem("Shy Hide", 2);
                                    System.out.println("Your item was added");
                                    players.get(j).takeCoins(8);
                                }

                                else {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace an item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Shy Hide", replace);
                                        players.get(j).takeCoins(8);
                                    }

                                    else {

                                        System.out.println("Oh, ok, we will just continue the game. BYE!");

                                    }

                                }

                            }
                        }

                        else {

                            System.out.println("Alright, well come back soon!");
                        }

                        
                    }
                    
                    else if (num >55 && num <= 60) {

                    System.out.println("MWHAHAHAHAHAHA! Welcome to Bowser's space! You know what that means! Time to pay up!");

                    int bowserEvent = ran.nextInt(10);

                    if (players.get(j).getDK()) {

                        System.out.println("Bowser: DK?????? w-what's up man? w-why don't you just take a free pass this time? In fact, here is 10 coins!!!!");
                        players.get(j).addCoins(10);
                        players.get(j).setDK(false);

                    }

                    else if (bowserEvent >= 0 && bowserEvent <= 3) {

                        System.out.println("Bowser: You just lost 5 coins!");
                        players.get(j).takeCoins(5);
                    }

                    else if (bowserEvent >= 4 && bowserEvent <= 6) {

                        System.out.println("Bowser: You just lost 10 coins!");
                        players.get(j).takeCoins(10);
                    }

                    else if (bowserEvent >= 7 && bowserEvent <= 8) {

                        System.out.println("Bowser: You just lost 15 coins!");
                        players.get(j).takeCoins(15);
                    }

                    else if (bowserEvent == 9) {

                        System.out.println("Bowser: You just lost 20 coins!");
                        players.get(j).takeCoins(20);
                    }

                    else {

                        System.out.println("Bowser: LOOK AT THAT! You lost a STAR!");
                        players.get(j).takeStars(1);
                    }
                }

                else if (num > 60 && num <= 70) {

                    String starChoice;
                    System.out.println("Toadette: Wow! You made it to the star! Do you want one?");
                    starChoice = scnr.next();

                    if (starChoice.equalsIgnoreCase("yes")) {

                        if (players.get(j).getCptToad() && players.get(j).getCoins() >= 10) {

                            System.out.println("Toadette: Oh, Captain Toad Coin! Well, here is your star! (-10 coins)");
                            players.get(j).takeCoins(10);
                            players.get(j).giveStars(1);
                            players.get(j).setCptToad(false);
        

                        }

                        else if (players.get(j).getCoins() >= 20 && !players.get(j).getCptToad()) {

                            System.out.println("Alright! Here is your star (-20 coins)");
                            players.get(j).takeCoins(20);
                            players.get(j).giveStars(1);
                        }

                        else {

                            System.out.println("Oh, looks like you don't have enough coins!");
                        }
                        

                    }

                    else if (word.equalsIgnoreCase("Nothing")) {

                        System.out.println("Alright, well come back soon!");
                    }
                }

                else if (num > 70  && num <= 85) {

                    System.out.println("Oh, an EVENT SPACE! Let's see what you get!");

                    int event = ran.nextInt(3);
                    int coinFlip = ran.nextInt(2);
                    switch (event) {

                        case 0:
                            System.out.println("I'm the master of chance! Heads or tails?");
                            String choice = scnr.next();
                            String chance;

                            if (coinFlip == 0) {

                                chance = "heads";
                            }

                            else {

                                chance = "tails";
                            }

                            if (choice.equalsIgnoreCase(chance)) {

                                System.out.println("Dang...alright, here's 25 coins");
                                players.get(j).addCoins(25);
                            }

                            else {

                                System.out.println("HAHAHAHA, You lose!!!!");
                            }

                            break;
                        

                    case 1:

                        int block = ran.nextInt(50);

                        if (block >= 0 && block < 46) {

                        System.out.println("You found a hidden block! You get 20 coins!");
                        players.get(j).addCoins(20);

                        }

                        else {

                            System.out.println("HOLY COW!!! You found a STAR!!!!");
                            players.get(j).giveStars(1);
                        }

                        break;

                    case 2:
                        
                        System.out.println("OOOO, you got a nice item! want me to take it off your hands?");
                        String an = scnr.next();

                        if (an.equalsIgnoreCase("yes")) {

                            for (int k = 0; k < players.get(j).getItems().size(); ++k) {
                                if (!(players.get(j).getItem(k).equalsIgnoreCase("nothing"))) {

                                System.out.println("Alright! thanks for the item! Here are 30 coins for your troubles!");
                                players.get(j).addCoins(30);
                                players.get(j).replaceItem("nothing", k);
                                break;

                                }
                            }

                        
                        }
                            
                        else {

                            System.out.println("Alright, well come back soon!");
                        }

                        break;

                    default:

                        System.out.println("Oh, looks like nothing happened! Heres's 5 coins for the trouble!");
                        break;
                    }
                    
                }

                else if (num > 85 && num <= 100) {

                    System.out.println("You found orbulon! He gives you a random item!");

                            num = ran.nextInt(8);

                            if (num == 0) {

                                System.out.println("You got a Scrooge's blessing!");
                                
                                if (players.get(j).fullInventory()) {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace an item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Scrooge's blessing", replace);
                                    }

                                    else {

                                        System.out.println("Ok, well we will just continue on!");
                                    }
                                }

                                else {

                                    for (int k = 0; k < players.get(j).getItems().size(); ++k) {

                                        if (players.get(j).getItem(k).equalsIgnoreCase("nothing")) {

                                            players.get(j).replaceItem("Scrooge's blessing", k);
                                            System.out.println("Your item was added");
                                            break; // this is to break the loop once the item is added
                                        }
                                    }
                                }


                            }

                            else if (num == 1) {

                                System.out.println("You got a Booster Pass!");
                                
                                if (players.get(j).fullInventory()) {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace an item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Booster Pass", replace);
                                    }

                                    else {

                                        System.out.println("Ok, well we will just continue on!");
                                    }
                                }

                                else {

                                    for (int k = 0; k < players.get(j).getItems().size(); ++k) {

                                        if (players.get(j).getItem(k).equalsIgnoreCase("nothing")) {

                                            players.get(j).replaceItem("Booster Pass", k);
                                            System.out.println("Your item was added");
                                            break; // this is to break the loop once the item is added
                                        }
                                    }
                                }
                            }

                            else if (num == 2) {

                                System.out.println("You got a DK BK!");
                                
                                if (players.get(j).fullInventory()) {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace an item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("DK BK", replace);
                                    }

                                    else {

                                        System.out.println("Ok, well we will just continue on!");
                                    }
                                }

                                else {

                                    for (int k = 0; k < players.get(j).getItems().size(); ++k) {

                                        if (players.get(j).getItem(k).equalsIgnoreCase("nothing")) {

                                            players.get(j).replaceItem("DK BK", k);
                                            System.out.println("Your item was added");
                                            break; // this is to break the loop once the item is added
                                        }
                                    }
                                }
                            }

                            else if (num == 3) {

                                System.out.println("You got a Cooper Cane!");
                                
                                if (players.get(j).fullInventory()) {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace an item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Cooper Cane", replace);
                                    }

                                    else {

                                        System.out.println("Ok, well we will just continue on!");
                                    }
                                }

                                else {

                                    for (int k = 0; k < players.get(j).getItems().size(); ++k) {

                                        if (players.get(j).getItem(k).equalsIgnoreCase("nothing")) {

                                            players.get(j).replaceItem("Cooper Cane", k);
                                            System.out.println("Your item was added");
                                            break; // this is to break the loop once the item is added
                                        }
                                    }
                                }
                            }

                            else if (num == 4) {

                                System.out.println("You got a Pit Stop!");
                                
                                if (players.get(j).fullInventory()) {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace an item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Pit Stop", replace);
                                    }

                                    else {

                                        System.out.println("Ok, well we will just continue on!");
                                    }
                                }

                                else {

                                    for (int k = 0; k < players.get(j).getItems().size(); ++k) {

                                        if (players.get(j).getItem(k).equalsIgnoreCase("nothing")) {

                                            players.get(j).replaceItem("Pit Stop", k);
                                            System.out.println("Your item was added");
                                            break; // this is to break the loop once the item is added
                                        }
                                    }
                                }
                            }

                            else if (num == 5) {

                                System.out.println("You got a Cooper Cane!");
                                
                                if (players.get(j).fullInventory()) {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace an item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;

                                        players.get(j).replaceItem("Cooper Cane", replace);
                                    }

                                    else {

                                        System.out.println("Ok, well we will just continue on!");
                                    }
                                }

                                else {

                                    for (int k = 0; k < players.get(j).getItems().size(); ++k) {

                                        if (players.get(j).getItem(k).equalsIgnoreCase("nothing")) {

                                            players.get(j).replaceItem("Cooper Cane", k);
                                            System.out.println("Your item was added");
                                            break; // this is to break the loop once the item is added
                                        }
                                    }
                                }
                            }

                            else if (num == 6) {

                                System.out.println("You got a Captain Toad Coin!");
                                
                                if (players.get(j).fullInventory()) {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace an item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Captain Toad Coin", replace);
                                    }

                                    else {

                                        System.out.println("Ok, well we will just continue on!");
                                    }
                                }

                                else {

                                    for (int k = 0; k < players.get(j).getItems().size(); ++k) {

                                        if (players.get(j).getItem(k).equalsIgnoreCase("nothing")) {

                                            players.get(j).replaceItem("Captain Toad Coin", k);
                                            System.out.println("Your item was added");
                                            break; // this is to break the loop once the item is added
                                        }
                                    }
                                }
                            }

                            else if (num == 7) {

                                System.out.println("You got a Shy hide!");
                                
                                if (players.get(j).fullInventory()) {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace an item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;
                                        players.get(j).replaceItem("Shy hide", replace);
                                    }

                                    else {

                                        System.out.println("Ok, well we will just continue on!");
                                    }
                                }

                                else {

                                    for (int k = 0; k < players.get(j).getItems().size(); ++k) {

                                        if (players.get(j).getItem(k).equalsIgnoreCase("nothing")) {

                                            players.get(j).replaceItem("Shy hide", k);
                                            System.out.println("Your item was added");
                                            break; // this is to break the loop once the item is added
                                        }
                                    }
                                }
                            }

                            else if (num == 8) {

                                System.out.println("You got a Petey Pounce!");
                                
                                if (players.get(j).fullInventory()) {

                                    System.out.println("Oh, looks like your inventory is full, do you want to replace an item?");

                                    response = scnr.next();

                                    if (response.equalsIgnoreCase("yes")) {

                                        System.out.println("Which slot do you want to replace? (Type the number slot that correlates with the item you want to replace)");
                                        System.out.println(players.get(j).getItems());

                                        int replace = scnr.nextInt();
                                        replace = replace - 1;

                                        players.get(j).replaceItem("Petey Pounce", replace);
                                    }

                                    else {

                                        System.out.println("Ok, well we will just continue on!");
                                    }
                                }

                                else {

                                    for (int k = 0; k < players.get(j).getItems().size(); ++k) {

                                        if (players.get(j).getItem(k).equalsIgnoreCase("nothing")) {

                                            players.get(j).replaceItem("Petey Pounce", k);
                                            System.out.println("Your item was added");
                                            break; // this is to break the loop once the item is added
                                        }
                                    }
                                }

                            }

                        else {

                            System.out.println("Dang, looks like he got choked up and didn't give you anything!");
                        }
                        

                }

                if (players.get(j).getBooster()) {

                    System.out.println("Here we are! Let's get another turn going!");
                    players.get(j).setBooster(false);
                    --j;
                }

                players.get(0).display();
                players.get(1).display();
                players.get(2).display();
                players.get(3).display();
                System.out.println();
                
            }

            minigame(players);

            System.out.println("Post minigame results: ");
            System.out.println();

            players.get(0).display();
            players.get(1).display();
            players.get(2).display();
            players.get(3).display();

            System.out.println();
            
        }

        System.out.println("The game is over! Let's see who won!");
        findWinner(players);
        scnr.close();
        stdin.close();        
    }


    public static void ListOFItems() {

    System.out.println("Items: ");
    System.out.println("Scrooge's blessing: gives you 20 coins instantly - 8 coins");
    System.out.println("Booster Pass: Go back in time and get another turn - 12 coins");
    System.out.println("DK BK: Call DK to help protect you from Bowser - 6 coins");
    System.out.println("Cooper Cane: Let's you steal an item or coins from a player - 10 coins");
    System.out.println("Pit Stop: Allows you to land on any space you choose - 20 coins");
    System.out.println("Blanka Ball: Let's you stun a player and skip their turn - 5 coins");
    System.out.println("Captain Toad Coin: Cuts the cost of the star in half - 12 coins");
    System.out.println("Shy hide: Protects you from any items usage that comes for you - 8 coins");
    System.out.println("Petey Pounce: Calls Petey Piranha to pounce a player (coins: free, star: 40 coins) - 15 coins");
    System.out.println("------------------------------------------------------------");

    }

    public static void minigame(ArrayList<Player> players) {
        
        Scanner scnr = new Scanner(System.in);
        Random ran = new Random();

        HashMap<String, Integer> colors = new HashMap<String, Integer>(5);
        ArrayList<String> addedColor = new ArrayList<String>(5);

        colors.put("red", 1);
        colors.put("blue", 2);
        colors.put("green", 3);
        colors.put("yellow", 4);
        colors.put("purple", 5);

        int num = ran.nextInt(4);
        int leftStanding = 4;
        int reset = 0;

        String choice = "";

        System.out.println("Time to play Bowser's Big Blast! ");

        System.out.println("The rules are simple, there are 5 buttons, each with a different color. One of them will explode, and the last one standing wins!");
        System.out.println("If the button is pressed, you cannot press it again. If you press the button that explodes, you are out!");
        
        while (leftStanding > 1) {

            for (int index = 0; index < players.size(); ++index) {

                if (players.get(index).getBoom()) {

                System.out.println("Sorry, you are out " + players.get(index).getPlayerName() + "!");
                System.out.println();

                }

                else {

                    System.out.println("" + players.get(index).getPlayerName() + ", choose a color...and choose wisely!");
                    choice = scnr.next();

                    if (colors.get(choice) == num ) {

                        System.out.println("BOOM! You are out " + players.get(index).getPlayerName() + "!");
                        System.out.println();
                        players.get(index).setBoom(true);
                        --leftStanding; // this is to decrement the number of players left
                    }

                    else if (colors.get(choice) == num + 1 ) {

                        System.out.println("BOOM! You are out " + players.get(index).getPlayerName() + "!");
                        System.out.println();
                        players.get(index).setBoom(true);
                        --leftStanding; // this is to decrement the number of players left
                    }

                    else {

                        System.out.println("Phew! You are safe " + players.get(index).getPlayerName() + ". Good Guess!");
                        System.out.println();
                    }


                }
            
                num = ran.nextInt(4);

            }
        }

        for (int i = 0; i < players.size(); ++i) {

            if (!players.get(i).getBoom()) {

                System.out.println("Congratulations " + players.get(i).getPlayerName() + ", you are the winner of Bowser's Big Blast!");
                players.get(i).addCoins(10);
                break;
            }
        }

        players.get(0).setBoom(false);
        players.get(1).setBoom(false);
        players.get(2).setBoom(false);
        players.get(3).setBoom(false);

    }

    public static void findWinner(ArrayList<Player> players) {

        Player temp = new Player();
        Player victor;

        victor = temp.winner(temp.winner(players.get(0), players.get(1)), temp.winner(players.get(2), players.get(3)));

        System.out.println("" + victor.getPlayerName() + " is the SUPERSTAR!!!!!! ");
    }
}
