public class Hearts implements Cardelement {
    private static String colour;
    private int value;
    private int trump;

    /**
     * Konstruktor von cards.diamonds
     */
    public Hearts(int val, int tr){
        colour = "hearts";
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
