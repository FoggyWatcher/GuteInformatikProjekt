package Anzeige;

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

public class Game extends Application{
    private Stage primaryStage;
    private HBox bums;
    private HBox kartenleiste;
    private KonYaCon spiel;

    @Override
    public void start(Stage primStage) {
        primaryStage = primStage;

        //ich erstelle die borderpane + hbox
        BorderPane grundspiel = new BorderPane();
        kartenleiste = new HBox(); //anzeigen der karten in der hand
        bums = new HBox(); //anzeigen der karten auf dem tisch

        BackgroundImage backImg= new BackgroundImage(new Image(getClass().getResourceAsStream("/BilderProjekt/PokerTable.jpg")),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        //kartenleistendesign
        kartenleiste.setMaxWidth(Double.MAX_VALUE);
        kartenleiste.setStyle("-fx-background-color: #1d7435; -fx-border-width: 6px; -fx-border-color: #c0e10e");
        kartenleiste.setPrefHeight(120);

        //borderpanedesign
        BorderPane.setAlignment(grundspiel, Pos.CENTER);
        BorderPane.setMargin(grundspiel, new Insets(10));

        //einfuegen in borderpane
        grundspiel.setBackground(new Background(backImg));
        grundspiel.setTop(new Region());
        grundspiel.setCenter(bums);
        grundspiel.setLeft(new Region());
        grundspiel.setRight(new Region());
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
         * Viel Spaß beim duchblicken in diese
         */

        //Wichtige Objekte
        spiel = new KonYaCon();
        ArrayList<Cardelement> playerCardsOnHand;

        //zeigen des Trumfs and die Spieler
        new Cardelement lastCard = spiel.determineTrump();


        //Karten dem Spieler geben
        playerCardsOnHand = spiel.givePlayersCard();
        for(int i = 0; i < playerCardsOnHand; i++){
            //hier kommt etwas hinein
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}