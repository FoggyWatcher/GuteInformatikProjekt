package BrrrBrrrrIdiotin;
import BrrrBrrrrIdiotin.Table.*;

import Cards.Cardelement;

import java.util.ArrayList;
import java.util.Arrays;
//add instant add cards
public class Player extends Gamers {
    ArrayList<Cardelement> onHand = new ArrayList<>(6);
    int index = 600;
    Cardelement smallestTrump;

    public void setSmallestTrump(Cardelement c){
        smallestTrump = c;
    }



    public Cardelement giveSmallestTrumppppp(){
        return smallestTrump;
    }
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
     * Retruns the number 600 because it doesn't make any difference
     */
    @Override
    public int giveIndex() {
        return index;
    }

    /**
     * Returns all cards on hand
     * @return ArrayList<Cardelement>, cards that are currently on hand
     */
    public  ArrayList<Cardelement> giveOnHand(){
        return onHand;
    }

    public int giveSmallestTrump(){
        int[] trumpValues = new int[]{1000, 1000, 1000, 1000, 1000, 1000};
        for (int i = 0; i < 6; i++) {
            if (onHand.get(i).isTrump()) {
                trumpValues[i] = onHand.get(i).giveValue();
            }
        }

        //if(trumpValues.isEmpty()){
        //     return 1000;
        //}

        int min = trumpValues[0];

        for (int i = 1; i < 6; i++) {
            if (trumpValues[i] < min) {
                min = trumpValues[i];
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
