import java.util.ArrayList;
import java.util.Random;
import static java.util.Collections.shuffle;

public class Dealer{
    ArrayList<Card> deck;
    Player p;
    Enemy[] enemies;
    String[] types;

    public void Dealer(Player p, Enemy[] e, int h){
        types = new String[] {"Ace", "Eight", "Jester", "King", "Nine", "Queen", "Seven", "Six", "Ten"};
        deck = new ArrayList<Card>(36);
        enemies = new Enemy[h];
        enemies = e;
    }

    public void fill(ArrayList<Card> a){
        for(int i = 0; i < 9; i++){
            Card d = new Clubs(i, 0, "BilderProjekt\\" + "Clubs" + types[i] + ".png");
            deck.add(i, d);
        }
        for(int i = 9; i < 18; i++){
            Card d = new Diamonds(i, 0, "BilderProjekt\\" + "Clubs" + types[i] + ".png");
            deck.add(i, d);
        }
        for(int i = 18; i < 27; i++){
            Card d = new Spades(i, 0, "BilderProjekt\\" + "Clubs" + types[i] + ".png");
            deck.add(i, d);
        }
        for(int i = 27; i < 36; i++){
            Card d = new Hearts(i, 0, "BilderProjekt\\" + "Clubs" + types[i] + ".png");
            deck.add(i, d);
        }
    }

    public void selectTrump(ArrayList<Card> a){
        fill(deck);
        shuffle(deck);
        Card c = a.get(36);

        String s = c.giveColour();
        for(Card i : a){
            if(i.giveColour().equals(s)){
                c.makeTrump();
            }
        }
    }

    public void givePlayerCards(int q){
        Card[] c = new Card[q];
        for(int i = 0; i < q; i++){
            c[i] = deck.get(cardsLeft() - 1);
            deck.remove(cardsLeft() - 1);
        }
        p.addCards(c);
    }

    public void giveEnemyCards(int q, int b){
        Card[] c = new Card[q];
        for(int i = 0; i < q; i++){
            c[i] = deck.get(cardsLeft() - 1);
            deck.remove(cardsLeft() - 1);
        }
        enemies[b].addCards(c);
    }


    public int cardsLeft(){
        return deck.size();
    }

    public ArrayList<Card> giveDeck(){
        selectTrump(deck);
        return deck;
    }

    public Player givePlayer(){
        return p;
    }

    public Enemy[] giveEnemy(){
        return enemies;
    }
}
