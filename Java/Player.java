package Java;
import java.util.ArrayList;
import java.util.Random;

public class Player {

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

