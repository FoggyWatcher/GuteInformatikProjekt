import java.util.ArrayList;

public class Player extends Dealer{
    ArrayList<Card> onHand = new ArrayList<>(6);

    public void addCards(int z, Card[] n){
        for(int i = 0; i < z; i++){
            onHand.add(n[i]);
        }
    }
}
