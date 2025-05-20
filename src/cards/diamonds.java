package cards;

public class diamonds implements cardelement{
    private static String colour;
    private int value;
    private boolean trump;

    /**
     * Konstruktor von cards.diamonds
     */
    public diamonds(int val, boolean tr){
        colour = "diamonds";
        value = val;
        trump = tr;
    }

    public String giveColour(){
        return colour;
    }

    public int giveValue(){
        return value;
    }

    public boolean giveTrump(){
        return trump;
    }
}
