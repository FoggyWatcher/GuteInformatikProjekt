package Anzeige;

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Startscreen extends Application{

    private Cardchoice cardwahl;

    private Stage primaryStage;

    @Override
    public void start(Stage primStage){
        primaryStage = primStage;

        //alles wichtige
        BorderPane startbildschirm = new BorderPane();
        VBox anfang = new VBox();
        anfang.setSpacing(60);
        anfang.setAlignment(Pos.CENTER);

        //Hintergrund erzeugen
        BackgroundImage backImg= new BackgroundImage(new Image(getClass().getResourceAsStream("/BilderProjekt/PokerTable.jpg")),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        //Buttons
        Button play = new Button("PLAY");
        play.setPrefSize(400, 100);

        Button exit = new Button("EXIT");
        exit.setPrefSize(400, 100);

        //Buttondesign
        play.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-background-color: #1d7435; -fx-border-width: 6px; -fx-border-color: #c0e10e");
        exit.setStyle("-fx-font-size: 32px; -fx-font-weight: bold; -fx-background-color: #1d7435; -fx-border-width: 6px; -fx-border-color: #c0e10e");

        //Buttonfunktionen
        play.setOnAction(e -> {
            cardwahl = new Cardchoice();
            try{
                cardwahl.start(new Stage());
            }catch(Exception exception){
                exception.printStackTrace();
            }
            primaryStage.close();
        });

        exit.setOnAction(e -> {
            Platform.exit();
        });

        //einfügen in VBox
        anfang.getChildren().addAll(play, exit);

        //einfügen in borderpane
        startbildschirm.setBackground(new Background(backImg));
        startbildschirm.setTop(new Region());
        startbildschirm.setCenter(anfang);
        startbildschirm.setLeft(new Region());
        startbildschirm.setRight(new Region());
        startbildschirm.setBottom(new Region());

        //einfügen in stage
        Scene scene = new Scene(startbildschirm);
        primaryStage.setTitle("Durak-Spiel");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
