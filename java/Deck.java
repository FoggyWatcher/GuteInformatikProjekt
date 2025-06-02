import java.util.ArrayList;
import java.util.Random;
import static java.util.Collections.shuffle;

public class Deck {
    ArrayList<Card> deck;
    int trump = 0;
    String[] types;
    int f = 0;
    Random rand = new Random();

    public void Deck() {
        types = new String[] {"Ace", "Eight", "Jester", "King", "Nine", "Queen", "Seven", "Six", "Ten"};
        deck = new ArrayList<Card>(36);
        f = rand.nextInt(4);
        fill();
        shuffle(deck);
    }

    public void fill(){
        if(f == 0){
            trump = 10;
        }
        for(int i = 0; i < 9; i++){
            Card d = new Clubs(i, trump, "BilderProjekt\\" + "Clubs" + types[i] + ".png");
            deck.add(i, d);
        }
        trump = 0;

        if(f == 1){
            trump = 10;
        }
        for(int i = 9; i < 18; i++){
            Card d = new Diamonds(i, trump, "BilderProjekt\\" + "Clubs" + types[i] + ".png");
            deck.add(i, d);
        }
        trump = 0;

        if(f == 2){
            trump = 10;
        }
        for(int i = 18; i < 27; i++){
            Card d = new Spades(i, trump, "BilderProjekt\\" + "Clubs" + types[i] + ".png");
            deck.add(i, d);
        }
        trump = 0;

        if(f == 3){
            trump = 10;
        }
        for(int i = 27; i < 36; i++){
            Card d = new Hearts(i, trump, "BilderProjekt\\" + "Clubs" + types[i] + ".png");
            deck.add(i, d);
        }
        trump = 0;
    }
}
