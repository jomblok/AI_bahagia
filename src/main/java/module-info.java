module id.ac.ukdw.www.rplbo.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens id.ac.ukdw.www.rplbo.demo to javafx.fxml;
    exports id.ac.ukdw.www.rplbo.demo;
}