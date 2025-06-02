public class Spades implements Cardelement {
    private static String colour;
    private int value;
    private int trump;
    private String location;

    /**
     * Konstruktor von cards.spades
     */
    public Spades(int val, int tr, String location){
        colour = "spades";
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

    public boolean equalss(Cardelement c){
        if(colour.equals(c.giveColour()) && value == c.giveValue()){
            return true;
        }
        else{
            return false;
        }
    }

    public void makeTrump(){
        value += 10;
    }
}
