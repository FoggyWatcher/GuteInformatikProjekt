package Anzeige;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;;

public class Game extends Application{
    private Stage primaryStage;

    @Override
    public void start(Stage primStage) {
        primaryStage = primStage;
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 650, 650);
        Image img = new Image(getClass().getResourceAsStream("/BilderProjekt/PokerTable.jpg"));
        BackgroundImage backImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background backGround = new Background(backImg);
        root.setBackground(backGround);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Durak-Spiel");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}