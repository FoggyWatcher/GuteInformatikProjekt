package cards;

public class clubs implements cardelement {
    private static String colour;
    private int value;
    private boolean trump;

    /**
     * Konstruktor von cards.clubs
     */
    public clubs(int val, boolean tr){
        colour = "clubs";
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
