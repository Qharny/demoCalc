module com.example.democalc {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.example.democalc to javafx.fxml;
    exports com.example.democalc;
}