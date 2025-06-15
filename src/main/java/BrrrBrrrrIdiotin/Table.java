package BrrrBrrrrIdiotin;

import Cards.*;

import java.util.ArrayList;

import static java.util.Collections.shuffle;

public class Table{
    ArrayList<Cardelement> deck;
    Gamers p = new Player();
    Gamers[] enemies;
    Cardelement last;
    String trump;
    String[] types;
    static Cardelement[] inplay;
    static Gamers defender;

    /**
     * Constructor of Table, creates a player, enemies, deck filled and shuffled with trump, trump
     */
    public Table(){
        p = new Player();
        types = new String[] {"Ace", "Eight", "Jester", "King", "Nine", "Queen", "Seven", "Six", "Ten"};
        deck = new ArrayList<Cardelement>(36);
        enemies = new Enemy[]{new Enemy(0), new Enemy(1), new Enemy(2)};
        selectTrump();
        last = deck.get(35);
        trump = last.giveColour();
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
    public Gamers[] giveEnemies(){
        return enemies;
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
     * @return Last card as an Cardelement
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
        int ch = inplay.length - 1;
        inplay[ch + 1] = c;
    }

    /**
     * Gives all player cards till they have six, otherwise skips them.
     * At the moment ignores the order of getting cards
     * Player first, then enemies 0,1,2
     */
    public void getFromDeck(){
        Gamers[] g = new Gamers[]{p, enemies[0], enemies[1], enemies[2]};
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
    public static void take(){
        Table.defender.addCards(inplay);
    }

    /**
     *Deletes all cards currently in active in the round
     */
    public void beaten(){
        removeCard(Table.inplay);
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
            c[i] = deck.get(cardsLeft() - 1);
            deck.remove(cardsLeft() - 1);
        }
        p.addCards(c);
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
        for(int i = 0; i < 9; i++){
            Cardelement d = new Clubs(i, 0, "BilderProjekt\\" + "Clubs" + types[0] + ".png");
            deck.add(i, d);
        }
        for(int i = 9; i < 18; i++){
            Cardelement d = new Diamonds(i, 0, "BilderProjekt\\" + "Clubs" + types[1] + ".png");
            deck.add(i, d);
        }
        for(int i = 18; i < 27; i++){
            Cardelement d = new Spades(i, 0, "BilderProjekt\\" + "Clubs" + types[2] + ".png");
            deck.add(i, d);
        }
        for(int i = 27; i < 36; i++){
            Cardelement d = new Hearts(i, 0, "BilderProjekt\\" + "Clubs" + types[3] + ".png");
            deck.add(i, d);
        }
    }

    /**
     * Shuffles the deck and selects the last element as the trump
     * Makes all colours same as trump to trump
     */
    public void selectTrump(){
        fill();
        shuffle(deck);
        Cardelement c = deck.get(36);

        String s = c.giveColour();
        for(Cardelement i : deck){
            if(i.giveColour().equals(s)){
                c.makeTrump();
            }
        }
    }
}
