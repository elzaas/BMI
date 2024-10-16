module org.example.calculator11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.calculator11 to javafx.fxml;
    exports org.example.calculator11;
}