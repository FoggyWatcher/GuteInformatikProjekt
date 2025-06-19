package Cards;

public class Clubs implements Cardelement {
    private static String colour;
    private int value;
    private int trump;
    private String location;
    private boolean beaten;
    public Cardelement with;

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

    public boolean giveTrump(){
        return trump == 10;
    }

    public void makeTrump(){
        trump = 10;
    }

    public boolean isTrump(){
        if(trump == 10){
            return true;
        }else{
            return false;
        }
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

    public Cardelement giveWith(){
        return with;
    }

    public void setWith(){

    }
}