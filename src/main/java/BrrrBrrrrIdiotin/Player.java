package BrrrBrrrrIdiotin;

import Cards.Cardelement;

import java.util.ArrayList;
import java.util.Arrays;

public class Player extends Gamers {
    ArrayList<Cardelement> onHand = new ArrayList<>(6);

    public void addCards(Cardelement[] n){
        onHand.addAll(Arrays.asList(n));
    }

    public void removeCards(Cardelement[] n){
        for(Cardelement c: n){
            onHand.removeIf(c::equalss);
        }
    }

    public int giveAmOnHand(){
        return onHand.size();
    }

    public Cardelement[] getCard(){
        return null; //Add connection to buttons
    }
}
