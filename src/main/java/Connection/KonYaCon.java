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
    Gamers[] enemies;
    Cardelement played;
    Gamers plaid;
    ArrayList<Cardelement> deck;

    public KonYaCon(){
        p = table.givePlayer();
        enemies = table.giveEnemies();
        deck = table.giveDeck();
        table.getFromDeck();
    }

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
        int[] smallestTrumps = new int[4];
        smallestTrumps[0] = p.giveSmallestTrump();
        for(int i = 0; i < enemies.length; i++){
            smallestTrumps[i + 1] = enemies[i].giveSmallestTrump();
        }
        int smallest = 1000;
        for(int i = 0; i < 4; i++){
            if(smallestTrumps[i] < smallest){
                smallest = smallestTrumps[i];
            }
        }
        for (int i = 0; i < smallestTrumps.length; i++) {
            if (smallestTrumps[i] == smallest) {
                if(i == 0){
                    return p;
                }else if(i == 1) {
                    return enemies[0];
                }else if(i == 2){
                    return enemies[1];
                }else{
                    return enemies[2];
                }
            }
        }
        return null; //hoffentlich ist die Wahrscheinlichkeit dafür kleiner als die zahl auf meinem Bankkonto
    }

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
        Cardelement c = table.makeEnemyMove(enemies[i]);
        if(c.giveValue() != 52 && c.giveValue() != 80085){
            setPlaid(enemies[i]);
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

    public int cardsLeft(){
        return table.cardsLeft();
    }

    public void setDefender(Gamers defen){
        table.setDefender(defen);
    }

    public Gamers giveEnemy(int i){
        return enemies[i];
    }

    public int giveCardsNumber(Gamers gamer){
        return gamer.giveAmOnHand();
    }

    public void playCard(){
        plaid.removeCards(played);
        table.addInPlay(played);
    }

    public void endTurn(Gamers next){
        table.endTurn();
        table.setDefender(next);
    }

    //Gamers[] order = [player, enemy[1], enemy[2], enemy[3], player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]player, enemy[1], enemy[2], enemy[3]]

    public void giveFurther(Gamers gamers, Cardelement cardelement){
        table.giveFurther(gamers, cardelement);
    }

    public void tryToBeat(Cardelement bottom, Cardelement top){
        try {
            table.checkIfBeat(bottom, top);
        } catch (RuntimeException e) {
            throw new RuntimeException("Cant beat LL");
        }
    }
}
