package Cards;

public class Diamonds implements Cardelement {
    private static String colour;
    private int value;
    private int trump;
    private String location;

    /**
     * Konstruktor von cards.diamonds
     */
    public Diamonds(int val, int tr, String location){
        colour = "diamonds";
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
        return trump == 10;
    }

    public void makeTrump(){
        trump = 10;
    }
    public boolean equalss(Cardelement y){
        return y.giveValue() == value && colour.equals(y.giveColour());
    };
}
