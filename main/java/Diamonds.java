public class Diamonds extends Card implements Cardelement {
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
        if(trump == 10){
            return true;
        }
        else {
            return false;
        }
    }

    public void addValue(){
        trump = 10;
        value += 10;
    }
}
