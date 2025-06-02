public class Card {
    private Cardelement crdElem;
    public String giveColour(){
        return crdElem.giveColour();
    }
    public void makeTrump(){
        crdElem.addValue();
    }
}
