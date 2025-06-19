package Anzeige;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Cardchoice extends Application{

    private Stage primaryStage;
    private Game game;
    private UnderConstruction constr;

    @Override
    public void start(Stage primStage){
        primaryStage = primStage;

        //wichtiges
        BorderPane kartenwahl = new BorderPane();
        HBox mogl = new HBox();
        mogl.setSpacing(60);
        mogl.setAlignment(Pos.CENTER);

        //Bilder erzeugen
        BackgroundImage backImg = new BackgroundImage(new Image(getClass().getResourceAsStream("/BilderProjekt/PokerTable.jpg")),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        Image bild1 = new Image(getClass().getResourceAsStream("/BilderProjekt/DiamondsKing.png"), 2000, 2800, true, true);
        ImageView bildView1 = new ImageView(bild1);
        bildView1.setFitWidth(200);
        bildView1.setFitHeight(280);
        bildView1.setPreserveRatio(true);

        //Image bild2 = new Image(getClass().getResourceAsStream("/BilderProjekt/clubsacebetter.png"), 2500, 2500, true, true);
        Image bild2 = new Image(Cardchoice.class.getResourceAsStream("/BilderProjekt/clubsacebetter.png"));
        ImageView bildView2 = new ImageView(bild2);
        bildView2.setFitWidth(200);
        bildView2.setFitHeight(280);
        bildView2.setPreserveRatio(true);

        //Buttons
        Button card1 = new Button();
        Button card2 = new Button();

        //Buttondesign
        card1.setMinSize(200, 280);
        card1.setGraphic(bildView1);

        card2.setMinSize(200, 280);
        card2.setGraphic(bildView2);

        //Buttonfunktion
        card1.setOnAction(e -> {
            game = new Game();
            try{
                game.start(new Stage());
            }catch(Exception exception){
                exception.printStackTrace();
            }
            primaryStage.close();
        });

        card2.setOnAction(e -> {
            constr = new UnderConstruction();
            try{
                constr.start(new Stage());
            }catch(Exception exception){
                exception.printStackTrace();
            }
            primaryStage.close();
        });

        //einfügen in HBox
        mogl.getChildren().addAll(card1, card2);

        //einfügen in borderpane
        kartenwahl.setBackground(new Background(backImg));
        kartenwahl.setTop(new Region());
        kartenwahl.setCenter(mogl);
        kartenwahl.setLeft(new Region());
        kartenwahl.setRight(new Region());
        kartenwahl.setBottom(new Region());

        //einfügen in stage
        Scene scene = new Scene(kartenwahl);
        primaryStage.setTitle("Durak-Spiel");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
