module id.ac.ukdw.www.rplbo.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens id.ac.ukdw.www.rplbo.demo to javafx.fxml;
    exports id.ac.ukdw.www.rplbo.demo;
}