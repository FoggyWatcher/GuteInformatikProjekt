package cards;

public class hearts implements cardelement {
    private static String colour;
    private int value;
    private boolean trump;

    /**
     * Konstruktor von cards.hearts
     */
    public hearts(int val, boolean tr){
        colour = "hearts";
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
