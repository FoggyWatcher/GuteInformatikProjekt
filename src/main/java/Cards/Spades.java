package Cards;

public class Spades implements Cardelement {
    private static String colour;
    private int value;
    private int trump;
    private String location;
    private boolean beaten;

    /**
     * Konstruktor von cards.spades
     */
    public Spades(int val, int tr, String location){
        colour = "spades";
        value = val + tr;
        trump = tr;
        this.location = location;
        beaten = false;
    }

    public String giveColour(){
        return colour;
    }

    public int giveValue(){
        return value;
    }

    public boolean giveTrump(){
        return trump == 10;
    }

    public String getImageName(){
        return location;
    }

    public void makeTrump(){
        trump = 10;
    }

    public boolean isTrump(){
        if(trump == 10){
            return true;
        }else{
            return false;
        }
    }

    public boolean equalss(Cardelement y){
        return y.giveValue() == value && colour.equals(y.giveColour());
    }
    public boolean beat() {
        return beaten;
    }
    public void mBeat(boolean b) {
        beaten = b;
    }
}
