package Cards;

public class Clubs implements Cardelement {
    private static String colour;
    private int value;
    private int trump;
    private String location;
    private boolean beaten;

    /**
     * Konstruktor von cards.clubs
     */
    public Clubs(int val, int tr, String location){
        colour = "clubs";
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

    public void makeTrump(){
        trump = 10;
        value += 10;
    }

    /**
     * Returns true if it is trump
     * @return
     */
    public boolean isTrump(){
        if(trump == 10){
            return true;
        }else{
            return false;
        }
    }

    /**
     * The better isTrump()
     * @return
     */
    public boolean giveTrump(){
        return trump == 10;
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

    public String getImageName(){
        return location;
    }

    public void setWith(){

    }
}