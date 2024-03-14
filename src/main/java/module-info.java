module com.example.lr1fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lr1fx to javafx.fxml;
    exports com.example.lr1fx;
    exports com.example.lr1fx.workstation;
    opens com.example.lr1fx.workstation to javafx.fxml;
}