package cards;

public class spades implements cardelement{
    private static String colour;
    private int value;
    private boolean trump;

    /**
     * Konstruktor von cards.spades
     */
    public spades(int val, boolean tr){
        colour = "spades";
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
