package BrrrBrrrrIdiotin;

import Cards.Cardelement;

import java.util.ArrayList;

public abstract class Gamers {
    public Gamers(){}
    public abstract void addCards(Cardelement[] n);
    public abstract void removeCards(Cardelement c);
    public abstract int giveAmOnHand();
    public abstract Cardelement getCard();
    public abstract Cardelement giveCard();
    public abstract ArrayList<Cardelement> giveOnHand();
    public abstract int giveSmallestTrump();
}
