import java.util.ArrayList;
import java.util.Arrays;

public class Player extends Gamers {
    ArrayList<Card> onHand = new ArrayList<>(6);

    public void addCards(Card[] n){
        onHand.addAll(Arrays.asList(n));
    }

    public void removeCards(Card[] n){
        for(Card c: n){
            onHand.removeIf(c::equalss);
        }
    }
}
