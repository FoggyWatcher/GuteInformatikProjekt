import java.util.ArrayList;

public class Enemy extends Dealer{
    int index;
    ArrayList<Card> eonHand = new ArrayList<>(6);

    public Enemy(int index){
        this.index = index;
    }

    public void addCards(int z, Card[] n){
        for(int i = 0; i < z; i++){
            eonHand.add(n[i]);
        }
    }
}
