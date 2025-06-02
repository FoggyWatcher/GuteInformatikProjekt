import java.util.ArrayList;
import java.util.Random;
import static java.util.Collections.shuffle;

public class Table extends Dealer {
    ArrayList<Card> deck;
    Gamers p = new Player();
    Gamers[] enemies;
    Card last = new Card();
    String trump;
    String[] types;

    public void Table(Player p, Enemy[] e, int h){
        this.p = p;
        enemies = e;
        last = deck.get(35);
        trump = last.giveColour();
        types = new String[] {"Ace", "Eight", "Jester", "King", "Nine", "Queen", "Seven", "Six", "Ten"};
        deck = new ArrayList<Card>(36);
        enemies = new Enemy[h];
        enemies = e;
        selectTrump(deck);
        last = deck.get(35);
    }

    public void main(String[] args){

    }

    public void getFromDeck(Gamers[] g){
        for(Gamer s : g){
            giveCards(s, (6 - s.giveAmOnHand()));
        }
    }

    public void giveFurther(){

    }

    public static void take(Gamers gamers, Card[] n){
        int z = n.length;
        gamers.addCards(n);
    }

    public void beaten(Gamers gamers, Card[] n){
        int z = n.length;
        gamers.removeCards(n);
        removeCard(n);
    }

    public void checkIfBeat(Gamers g, Card one, Card two){
        String col2 = two.giveColour();
        String col1 = one.giveColour();
        if(col1.equals(col2)){
            if(one.giveValue() <= two.giveValue()){
                beaten(g, new Card[]{one, two});
            }
            else{
                take(g, new Card[]{one, two});
            }
        }
        else if(col2.equals(trump)) {
            beaten(g, new Card[]{one, two});
        }
        else {
            throw new RuntimeException("ERROR DIFFERENT COLOURS AND NONE TRUMP MORON");
        }

    }

    public void removeCard(Card[] n){
        for(Card c: n){
            for(Card y: deck){
                if(c.equalss(y)){
                    deck.remove(y);
                }
            }
        }
    }

    public void giveCards(Gamers g, int q){
        Card[] c = new Card[q];
        for(int i = 0; i < q; i++){
            c[i] = deck.get(cardsLeft() - 1);
            deck.remove(cardsLeft() - 1);
        }
        p.addCards(c);
    }

    public int cardsLeft(){
        return deck.size();
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
}
