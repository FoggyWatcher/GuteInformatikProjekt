package Anzeige;

import BrrrBrrrrIdiotin.Table;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Game extends Application{
    private Stage primaryStage;
    private HBox kartenleiste;
    private HBox bums;
    private BorderPane grundspiel;
    private Table tisch;

    @Override
    public void start(Stage primStage) {
        primaryStage = primStage;

        //ich erstelle die borderpane + hbox
        grundspiel = new BorderPane();
        kartenleiste = new HBox();
        bums = new HBox(); //karten auf dem Tisch
        //tisch = new Table();

        BackgroundImage backImg= new BackgroundImage(new Image(getClass().getResourceAsStream("/BilderProjekt/PokerTable.jpg")),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        //Kartenleistendesign
        kartenleiste.setStyle("-fx-background-color: #1d7435; -fx-border-color: #c0e10e; -fx-border-width: 4px;");
        kartenleiste.setPadding(new Insets(0, 0, 40, 0));
        kartenleiste.setPrefHeight(130);

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
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void addCardsToPlayer(){
        //Hier will ich dem Spieler die Karten geben, die er bekommen hat
    }

    public void addCardsToTable(){
        //Hier werden die gespielten karten auf den Tisch gelegt
    }
}