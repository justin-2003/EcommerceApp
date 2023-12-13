package com.example.ecommerceapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Objects;

public class LoginController {

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField passwordField;


    @FXML
    private GridPane rootpane;


    @FXML
    public void initialize(){
        emailTextField = new TextField();
        passwordField = new TextField();

        emailTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                emailTextField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
            } else {
                emailTextField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
            }
        });

        passwordField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() < 3 || newValue.length() > 20) {
                passwordField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
            } else {
                passwordField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
            }
        });
    }
    @FXML
    public void login(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-page.fxml")));
            Scene scene = new Scene(root, 900, 600);
            //scene.getStylesheets().add(getClass().getResource("/css/lightTheme.css").toExternalForm());
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signUp(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("main-page.fxml"));
            Scene scene = new Scene(root, 900, 600);
            //scene.getStylesheets().add(getClass().getResource("/css/lightTheme.css").toExternalForm());
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

