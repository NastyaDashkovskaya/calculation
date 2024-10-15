module userinterface.userinterface {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens userinterface.userinterface to javafx.fxml;
    exports userinterface.userinterface;
}