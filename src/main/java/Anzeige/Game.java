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

import java.io.InputStream;
import java.util.ArrayList;

public class Game extends Application{
    private Stage primaryStage;
    private HBox bums;
    private HBox kartenleiste;
    private KonYaCon spiel;
    private VBox rechteLeiste;
    private int cardNumberEnemy3;
    private int cardNumverEnemy2;
    private int cardNumberEnemy1;
    private Gamers attacker;


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
        rechteLeiste.setPrefWidth(120);
        rechteLeiste.setAlignment(Pos.CENTER);
        rechteLeiste.getChildren().addAll(trumpfButton);


        //Karten dem Spieler geben
        playerCardsOnHand = spiel.givePlayersCard();
        ArrayList<Button> buttons = new ArrayList<>();
        cardNumberEnemy3 = spiel.giveCardsNumber(spiel.giveEnemy(2));


        for(int i = 0; i < playerCardsOnHand.size(); i++){
            Button butn = new Button();
            butn.setOnAction(null);
            butn.setId("butn" +(i + 1));
            //String bildname = playerCardsOnHand.get(i).getImageName();
            String bildname = "/BilderProjekt/clubsacebetter.png";
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

        //Buttons zeigen wie viele Karten gegner haben
        Button gegner3kartenZahl = new Button(String.valueOf(cardNumberEnemy3));
        rechteLeiste.getChildren().add(gegner3kartenZahl);

        //Bestimmen wer anfängt
        if(spiel.giveBeginner() == null){
            //Spieler fängt an weil er am wenigsten IQ besitzt
            attacker = spiel.givePlayer();
        }else{
            attacker = spiel.giveBeginner();
        }


        /**
         * Du dachtest das ist alles?
         * ~boss-music starts playing~
         * Jetzt fängt der teil an, wo dein gehirn vor Dummheit des Codes schmelzen wird
         */

        //hier spielen die Spieler
        int fall = 0;
        switch(fall){
            case 1:
                //der Spieler zieht gegen gegner1
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.giveEnemy(0));
                //Kartenspielen
            case 2:
                //der Spieler zieht gegen gegner2
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.giveEnemy(1));
                //Kartenspielen
            case 3:
                //der Spieler zieht gegen gegner3
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.giveEnemy(2));
                //Kartenspielen
            case 4:
                //gegner1 zieht gegen gegner2
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.giveEnemy(1));
                //Kartenspielen
            case 5:
                //gegner1 zieht gegen gegner3
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.giveEnemy(2));
                //Kartenspielen
            case 6:
                //gegner1 zieht gegen Spieler
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.givePlayer());
                //Kartenspielen
            case 7:
                //gegner2 zieht gegen gegner1
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.giveEnemy(0));
                //Kartenspielen
            case 8:
                //gegner2 zieht gegen gegner3
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.giveEnemy(2));
                //Kartenspielen
            case 9:
                //gegner zieht gegen Spieler
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.givePlayer());
                //Kartenspielen
            case 10:
                //gegner3 zieht gegen gegner1
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.giveEnemy(0));
                //Kartenspielen
            case 11:
                //gegner3 zieht gegen gegner2
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.giveEnemy(1));
                //Kartenspielen
            case 12:
                //gegner3 zieht gegen Spieler
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.givePlayer());
                //Kartenspielen
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}