package BrrrBrrrrIdiotin;

import Cards.*;
import org.jetbrains.annotations.NotNull;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Collections.*;

public class Table{
    ArrayList<Cardelement> deck;
    Gamers p = new Player();
    Gamers[] enemies;
    Gamers enemy;
    Cardelement last;
    String trump;
    String[] types;
    Cardelement[] inplay;
    Gamers defender;

    /**
     * Constructor of Table, creates a player, enemies, deck filled and shuffled with trump, trump
     */
    public Table(){
        p = new Player();
        types = new String[] {"Ace", "Eight", "Jester", "King", "Nine", "Queen", "Seven", "Six", "Ten"};
        deck = new ArrayList<Cardelement>(36);
        enemies = new Enemy[]{new Enemy(0)};
        enemy = enemies[0];
        selectTrump();
        last = deck.get(deck.size()-1);
        trump = last.giveColour();
        inplay = new Cardelement[12];
    }

    /**
     * Gives back the Player
     * @return Player of type Gamers
     */
    public Gamers givePlayer(){
        return p;
    }

    /**
     * Gives back the enemies as an array containing all enemies
     * @return Enemies of type Gamers[]
     */
    public Gamers giveEnemy(){
        return enemy;
    }

    public int giveGamersIndex(Gamers g){
        return g.giveIndex();
    }

    /**
     * Gives back the Deck as an array list of Cardelements
     * @return Deck as ArrayList<Cardelement>
     */
    public ArrayList<Cardelement> giveDeck(){
        return deck;
    }

    /**
     * Gives back the defender
     * @return Defender of type Gamers
     */
    public Gamers giveDefender(){
        return defender;
    }

    /**
     * Gives back the trump and the last card of the deck, one at the bottom
     * @return Last card as a Cardelement
     */
    public Cardelement returnLastTrump(){
        return last;
    }

    /**
     * Sets defender for this round
     * @param  gamer Gamers
     */
    public void setDefender(Gamers gamer){
        defender = gamer;
    }

    /**
     * Adds the played card to the list of cards in play, accepts only one card at a time
     * @param  c Cardelement
     */
    public void addInPlay(Cardelement c){
        int ch = 0;
        for(int i = 0; i < inplay.length; i++){
            if(inplay[i] != null) {
                ch += 1;
            }
        }
        inplay[ch] = c;
    }

    /**
     * Gives all player cards till they have six, otherwise skips them.
     * At the moment ignores the order of getting cards
     * Player first, then enemies 0,1,2
     */
    public void getFromDeck(){
        Gamers[] g = new Gamers[]{p, enemy};
        for(Gamers s : g){
            if(s.giveAmOnHand() < 6){
                giveCards(s, (6 - s.giveAmOnHand()));
            }
            else{
                continue;
            }
        }
    }

    /**
     * Ends the turn by deleting all played cards from the deck
     * In case it was beaten it just deletes cards, calls beaten()
     * If not beaten gives the defender all cards, calls take()
     * At the end calls getFromDeck() and fills everyone's hands
     */
    public void endTurn(){
        boolean b = true;
        for(Cardelement c : inplay){
            if(!c.beat()){
                b = false;
            }
        }
        if(b){
            beaten();
        }
        else{
            take();
        }
        inplay = null;
        for(int i = 0; i < inplay.length; i++){
            inplay[i] = null;
        }
        getFromDeck();
    }

    /**
     * Gives the cards the next player by changing the defender'
     * takes in the player, who will be the next defender
     * @param next Gamers
     */
    public void giveFurther(Gamers next, Cardelement cardelement){
        if(cardelement.giveValue() == inplay[0].giveValue()){
            defender.removeCards(cardelement);
            defender = next;
        }
        else{
            throw new RuntimeException("cant give further cs wrong colout LL SUCK IT AHAHHAH");
        }
    }

    /**
     * Gives the defender all cards, that are currently in PLay
     */
    public void take(){
        this.defender.addCards(this.inplay);
    }

    /**
     *Deletes all cards currently in active in the round
     */
    public void beaten(){
        removeCard(this.inplay);
    }

    /**
     * Checks if the second card given beats the first one, makes both cards  beaten = true
     * In case of an invalid entry throws a RunTimeException
     * @param one Cardelement, first card given     *
     * @param two Cardelemnt, seconf card given, tho one that is supposed to beat the other
     */
    public void checkIfBeat(Cardelement one, Cardelement two){
        String col2 = two.giveColour();
        String col1 = one.giveColour();
        if(col1.equals(col2)){
            if(one.giveValue() <= two.giveValue()){
                one.mBeat(true);
                two.mBeat(true);
            }
        }
        else if(col2.equals(trump)) {
            one.mBeat(true);
            two.mBeat(true);
        }
        else {
            throw new RuntimeException("ERROR DIFFERENT COLOURS AND NONE TRUMP MORON");
        }

    }

    /**
     * Deletes all cards given to it from the deck
     * @param n Cardelement, cards to be deleted
     */
    public void removeCard(Cardelement[] n){
        for(Cardelement c: n){
            deck.removeIf(c::equalss);
        }
    }

    /**
     * Gives the given player a specified amount of cards from the deck
     * @param g Gamers, the player to recieve cards from the deck
     * @param q int, ammount of cards to be given
     */
    public void giveCards(Gamers g, int q){
        Cardelement[] c = new Cardelement[q];
        for(int i = 0; i < q; i++){
            if(deck.size() == 1){
                c[i] = deck.get(0);
                deck.remove(0);
            }else{
                c[i] = deck.get(0);
                deck.remove(0);
            }
        }
        g.addCards(c);
    }

    /**
     * Returns the ammount of cards left in the deck
     * @return int, ammount of cards left
     */
    public int cardsLeft(){
        return deck.size();
    }

    /**
     * Initializes Cards of all colours with a link to their location
     * Adds all cards to the deck, the deck is sorted and has no trump
     */
    public void fill(){
        deck.clear();
        for(int i = 0; i < 9; i++){
            Cardelement d = new Clubs(i, 0, "/BilderProjekt/" + "Clubs" + types[i] + ".png");
            deck.add(i, d);
        }
        for(int i = 0; i < 9; i++){
            Cardelement d = new Diamonds(i, 0, "/BilderProjekt/"+ "Diamonds" + types[i] + ".png");
            deck.add(i+9, d);
        }
        for(int i = 0; i < 9; i++){
            Cardelement d = new Spades(i, 0, "/BilderProjekt/" + "Spades" + types[i] + ".png");
            deck.add(i+18, d);
        }
        for(int i = 0; i < 9; i++){
            Cardelement d = new Hearts(i, 0, "/BilderProjekt/" + "Hearts" + types[i] + ".png");
            deck.add(i+27, d);
        }
    }

    /**
     * Shuffles the deck and selects the last element as the trump
     * Makes all colours same as trump to trump
     */
    public void selectTrump(){
        fill();
        shuffle(deck);
        Cardelement c = deck.get(35);

        String s = c.giveColour();
        for(Cardelement i : deck){
            if(i.giveColour().equals(s)){
                i.makeTrump();
            }
        }
    }

    /**
     * Returns all values that are currently in Play without repetition
     * @return int[] with all values that one can dokinut'
     */
    public int[] typesInPlay(){
        int[] a = new int[12];
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < i; j++){
                if(inplay[i].giveValue() != a[j]){
                    a[i] = inplay[i].giveValue();
                }
            }
        }
        return a;
    }

    /**
     * Looks for all non-null elements in the inPlay array
     * @return amount of non-null positions in inPlay
     */
    public int giveLength(){
        int ch = 0;
        for (Cardelement cardelement : inplay) {
            if (cardelement != null) {
                ch += 1;
            }
        }
        return ch;
    }

    /**
     * Checks if and integer is in an array and returns true or false
     * @param a integer to find
     * @param b array to look in
     * @return true if is in false if not
     */
    public boolean isIn(int a, int[] b){
        for (int j : b) {
            if (a == j) {
                return true;
            }
        }
        return false;
    }

    /**
     * Looks at all cards that are in Play and pick out all that are yet to be defeated
     * @return Arraylist of cards that in play and yet to be defeated
     */
    public ArrayList<Cardelement> notBeatenAndInPlay(){
        ArrayList<Cardelement> all = new ArrayList<Cardelement>(12);
        int counter = 0;
        for(Cardelement c : inplay){
            if(!c.beat()){
                all.add(counter, c);
                counter += 1;
            }
        }
        return all;
    }

    /**
     * Puts all cards of the defender of same colour into an array
     * @param colour : Colour of cards
     * @return Arraylist with all cards of same colour on hand of defender
     */
    public ArrayList<Cardelement> giveAllCardOfColour(String colour, Gamers gamers){
        ArrayList<Cardelement> tspmo = new ArrayList<>();
        int counter = 0;
        for(Cardelement c : gamers.giveOnHand()){
            if(c.giveColour().equals(colour)){
                tspmo.add(counter, c);
                counter += 1;
            }
        }
        return tspmo;
    }

    /**
     * Makes and Attack, doesn't attack with trump unless there are already 10 cards on the table
     * OR there are less than 5 cards left in the deck.
     * Can attack first too, does so with the smallest non-trump on hand.
     * Attacks with the first non trump of the same value as cards already in play.
     * If cant attack or too many cards are already present returns Diamond BOOBS
     * *80085 OOOOOPS Sorry >_< a - a - .... a mmm-m-mistake >~< , hehe silly me
     * @param gamer one to attack
     * @return Card that is an attack or display of defeat
     */
    public Cardelement makeEnemyAttack(@NotNull Gamers gamer){
        ArrayList<Cardelement> gamerOnHand = sortInValue(gamer.giveOnHand());
        int[] a = typesInPlay();
        if(giveLength() == 0){
            for(Cardelement c : gamerOnHand){
                if(!c.isTrump()){
                    return c;
                }
            }
        }
        if(giveLength() > 11){
            return new Diamonds(80085, 0, "Ma balls");
        }
        for(int i = 0; i < gamer.giveAmOnHand(); i++){
            Cardelement c = gamerOnHand.get(i);
            if(giveLength() > 8 && c.giveTrump() && isIn(c.giveValue() - 10, a)){
                return c;
            }
            else if((!c.isTrump() && isIn(c.giveValue(), a) )|| (deck.size() < 5 && isIn(c.giveValue(), a))){
                gamer.removeCards(c);
                return c;
            }
        }
        return new Diamonds(80085, 0, "Ma balls");
    }

    /**
     * Sorts and array of cards based on their value
     * @param a List to be sorted
     * @return Sorted list
     */
    public ArrayList<Cardelement> sortInValue(@NotNull ArrayList<Cardelement> a){
        a.sort(Comparator.comparingInt(Cardelement::giveValue));
        return a;
    }

    /**
     * Tries to beat a card with a card of same colour
     * @param a All cards of same colour on hands
     * @param c Card that is to be beaten
     * @return Cardelement/null : Card that beats c ot null
     */
    public Cardelement returnIfBeat(ArrayList<Cardelement> a, Cardelement c){
        for (Cardelement cat : a) {
            if (cat.giveValue() > c.giveValue()) {
                return cat;
            }
        }
        return null;
    }

    /**
     * Tries to beat a card with trump that are on hand
     * @param a, list of trumps on hand
     * @param c, Card to beat
     * @return Cardelement/Null : Card that beats c or null
     */
    public Cardelement tryTrump(ArrayList<Cardelement> a, Cardelement c){
        if(returnIfBeat(a, c) != null){
            return returnIfBeat(a, c);
        }
        else{
            return null;
        }
    }

    /**
     * Tries to beat a card with either cards of same colour or a trump
     * @param a, All cards that aren't trump and have same colour
     * @param b All trumps
     * @param c Card to beat
     * @return Cardelement : Card that beats card C or a joke card that tells that its GG
     */
    public Cardelement returnIfBeatUltimate(ArrayList<Cardelement> a, ArrayList<Cardelement> b, Cardelement c){
        Cardelement karta = returnIfBeat(a, c);
        if(karta != null){
            karta.mBeat(true);
            c.mBeat(true);
            return karta;
        }
        else{
            Cardelement kartaLuchshe = tryTrump(b, c);
            if(kartaLuchshe != null){
                kartaLuchshe.mBeat(true);
                c.mBeat(true);
                return kartaLuchshe;
            }
            else{
                return new Hearts(52, 0, "Ma balls in ya jaws");
            }
        }
    }

    /**
     * Creates an array "trumps", and fills it with all trump om hand
     * @param myClubs, Clubs on hand
     * @param myHearts, Hearts on hand
     * @param myDiamonds, Diamonds on hand
     * @param mySpades, Spades on hand
     * @return trupms, all cards on hand that are trump
     */
    public ArrayList<Cardelement> findAllTrump(ArrayList<Cardelement> myClubs, ArrayList<Cardelement> myHearts, ArrayList<Cardelement> myDiamonds, ArrayList<Cardelement> mySpades){
        ArrayList<Cardelement> trumps = new ArrayList<>();
        switch (trump){
            case "Clubs":
                trumps = myClubs;
            case "Diamonds":
                trumps = myDiamonds;
            case "Hearts":
                trumps = myHearts;
            case "Spades":
                trumps = mySpades;
        }
        return trumps;
    }

    /**
     * Defends one card, the cards are defended in the Rihenfolge that they were put on table
     * Allways answers with the smallest possible non trump, if cant uses trump, if stil cant than GG
     * @param gamer, Gamers, one to defend
     * @return Cardelement : card that he uses to defend
     */
    public Cardelement makeEnemyDefend(Gamers gamer){
        ArrayList<Cardelement> myClubs = sortInValue(giveAllCardOfColour("Clubs", gamer));
        ArrayList<Cardelement> myDiamonds = sortInValue(giveAllCardOfColour("Diamonds", gamer));
        ArrayList<Cardelement> myHearts = sortInValue(giveAllCardOfColour("Hearts", gamer));
        ArrayList<Cardelement> mySpades = sortInValue(giveAllCardOfColour("Spades", gamer));
        ArrayList<Cardelement> toBeat = notBeatenAndInPlay();
        ArrayList<Cardelement> trumps = new ArrayList<>();

        trumps = findAllTrump(myClubs, myHearts, myDiamonds, mySpades);

        for(Cardelement c : toBeat) {
            if (c.giveColour().equals("Clubs")) {
                return returnIfBeatUltimate(myClubs, trumps, c);
            } else if (c.giveColour().equals("Diamonds")) {
                return returnIfBeatUltimate(myDiamonds, trumps, c);
            } else if (c.giveColour().equals("Hearts")) {
                return returnIfBeatUltimate(myHearts, trumps, c);
            } else if (c.giveColour().equals("Spades")) {
                return returnIfBeatUltimate(mySpades, trumps, c);
            }
        }

        return new Hearts(52, 0, "Ma balls in ya jaws");
    }

    /**
     * Makes a specified enemy make a move, returns only ONE card
     * Both attacks and defends
     * @param gamers: Gamers, one to make a move
     * @return Cardelement, card that is to be played or a representative of inability
     */
    public Cardelement makeEnemyMove(Gamers gamers){
        if(defender.giveIndex() == gamers.giveIndex()){
            return makeEnemyDefend(gamers);
        }
        else{
            return makeEnemyAttack(gamers);
        }
    }

    public int returnNull(){
        return 0;
    }public int returnEinz(){
        return 1;
    }public int returnZwei(){
        return 2;
    }public int returnThree(){
        return 3;
    }public int returnFour(){
        return 4;
    }
}
