package BrrrBrrrrIdiotin;

import Cards.Cardelement;

import java.util.ArrayList;

public abstract class Gamers {
    public Gamers(){}
    /**
     * Adds given cards to the players on hand cards
     * @param n Cardelement[], cards to be added
     */
    public abstract void addCards(Cardelement[] n);
    /**
     * Gives the index of the enemy or player
     */
    public abstract int giveIndex();
    /**
     * Removes all given cards from the players on hand list
     * @param c Cardelement, cards that are to be deleted
     */
    public abstract void removeCards(Cardelement c);
    /**
     * Gives the amount of cards on hand
     * @return int, number of cards on hand
     */
    public abstract int giveAmOnHand();
    /**
     * gets card from button, not used anywhere, useless as of now
     * @return null cs shi useless
     */
    public abstract Cardelement getCard();
    /**
     * Returns a card, that it got from getCard() and removes it from the players hand
     * Not used atm, shi's confoosing n lk useless af, ts pmo
     * @return Cardelement c, card that it got from getCard()
     */
    public abstract Cardelement giveCard();
    /**
     * Returns all cards on hand
     * @return ArrayList<Cardelement>, cards that are currently on hand
     */
    public abstract ArrayList<Cardelement> giveOnHand();
    /**
     * Returns the smallest trump on hand, or a 1000 if there are no trump. Works only at the start, when the amount of cards is only 6
     * @return int : value of the smallest trump or 1000 in case there are none
     */
    public abstract int giveSmallestTrump();
}
