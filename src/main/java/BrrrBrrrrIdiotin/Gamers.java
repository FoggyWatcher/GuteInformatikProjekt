package BrrrBrrrrIdiotin;

import Cards.Cardelement;

public abstract class Gamers {
    public Gamers(){}
    public abstract void addCards(Cardelement[] n);
    public abstract void removeCards(Cardelement[] n);
    public abstract int giveAmOnHand();
    public abstract Cardelement[] getCard();

}
