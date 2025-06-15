package Cards;

public class Hearts implements Cardelement {
    private static String colour;
    private int value;
    private int trump;
    private String location;
    private boolean beaten;

    /**
     * Konstruktor von cards.diamonds
     */
    public Hearts(int val, int tr, String location){
        colour = "hearts";
        value = val + tr;
        trump = tr;
        this.location = location;
        beaten = false;
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
    }
    public boolean beat() {
        return beaten;
    }
    public void mBeat(boolean b) {
        beaten = b;
    }
}
