import java.util.ArrayList;
import java.util.Arrays;

public class Enemy extends Gamers {
    int index;
    ArrayList<Card> eonHand = new ArrayList<>(6);

    public Enemy(int index){
        this.index = index;
    }

    public void addCards(Card[] n){
        eonHand.addAll(Arrays.asList(n));
    }

    public void removeCards(Card[] n){
        for(Card c: n){
            eonHand.removeIf(c::equalss);
        }
    }


}
