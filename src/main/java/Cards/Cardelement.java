package Cards;

import javax.smartcardio.Card;

public interface Cardelement {
    /**
     * Gives colour of the card
     * @return String : colour of the card
     */
    public String giveColour();
    /**
     * Gives value of the card
     * @return int : Value of the card
     */
    public int giveValue();
    /**
     * The better isTrump()
     * @return true if yes false, if no
     */
    public boolean giveTrump();
    /**
     * Makes the card trump, adds 10 to its value, sets trump to equal 10
     */
    public void makeTrump();
    /**
     * Checks if this card is equivalent to a given card (Value and Colour)
     * @param y Cardelement : Card to compare to
     * @return boolean : True if yes, false if not
     */
    public boolean equalss(Cardelement y);
    /**
     * Checks if the Card is beaten or not
     * @return boolean : True if beaten, false if not
     */
    public boolean beat();
    /**
     * Marks the card as beaten or not beaten
     * @param b boolean : Makes card beaten or not byy changing true or false
     */
    public void mBeat(boolean b);
    /**
     * Gives the name of the card (location to its picture in the project)
     * @return String : Location/Name
     */
    public String getImageName();

    //https://tylerpalko.github.io/Is-My-Computer-ON/
    //public void setWith(Cardelement c);
    /**
     * Returns true if it is trump
     * @return
     */
    public boolean isTrump();
    /**
     * Return the true value of the card
     * @return int : Value without trump
     */
    public int giveRealValue();
}
