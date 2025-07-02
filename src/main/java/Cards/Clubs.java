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

    /**
     * Return the true value of the card
     * @return int : Value without trump
     */
    public int giveRealValue() {
        return value - trump;
    }

    /**
     * Gives colour of the card
     * @return String : colour of the card
     */
    public String giveColour(){
        return colour;
    }

    /**
     * Gives value of the card
     * @return int : Value of the card
     */
    public int giveValue(){
        return value;
    }

    /**
     * Makes the card trump, adds 10 to its value, sets trump to equal 10
     */
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
     * @return true if yes false, if no
     */
    public boolean giveTrump(){
        return trump == 10;
    }

    /**
     * Checks if this card is equivalent to a given card (Value and Colour)
     * @param y Cardelement : Card to compare to
     * @return boolean : True if yes, false if not
     */
    public boolean equalss(Cardelement y){
        return y.giveValue() == value && colour.equals(y.giveColour());
    }

    /**
     * Checks if the Card is beaten or not
     * @return boolean : True if beaten, false if not
     */
    public boolean beat() {
        return beaten;
    }

    /**
     * Marks the card as beaten or not beaten
     * @param b boolean : Makes card beaten or not byy changing true or false
     */
    public void mBeat(boolean b) {
        beaten = b;
    }

    /**
     * Gives the name of the card (location to its picture in the project)
     * @return String : Location/Name
     */
    public String getImageName(){
        return location;
    }
}