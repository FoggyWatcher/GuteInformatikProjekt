package BrrrBrrrrIdiotin;

import Cards.Cardelement;

import java.util.ArrayList;
import java.util.Arrays;
//add instant add cards
public class Player extends Gamers {
    ArrayList<Cardelement> onHand = new ArrayList<>(6);

    /**
     * Adds given cards to the players on hand cards
     * @param n Cardelement[], cards to be added
     */
    public void addCards(Cardelement[] n){
        onHand.addAll(Arrays.asList(n));
    }

    /**
     * Removes all given cards from the players on hand list
     * @param c Cardelement, cards that are to be deleted
     */
    public void removeCards(Cardelement c){
            onHand.removeIf(c::equalss);
    }

    /**
     * Returns all cards on hand
     * @return ArrayList<Cardelement>, cards that are currently on hand
     */
    public  ArrayList<Cardelement> giveOnHand(){
        return onHand;
    }

    public int giveSmallestTrump(){
        ArrayList <Integer> trumpValues = new ArrayList<>();
        for(int i = 0; i < onHand.size(); i++){
            if(onHand.get(i).isTrump()){
                trumpValues.add(onHand.get(i).giveValue());
            }
        }
        if(trumpValues.isEmpty()){
            return 1000;
        }
        int min = trumpValues.get(0);
        for (int i = 1; i < trumpValues.size(); i++) {
            if (trumpValues.get(i) < min) {
                min = trumpValues.get(i);
            }
        }
        return min;
    }

    /**
     * Gives the amount of cards on hand
     * @return int, number of cards on hand
     */
    public int giveAmOnHand(){
        return onHand.size();
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
     * Not used atm, shi's confoosing n lk useless af, ts pmo
     * @return Cardelement c, card that it got from getCard()
     */
    public Cardelement giveCard(){
        Cardelement c = getCard();
        removeCards(c);
        return c;
    }
}
