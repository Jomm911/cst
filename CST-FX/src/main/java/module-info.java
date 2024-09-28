module com.example.cstfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;

    opens com.example.cstfx to javafx.fxml;
    exports com.example.cstfx;
}