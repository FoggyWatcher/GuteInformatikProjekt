package Cards;

public interface Cardelement {
    public String giveColour();
    public int giveValue();
    public boolean giveTrump();
    public void makeTrump();
    public boolean equalss(Cardelement y);
}
