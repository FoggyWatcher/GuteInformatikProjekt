package Anzeige;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.Stage.*;

public class UnderConstruction extends Application{

    private Stage primaryStage;
    private Cardchoice cardwahl;

    public void start(Stage primStage) {
        primaryStage = primStage;

        //erstellen + design des labels
        Label nachricht = new Label("Currently under construction! Wait for next update!");
        nachricht.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: black;");

        //ich erstelle pane + hbox
        BorderPane grund = new BorderPane();
        HBox text = new HBox(nachricht);

        //Hintergrund
        BackgroundImage backImg = new BackgroundImage(new Image(getClass().getResourceAsStream("/BilderProjekt/PokerTable.jpg")),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        //Button
        Button back = new Button("BACK");
        back.setPrefSize(400, 100);

        //https://www.ismycomputeronfire.com/

        //Buttondesign
        back.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-background-color: #1d7435; -fx-border-width: 6px; -fx-border-color: #c0e10e");

        //Buttonfunktion
        back.setOnAction(e -> {
            cardwahl = new Cardchoice();
            try {
                cardwahl.start(new Stage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            primaryStage.close();
        });

        //nachrichtbearbeitung
        text.setAlignment(Pos.CENTER);

        //borderpanedesign
        HBox returnButton = new HBox(back);
        returnButton.setAlignment(Pos.CENTER);
        returnButton.setPrefHeight(240);

        //einfuegen in borderpane
        grund.setBackground(new Background(backImg));
        grund.setTop(new Region());
        grund.setCenter(text);
        grund.setLeft(new Region());
        grund.setRight(new Region());
        grund.setBottom(returnButton);

        //scene + weitere Sachen
        Scene scene = new Scene(grund);
        primaryStage.setTitle("Durak-Spiel");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
