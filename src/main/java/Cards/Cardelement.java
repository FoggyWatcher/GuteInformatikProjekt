package Cards;

import javax.smartcardio.Card;

public interface Cardelement {
    public String giveColour();
    public int giveValue();
    public boolean giveTrump();
    public void makeTrump();
    public boolean equalss(Cardelement y);
    public boolean beat();
    public void mBeat(boolean b);
    public String getImageName();
    //https://tylerpalko.github.io/Is-My-Computer-ON/
    //public void setWith(Cardelement c);
    public boolean isTrump();

    public int giveRealValue();
}
