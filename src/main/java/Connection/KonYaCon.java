package Connection;

import BrrrBrrrrIdiotin.Enemy;
import BrrrBrrrrIdiotin.Gamers;
import BrrrBrrrrIdiotin.Player;
import BrrrBrrrrIdiotin.Table;
import Cards.Cardelement;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class KonYaCon {
    Table table = new Table();
    Gamers p;
    Gamers enemy;
    Cardelement played;
    Gamers plaid;
    ArrayList<Cardelement> deck;

    /**
     * Konstruktor
     */
    public KonYaCon(){
        p = table.givePlayer();
        enemy = table.giveEnemy();
        deck = table.giveDeck();
        table.getFromDeck();
    }

    /**
     * Sets the played card as such
     * @param cardelement : Played card
     */

    public void setPlayed(Cardelement cardelement){
        played = cardelement;
    }

    /**
     * Set the one who laid the card
     * @param gamers :Gamers, whe laid card
     */
    public void setPlaid(Gamers gamers){
        plaid = gamers;
    }

    /**
     * Return the cards Player p has on his hand
     * @return
     */
    public ArrayList<Cardelement> givePlayersCard(){
        return p.giveOnHand();
    }

    /**
     * Returns the index of the enemy
     */
    public int giveEnemyIndex(Gamers enemy){
        return table.giveGamersIndex(enemy);
    }

    /**
     * Determines who is the first to attack
     * Done through looking for the smallest trump
     * in gamers' cards
     * @return
     */
    public Gamers giveBeginner(){
        int[] smallestTrumps = new int[2];
        smallestTrumps[0] = p.giveSmallestTrump();
        smallestTrumps[1] = enemy.giveSmallestTrump();

        int smallest = 1000;

        for(int i = 0; i < 2; i++){
            if(smallestTrumps[i] < smallest){
                smallest = smallestTrumps[i];
            }
        }

        for (int i = 0; i < smallestTrumps.length; i++) {
            if (smallestTrumps[i] == smallest) {
                if(i == 0){
                    return p;
                }else if(i == 1) {
                    return enemy;}
            }
        }

        return null; //hoffentlich ist die Wahrscheinlichkeit dafür kleiner als die zahl auf meinem Bankkonto
    }

    /**
     * Gives the Player
     * @return Player
     */

     public Gamers givePlayer(){
        return p;
     }

    /**
     * Makes an enemy with given index make a move, in case that it can make a move, sets both played and plaid; utilizes playCard()
     * Can both attack and defend
     * If cant defend, returns a card, hearts with value 52
     * If cant attack, gives a card, diamonds with value 80085
     * @param i : int, Index of enemy to make move
     * @return Cardelement: card that is to be placed OR a card with value to display inability to attack or defend
     */
    public Cardelement getEnemyMove(int i ){
        Cardelement c = table.makeEnemyMove(enemy);
        if(c.giveValue() != 52 && c.giveValue() != 80085){
            setPlaid(enemy);
            setPlayed(c);
            playCard();
        }
        return c;
    }

    /**
     * Gives back last card and therefore determines the trump
     * @return
     */
    public Cardelement determineTrump(){
        table.selectTrump();
        return table.returnLastTrump();
    }

    /**
     * Tells how many cards are left
     * @return int: Cards left
     */
    public int cardsLeft(){
        return table.cardsLeft();
    }

    /**
     * Sets defender as such
     * @param defen Gamers : defender
     */
    public void setDefender(Gamers defen){
        table.setDefender(defen);
    }

    /**
     * Returns Enemy
     * @param i : So we dont have to change ALL the other classes, remnant of multiple enemies
     * @return Gamers : enemy
     */
    public Gamers giveEnemy(int i){
        return enemy;
    }

    /**
     * Tells how many cards a player has
     * @param gamer : Player whose hand is checked
     * @return int : ammount of cards on hand
     */
    public int giveCardsNumber(Gamers gamer){
        return gamer.giveAmOnHand();
    }

    public void playCard(){
        plaid.removeCards(played);
        table.addInPlay(played);
    }

    /**
     * Called at the end of the turn. Determines what has to be done, either deletes the cards if beaten, or gives to the defender
     */
    public void endTurn(){
        table.endTurn();
        if(table.giveDefender() == table.givePlayer()){
            table.setDefender(table.giveEnemy());
        }
        else{
            table.setDefender(table.givePlayer());
        }
    }

    /**
     * to be ignored
     */
    //Gamers[] order = [player, enemy[1], enemy[2], enemy[3], player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]]

    /**
     * Gives the cards further, will be added in future versions
     * @param gamers Gamers : Next defender
     * @param cardelement Cardelement : Card that was used to give forward
     */
    public void giveFurther(Gamers gamers, Cardelement cardelement){
        table.giveFurther(gamers, cardelement);
    }

    /**
     * Checks if a card can be beaten by a different one, if no, an exception is thrown
     * @param bottom Cardelement : Card that is to be beaten
     * @param top : Cardelement : Card that is trying to beat
     */
    public void tryToBeat(Cardelement bottom, Cardelement top){
        try {
            table.checkIfBeat(bottom, top);
        } catch (RuntimeException e) {
            throw new RuntimeException("Cant beat LL");
        }
    }
}
