package Cards;

public class Diamonds implements Cardelement {
    private static String colour;
    private int value;
    private int trump;
    private String location;
    private boolean beaten;

    /**
     * Konstruktor von cards.diamonds
     */
    public Diamonds(int val, int tr, String location){
        colour = "diamonds";
        value = val + tr;
        trump = tr;
        this.location = location;
        beaten = false;
    }

    public int giveRealValue() {
        return value - trump;
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
        value += 10;
    }

    public boolean isTrump(){
        if(trump == 10){
            return true;
        }else{
            return false;
        }
    }

    public boolean equalss(Cardelement y){
        if(y == null){
            System.out.println("y in cardelement ist null");
            return false;
        }
        return y.giveValue() == value && colour.equals(y.giveColour());
    }
    public boolean beat() {
        return beaten;
    }
    public void mBeat(boolean b) {
        beaten = b;
    }
}
