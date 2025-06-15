package BrrrBrrrrIdiotin;

import Cards.Cardelement;

import java.util.ArrayList;
import java.util.Arrays;

public class Enemy extends Gamers {
    int index;
    ArrayList<Cardelement> eonHand = new ArrayList<>(6);

    /**
     * Initializes a new enemy with an index
     * @param index int, index of this enemy
     */
    public Enemy(int index){
        this.index = index;
    }

    /**
     * Returns the index of this enemy
     * @return int, index of this enemy
     */
    public int giveIndex(){
        return index;
    }

    /**
     * Adds given cards to the players on hand cards
     * @param n Cardelement[], cards to be added
     */
    public void addCards(Cardelement[] n){
        eonHand.addAll(Arrays.asList(n));
    }

    /**
     * Removes all given cards from the players on hand list
     * @param c Cardelement, cards that are to be deleted
     */
    public void removeCards(Cardelement c){
        eonHand.removeIf(c::equalss);    }

    /**
     * Returns all cards on hand
     * @return ArrayList<Cardelement>, cards that are currently on hand
     */
    public  ArrayList<Cardelement> giveOnHand(){
        return eonHand;
    }

    /**
     * Gives the amount of cards on hand
     * @return int, number of cards on hand
     */
    public int giveAmOnHand(){
        return eonHand.size();
    }

    /**
     * gets card from button, not used anywhere, useless as of now
     * @return null cs shi useless
     */
    public Cardelement getCard(){
        return null; //Add connection to buttons
    }

    /**
     * Returns a card, that it got from getCard() and removes it from the players hand
     * Not used atm, will give a card as an attack or defense later on
     * @return Cardelement c, card that it got from getCard()
     */
    public Cardelement giveCard(){
        Cardelement c = getCard();
        removeCards(c);
        return c;
    }
}
