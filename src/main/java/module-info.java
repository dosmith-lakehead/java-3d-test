module com.example.test3d {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.test3d to javafx.fxml;
    exports com.example.test3d;
}