import java.util.ArrayList;
import java.util.Random;
import static java.util.Collections.shuffle;

public class Table{
    ArrayList<Cardelement> deck;
    Gamers p = new Player();
    Gamers[] enemies;
    Cardelement last;
    String trump;
    String[] types;

    public void Table(Player p, Enemy[] e, int h){
        this.p = p;
        enemies = e;
        trump = last.giveColour();
        types = new String[] {"Ace", "Eight", "Jester", "King", "Nine", "Queen", "Seven", "Six", "Ten"};
        deck = new ArrayList<Cardelement>(36);
        enemies = e;
        selectTrump(deck);
        last = deck.get(35);
    }

    public void main(String[] args){

    }

    public void getFromDeck(Gamers[] g){
        for(Gamers s : g){
            giveCards(s, (6 - s.giveAmOnHand()));
        }
    }

    public void giveFurther(Cardelement[] c, Gamers now, Gamers next){
        next.addCards(c);
        now.removeCards(c);
    }

    public static void take(Gamers gamers, Cardelement[] n){
        int z = n.length;
        gamers.addCards(n);
    }

    public void beaten(Gamers gamers, Cardelement[] n){
        int z = n.length;
        gamers.removeCards(n);
        removeCard(n);
    }

    public void checkIfBeat(Gamers g, Cardelement one, Cardelement two){
        String col2 = two.giveColour();
        String col1 = one.giveColour();
        if(col1.equals(col2)){
            if(one.giveValue() <= two.giveValue()){
                beaten(g, new Cardelement[]{one, two});
            }
            else{
                take(g, new Cardelement[]{one, two});
            }
        }
        else if(col2.equals(trump)) {
            beaten(g, new Cardelement[]{one, two});
        }
        else {
            throw new RuntimeException("ERROR DIFFERENT COLOURS AND NONE TRUMP MORON");
        }

    }

    public void removeCard(Cardelement[] n){
        for(Cardelement c: n){
            for(Cardelement y: deck){
                if(c.equalss(y)){
                    deck.remove(y);
                }
            }
        }
    }

    public void giveCards(Gamers g, int q){
        Cardelement[] c = new Cardelement[q];
        for(int i = 0; i < q; i++){
            c[i] = deck.get(cardsLeft() - 1);
            deck.remove(cardsLeft() - 1);
        }
        p.addCards(c);
    }

    public int cardsLeft(){
        return deck.size();
    }

    public void fill(ArrayList<Cardelement> a){
        for(int i = 0; i < 9; i++){
            Cardelement d = new Clubs(i, 0, "BilderProjekt\\" + "Clubs" + types[i] + ".png");
            deck.add(i, d);
        }
        for(int i = 9; i < 18; i++){
            Cardelement d = new Diamonds(i, 0, "BilderProjekt\\" + "Clubs" + types[i] + ".png");
            deck.add(i, d);
        }
        for(int i = 18; i < 27; i++){
            Cardelement d = new Spades(i, 0, "BilderProjekt\\" + "Clubs" + types[i] + ".png");
            deck.add(i, d);
        }
        for(int i = 27; i < 36; i++){
            Cardelement d = new Hearts(i, 0, "BilderProjekt\\" + "Clubs" + types[i] + ".png");
            deck.add(i, d);
        }
    }

    public void selectTrump(ArrayList<Cardelement> a){
        fill(deck);
        shuffle(deck);
        Cardelement c = a.get(36);

        String s = c.giveColour();
        for(Cardelement i : a){
            if(i.giveColour().equals(s)){
                c.makeTrump();
            }
        }
    }
}
