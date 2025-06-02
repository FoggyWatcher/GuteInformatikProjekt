public class Card {
    private Cardelement crdElem;

    public void makeTrump() {
        crdElem.giveTrump();
    }

    public String giveColour() {
        return crdElem.giveColour();
    }

    public int giveValue() {
        return crdElem.giveValue();
    }

    public boolean equalss(Card y) {
        return crdElem.equalss(y);
    }
}
