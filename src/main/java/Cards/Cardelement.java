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
    //public Cardelement giveWith();
    //public void setWith(Cardelement c);
}
