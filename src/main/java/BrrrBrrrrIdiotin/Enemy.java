package BrrrBrrrrIdiotin;

import Cards.Cardelement;

import java.util.ArrayList;
import java.util.Arrays;

public class Enemy extends Gamers {
    int index;
    ArrayList<Cardelement> eonHand = new ArrayList<>(6);

    public Enemy(int index){
        this.index = index;
    }

    public void addCards(Cardelement[] n){
        eonHand.addAll(Arrays.asList(n));
    }

    public void removeCards(Cardelement[] n){
        for(Cardelement c: n){
            eonHand.removeIf(c::equalss);
        }
    }

    public int giveAmOnHand(){
        return eonHand.size();
    }

    public Cardelement[] getCard(){
        return null; //Add connection to buttons
    }
}
