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

    public Cardelement getEnemyMove(int i){
        setPlaid(enemies[i]);
        played = enemies[i].getCard();
        return enemies[i].getCard();
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
