package BrrrBrrrrIdiotin;

import Cards.*;

import java.util.ArrayList;
import static java.util.Collections.shuffle;

public class Deck {
    ArrayList<Card> deck;
    int trump = 0;
    String[] types;

    public void Deck() {
        types = new String[] {"Ace", "Eight", "Jester", "King", "Nine", "Queen", "Seven", "Six", "Ten"};
        deck = new ArrayList<Card>(36);
        fill();
        shuffle(deck);
    }

    public void fill(){
        for(int i = 0; i < 9; i++){
            Card d = new Clubs(i, trump, "BilderProjekt\\" + "Clubs" + types[i]);
            deck.add(i, d);
        }
        for(int i = 9; i < 18; i++){
            Card d = new Diamonds(i, trump, "BilderProjekt\\" + "Clubs" + types[i]);
            deck.add(i, d);
        }
        for(int i = 18; i < 27; i++){
            Card d = new Spades(i, trump, "BilderProjekt\\" + "Clubs" + types[i]);
            deck.add(i, d);
        }
        for(int i = 27; i < 36; i++){
            Card d = new Hearts(i, trump, "BilderProjekt\\" + "Clubs" + types[i]);
            deck.add(i, d);
        }
    }
}
