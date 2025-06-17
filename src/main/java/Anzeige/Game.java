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
    private VBox rechteLeiste;

    @Override
    public void start(Stage primStage) {
        primaryStage = primStage;

        //ich erstelle die borderpane + hbox
        BorderPane grundspiel = new BorderPane();
        kartenleiste = new HBox(); //anzeigen der karten in der hand
        bums = new HBox(); //anzeigen der karten auf dem tisch
        rechteLeiste = new VBox(); //Leiste rechts mit Trumpfkarte und Kartenstatus der gegner

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
        ArrayList<Cardelement> playerCardsOnHand;

        //zeigen des Trumfs and die Spieler
        Cardelement lastCard;
        lastCard = spiel.determineTrump();
        Image trumpfKarte = new Image(getClass().getResourceAsStream("/BilderProjekt/" + lastCard.getImageName()));
        ImageView trumpfView = new ImageView(trumpfKarte);
        Button trumpfButton = new Button();
        trumpfButton.setGraphic(trumpfView);
        trumpfButton.setOnAction(null);
        rechteLeiste.getChildren().addAll(trumpfButton);


        //Karten dem Spieler geben
        playerCardsOnHand = spiel.givePlayersCard();
        ArrayList<Button> buttons = new ArrayList<>();

        System.out.println(playerCardsOnHand.size());
        for(int i = 0; i < playerCardsOnHand.size(); i++){
            Button butn = new Button();
            String bildname = "/BilderProjekt/" + playerCardsOnHand.get(i).getImageName();
            Image bild = new Image(getClass().getResourceAsStream(bildname));
            ImageView bildView = new ImageView(bild);
            bildView.setFitHeight(98);
            bildView.setFitWidth(70);
            bildView.setPreserveRatio(true);
            butn.setGraphic(bildView);

            //einfügen in ArrayList
            buttons.add(butn);
            kartenleiste.getChildren().add(butn);
        }

        //Bestimmen wer anfängt
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}