public class Diamonds implements Cardelement {
    private static String colour;
    private int value;
    private int trump;

    /**
     * Konstruktor von cards.diamonds
     */
    public Diamonds(int val, int tr){
        colour = "diamonds";
        value = val + tr;
        trump = tr;
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
}
