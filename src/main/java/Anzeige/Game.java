package Anzeige;

import BrrrBrrrrIdiotin.Gamers;
import Cards.Cardelement;
import Connection.KonYaCon;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Game extends Application {
    //wichtige Variablen
    private Stage primaryStage;
    private HBox bums;
    private HBox kartenleiste;
    private KonYaCon spiel;
    private VBox rechteLeiste;
    private VBox linkeLeiste;
    private HBox obereLeiste;
    private int cardNumberEnemy;
    private Gamers attacker;
    private ArrayList<Cardelement> playerCardsOnHand;
    Label message = new Label("Das Spiel beginnt!");
    private boolean gespielt = false;
    private ArrayList<Cardelement> attackerCardsonTable = new ArrayList<>();
    private ArrayList<Cardelement> defenderCardsonTable = new ArrayList<>();
    private EndWon endWon;
    private EndLost endLost;

    @Override
    public void start(Stage primStage) {
        primaryStage = primStage;

        //ich erstelle die borderpane + hbox
        BorderPane grundspiel = new BorderPane();
        kartenleiste = new HBox(); //anzeigen der karten in der hand
        bums = new HBox(); //anzeigen der karten auf dem tisch
        rechteLeiste = new VBox(); //Leiste rechts mit Trumpfkarte und Kartenstatus der gegner
        linkeLeiste = new VBox();
        obereLeiste = new HBox();

        BackgroundImage backImg = new BackgroundImage(new Image(getClass().getResourceAsStream("/BilderProjekt/PokerTable.jpg")),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        //"C:\Users\HP\IdeaProjects\GuteInformatikProjekt\target\classes\BilderProjekt\PokerTable.jpg"
        //kartenleistendesign
        kartenleiste.setMaxWidth(Double.MAX_VALUE);
        kartenleiste.setStyle("-fx-background-color: #1d7435; -fx-border-width: 6px; -fx-border-color: #c0e10e");
        kartenleiste.setPrefHeight(120);

        //bums design
        bums.setAlignment(Pos.CENTER);

        //borderpanedesign
        BorderPane.setAlignment(grundspiel, Pos.CENTER);
        BorderPane.setMargin(grundspiel, new Insets(10));

        //einfuegen in borderpane
        grundspiel.setBackground(new Background(backImg));
        grundspiel.setTop(obereLeiste);
        grundspiel.setCenter(bums);
        grundspiel.setLeft(linkeLeiste);
        grundspiel.setRight(rechteLeiste);
        grundspiel.setBottom(kartenleiste);

        //scene + weitere Sachen
        Scene scene = new Scene(grundspiel);
        primaryStage.setTitle("Durak-Spiel");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();


        /**
         * Hier fängt das wirklich Böse an
         * Wer das liest, kann lesen
         * Viel Spaß beim duchblicken in diese Hose
         */

        //Wichtige Objekte
        spiel = new KonYaCon();
        message.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: black; -fx-background-color: #1d7435; -fx-border-width: 2px; -fx-border-color: #c0e10e");

        //zeigen des Trumfs and die Spieler
        Cardelement lastCard = spiel.determineTrump();
        String trumpfBildname = lastCard.getImageName();
        Image trumpfKarte = new Image(getClass().getResourceAsStream(trumpfBildname));
        //Image trumpfKarte = new Image(getClass().getResourceAsStream("/BilderProjekt/ClubsAce.png")); <--war ein test
        ImageView trumpfView = new ImageView(trumpfKarte);
        Button trumpfButton = new Button();
        trumpfButton.setGraphic(trumpfView);
        trumpfButton.setOnAction(null);
        trumpfButton.setPrefWidth(80);
        trumpfView.setFitWidth(72);
        trumpfView.setPreserveRatio(true);
        //Design der rechten leiste
        rechteLeiste.setPrefWidth(120);
        rechteLeiste.setAlignment(Pos.CENTER);
        rechteLeiste.getChildren().addAll(trumpfButton);
        //Design der linken leiste
        linkeLeiste.setPrefWidth(120);
        linkeLeiste.setAlignment(Pos.CENTER);
        linkeLeiste.setSpacing(15);
        //Design der oberen leiste
        obereLeiste.setMaxWidth(Double.MAX_VALUE);
        obereLeiste.setPrefHeight(60);
        obereLeiste.setAlignment(Pos.CENTER);
        obereLeiste.setSpacing(15);
        obereLeiste.getChildren().addAll(message);

        playTurns();
    }

    public void playTurns() {
        //Karten dem Spieler geben
        playerCardsOnHand = spiel.givePlayersCard();
        ArrayList<Button> buttons = new ArrayList<>();
        cardNumberEnemy = spiel.giveCardsNumber(spiel.giveEnemy());
        ArrayList<Button> angriffKartenTisch = new ArrayList<>();


        for (int i = 0; i < playerCardsOnHand.size(); i++) {
            Button butn = new Button();
            butn.setOnAction(null);
            butn.setId("butn" + (i + 1));
            //String bildname = playerCardsOnHand.get(i).getImageName();
            //String bildname = "/BilderProjekt/clubsacebetter.png";
            Image bild = new Image(getClass().getResourceAsStream(playerCardsOnHand.get(i).getImageName()));
            ImageView bildView = new ImageView(bild);
            bildView.setFitHeight(98);
            bildView.setFitWidth(70);
            bildView.setPreserveRatio(true);
            butn.setGraphic(bildView);

            //einfügen in ArrayList
            buttons.add(butn);
            kartenleiste.getChildren().add(butn);
        }

        //Deklarieren der Variable für den switch-case
        AtomicInteger fall = new AtomicInteger(1);

        //Buttons zeigen wie viele Karten gegner haben
        Button gegnerKartenZahl = new Button(String.valueOf(cardNumberEnemy));
        obereLeiste.getChildren().add(gegnerKartenZahl);

        //Bestimmen wer anfängt
        if (spiel.giveBeginner() == null) {
            //Spieler fängt an, weil er am wenigsten IQ besitzt
            attacker = spiel.givePlayer();
            message.setText("Spieler zieht auf Gegner 1");
            fall.set(1);
        } else {
            attacker = spiel.giveBeginner();
            if (attacker.giveIndex() == 0) {
                message.setText("Gegner 1 zieht auf Spieler");
                fall.set(2);
            } else {
                message.setText("Spieler zieht auf Gegner 1");
                fall.set(1);
            }
        }

        /**
         * Initialisieren des take-Buttons
         * Dieser erlaubt es dem Spieler, die karten auf dem Tisch zu nehmen
         * Die karten werden vom Tisch entfernt und zur Hand des Spielers hinzugefügt
         */
        Button takeButton = new Button("TAKE");
        takeButton.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: black; -fx-background-color: #1d7435; -fx-border-width: 2px; -fx-border-color: #c0e10e");
        takeButton.setOnAction(e -> {
            if (attacker != spiel.givePlayer()) {
                for (int i = 0; i < angriffKartenTisch.size(); i++) {
                    playerCardsOnHand.add(attackerCardsonTable.get(i));
                    attackerCardsonTable.remove(attackerCardsonTable.get(i));
                }
                for (int i = 0; i < defenderCardsonTable.size(); i++) {
                    playerCardsOnHand.add(defenderCardsonTable.get(i));
                    defenderCardsonTable.remove(defenderCardsonTable.get(i));
                }
            }
        });
        linkeLeiste.getChildren().add(takeButton);

        /**
         * ich erstelle den "End turn"-Button
         * dieser wird den Zug des Spielers beenden, wenn er keine weiteren karten legen kann oder will
         */
        Button endTurnButton = new Button("End Turn");
        endTurnButton.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: black; -fx-background-color: #1d7435; -fx-border-width: 2px; -fx-border-color: #c0e10e");
        endTurnButton.setOnAction(e -> {
            if (attacker == spiel.givePlayer()) {
                spiel.endTurn(attacker);
                fall.set(2);
            }
        });
        linkeLeiste.getChildren().add(endTurnButton);

        /**
         * Du dachtest das ist alles?
         * ~boss-music starts playing~
         * Jetzt fängt der teil an, wo dein gehirn vor Dummheit des Codes schmelzen wird
         */

        //gefährliches while()
        switch (fall.get()) {
            case 1:
                //der Spieler zieht gegen gegner1
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.giveEnemy());
                for (int i = 0; i < buttons.size(); i++) {
                    int finalI = i;
                    buttons.get(finalI).setOnAction(e -> {
                        Cardelement playedCard = playerCardsOnHand.get(finalI);
                        int cardValue = playerCardsOnHand.get(finalI).giveRealValue();
                        if (attackerCardsonTable.isEmpty() && defenderCardsonTable.isEmpty()) {
                            bums.getChildren().add(buttons.get(finalI));
                            kartenleiste.getChildren().remove(buttons.get(finalI));
                            attackerCardsonTable.add(playedCard);
                            playerCardsOnHand.remove(playedCard);
                        }else if(checkInPlay(cardValue)){
                            bums.getChildren().add(buttons.get(finalI));
                            kartenleiste.getChildren().remove(buttons.get(finalI));
                            angriffKartenTisch.add(buttons.get(finalI));
                            attackerCardsonTable.add(playedCard);
                            playerCardsOnHand.remove(playedCard);
                        }else{
                            System.out.println("Andere karte, bitte!");
                        }


                    });
                }

                break;

            case 2:
                //der gegner zieht gegen den Spieler
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.givePlayer());
                break;


            default:
                //Endfall, nachdem das Spiel zu ende ist
                endTheGame();
        }

    }

    private void endTheGame() {
        //Hier endet das Spiel anders, je nachdem wer gewonnen hat
        if (playerCardsOnHand.size() == 0) {
            endWon = new EndWon();
            try {
                endWon.start(new Stage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            primaryStage.close();
        } else {
            endLost = new EndLost();
            try {
                endLost.start(new Stage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            primaryStage.close();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    public boolean checkInPlay(int cardValue) {
        boolean check = false;
        for (int i = 0; i < attackerCardsonTable.size(); i++) {
            if (attackerCardsonTable.get(i).giveRealValue() == cardValue) {
                return true;
            }
        }
        for (int j = 0; j < defenderCardsonTable.size(); j++) {
            if (defenderCardsonTable.get(j).giveRealValue() == cardValue) {
                return true;
            }
        }
        return false;
    }
}