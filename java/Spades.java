public class Spades extends Card implements Cardelement {
    private static String colour;
    private int value;
    private int trump;
    private String location;

    /**
     * Konstruktor von cards.spades
     */
    public Spades(int val, int tr, String location){
        colour = "spades";
        value = val + tr;
        trump = tr;
        this.location = location;
    }

    public String giveColour(){
        return colour;
    }

    public int giveValue(){
        return value;
    }

    public boolean giveTrump(){
        if(trump == 10){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean equalss(Card c){
        if(colour.equals(c.giveColour()) && value == c.giveValue()){
            return true;
        }
        else{
            return false;
        }
    }
}
