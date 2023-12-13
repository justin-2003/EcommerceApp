module com.example.ecommerceapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;
    requires java.sql;


    opens com.example.ecommerceapp to javafx.fxml;
    exports com.example.ecommerceapp;
}