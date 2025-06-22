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

public class Game extends Application{
    private Stage primaryStage;
    private HBox bums;
    private HBox kartenleiste;
    private KonYaCon spiel;
    private VBox rechteLeiste;
    private VBox linkeLeiste;
    private HBox obereLeiste;
    private int cardNumberEnemy3;
    private int cardNumberEnemy2;
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
        linkeLeiste = new VBox();
        obereLeiste = new HBox();

        BackgroundImage backImg= new BackgroundImage(new Image(getClass().getResourceAsStream("/BilderProjekt/PokerTable.jpg")),
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
        ArrayList<Cardelement> playerCardsOnHand;
        Label message = new Label("Das Spiel beginnt!");
        message.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: black; -fx-background-color: #1d7435; -fx-border-width: 2px; -fx-border-color: #c0e10e");
        ArrayList<Button> angriffKartenTisch = new ArrayList<>();

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
        //Design der oberen leiste
        obereLeiste.setMaxWidth(Double.MAX_VALUE);
        obereLeiste.setPrefHeight(60);
        obereLeiste.setAlignment(Pos.CENTER);
        obereLeiste.setSpacing(15);
        obereLeiste.getChildren().addAll(message);


        //Karten dem Spieler geben
        playerCardsOnHand = spiel.givePlayersCard();
        ArrayList<Button> buttons = new ArrayList<>();
        cardNumberEnemy1 = spiel.giveCardsNumber(spiel.giveEnemy(0));
        cardNumberEnemy2 = spiel.giveCardsNumber(spiel.giveEnemy(1));
        cardNumberEnemy3 = spiel.giveCardsNumber(spiel.giveEnemy(2));


        for(int i = 0; i < playerCardsOnHand.size(); i++){
            Button butn = new Button();
            butn.setOnAction(null);
            butn.setId("butn" +(i + 1));
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
        int fall = 0;

        //Buttons zeigen wie viele Karten gegner haben
        Button gegner1kartenZahl = new Button(String.valueOf(cardNumberEnemy1));
        linkeLeiste.getChildren().add(gegner1kartenZahl);
        Button gegner2kartenZahl = new Button(String.valueOf(cardNumberEnemy2));
        obereLeiste.getChildren().add(gegner2kartenZahl);
        Button gegner3kartenZahl = new Button(String.valueOf(cardNumberEnemy3));
        rechteLeiste.getChildren().add(gegner3kartenZahl);

        //Bestimmen wer anfängt
        if(spiel.giveBeginner() == null){
            //Spieler fängt an, weil er am wenigsten IQ besitzt
            attacker = spiel.givePlayer();
            message.setText("Spieler zieht auf Gegner 1");
            fall = 1;
        }else{
            attacker = spiel.giveBeginner();
            if(attacker.giveIndex() == 0){
                message.setText("Gegner 1 zieht auf Gegner 2");
                fall = 4;
            }else if(attacker.giveIndex() == 1){
                message.setText("Gegner 2 zieht auf Gegner 3");
                fall = 8;
            }else if(attacker.giveIndex() == 2){
                message.setText("Gegner 3 zieht auf Spieler");
                fall = 12;
            }else{
                message.setText("Spieler zieht auf Gegner 1");
                fall = 1;
            }
        }


        /**
         * Du dachtest das ist alles?
         * ~boss-music starts playing~
         * Jetzt fängt der teil an, wo dein gehirn vor Dummheit des Codes schmelzen wird
         */

        //hier spielen die Spieler
        switch(fall){
            case 1:
                //der Spieler zieht gegen gegner1
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.giveEnemy(0));
                for(int i = 0; i < buttons.size(); i++){
                    int finalI = i;
                    buttons.get(i).setOnAction(e -> {
                    bums.getChildren().add(buttons.get(finalI));
                    kartenleiste.getChildren().remove(buttons.get(finalI));
                    angriffKartenTisch.add(buttons.get(finalI));
                    });
                }
                //if(bums.getChildren().size() != 0){
                //    if(){
                //
                //    }
                //}
                //Kartenspielen
            case 2:
                //der Spieler zieht gegen gegner2
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.giveEnemy(1));
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.giveEnemy(0));
                for(int i = 0; i < buttons.size(); i++){
                    int finalI = i;
                    buttons.get(i).setOnAction(e -> {
                        bums.getChildren().add(buttons.get(finalI));
                        kartenleiste.getChildren().remove(buttons.get(finalI));
                        angriffKartenTisch.add(buttons.get(finalI));
                    });
                }
                //if(bums.getChildren().size() != 0){
                //    if(){
                //
                //    }
                //}
                //Kartenspielen
            case 3:
                //der Spieler zieht gegen gegner3
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.giveEnemy(2));
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.giveEnemy(0));
                for(int i = 0; i < buttons.size(); i++){
                    int finalI = i;
                    buttons.get(i).setOnAction(e -> {
                        bums.getChildren().add(buttons.get(finalI));
                        kartenleiste.getChildren().remove(buttons.get(finalI));
                        angriffKartenTisch.add(buttons.get(finalI));
                    });
                }
                //if(bums.getChildren().size() != 0){
                //    if(){
                //
                //    }
                //}
                //Kartenspielen
            case 4:
                //gegner1 zieht gegen gegner2
                spiel.setPlaid(attacker);
                spiel.setDefender(spiel.giveEnemy(1));
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