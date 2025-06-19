package Connection;

import BrrrBrrrrIdiotin.Enemy;
import BrrrBrrrrIdiotin.Gamers;
import BrrrBrrrrIdiotin.Player;
import BrrrBrrrrIdiotin.Table;
import Cards.Cardelement;

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

    public ArrayList<Cardelement> givePlayersCard(){
        Gamers dummy = table.givePlayer();
        return dummy.giveOnHand();
        //return table.givePlayer().giveOnHand(); <-- eto konstantinovskoe
    }

    public Cardelement getEnemyMove(int i){
        setPlaid(enemies[i]);
        return enemies[i].getCard();
    }

    /**
     * Gives back last card and therefore determines the trump
     * @return
     */
    public Cardelement determineTrump(){
        return table.returnLastTrump();
    }

    public int cardsLeft(){
        return table.cardsLeft();
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
