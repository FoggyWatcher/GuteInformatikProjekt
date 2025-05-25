public class Clubs implements Cardelement {
    private static String colour;
    private int value;
    private int trump;

    /**
     * Konstruktor von cards.clubs
     */
    public Clubs(int val, int tr){
        colour = "clubs";
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
