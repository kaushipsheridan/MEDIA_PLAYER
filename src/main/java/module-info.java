module com.example.randomaccessfiles {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.randomaccessfiles to javafx.fxml;
    exports com.example.randomaccessfiles;
}