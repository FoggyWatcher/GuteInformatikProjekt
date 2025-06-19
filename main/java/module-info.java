module org.example.durakspiel {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.smartcardio;

    opens org.example.durakspiel to javafx.fxml;
    exports org.example.durakspiel;
    exports Anzeige;
}