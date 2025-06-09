package Anzeige;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class EndLost extends Application{

    private Stage primaryStage;
    private Startscreen startScrn;

    @Override
    public void start(Stage primStage){

        primaryStage = primStage;

        //button
        Button back = new Button("PLAY AGAIN");
        back.setPrefSize(400, 100);
        back.setAlignment(Pos.CENTER);

        //Buttondesign
        back.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-background-color: #1d7435; -fx-border-width: 6px; -fx-border-color: #c0e10e");

        //erstellen + design des labels
        Label nachricht = new Label("Durak!");
        nachricht.setStyle("-fx-font-size: 64px; -fx-font-weight: bold; -fx-text-fill: black;");

        //ich erstelle pane + hbox
        BorderPane grund = new BorderPane();
        HBox againButton = new HBox(back);
        againButton.setPadding(new Insets(0, 0, 40, 0));
        HBox text = new HBox(nachricht);

        //Hintergrund
        BackgroundImage backImg = new BackgroundImage(new Image(getClass().getResourceAsStream("/BilderProjekt/PokerTable.jpg")),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        //nachrichtbearbeitung
        text.setAlignment(Pos.CENTER);
        againButton.setAlignment(Pos.CENTER);

        //Buttonfunktion
        back.setOnAction(e -> {
            startScrn = new Startscreen();
            try {
                startScrn.start(new Stage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            primaryStage.close();
        });

        //einfuegen in borderpane
        grund.setBackground(new Background(backImg));
        grund.setTop(new Region());
        grund.setCenter(text);
        grund.setLeft(new Region());
        grund.setRight(new Region());
        grund.setBottom(againButton);

        //scene + weitere Sachen
        Scene scene = new Scene(grund);
        primaryStage.setTitle("Durak-Spiel");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
