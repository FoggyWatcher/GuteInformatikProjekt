public class Hearts extends Card implements Cardelement {
    private static String colour;
    private int value;
    private int trump;
    private String location;

    /**
     * Konstruktor von cards.diamonds
     */
    public Hearts(int val, int tr, String location){
        colour = "hearts";
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
        if(trump == 10){
            return true;
        }
        else {
            return false;
        }
    }
}
