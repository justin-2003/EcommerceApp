package com.example.ecommerceapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Product;

public class MainController {
    @FXML
    private TextField productNameField;

    @FXML
    private TextField productPriceField;

    @FXML
    private TableView<Product> productTableView;

    // You might have more fields like product description, quantity, etc.

    @FXML
    MenuBar menuBar;
    private ObservableList<Product> productList;

    @FXML
    private void initialize() {
        // Initialize your controller, load data, etc.
        productList = FXCollections.observableArrayList();
        // You can set up the columns in the TableView here
        // For example, productTableView.setItems(productList);
    }

    @FXML
    private void addToCart(ActionEvent event) {
        // Implement the addToCart functionality here
        String productName = productNameField.getText();
        double productPrice = Double.parseDouble(productPriceField.getText());

        // Create a new Product instance and add it to the list
        Product product = new Product();
        productList.add(product);

        // Clear the input fields
        productNameField.clear();
        productPriceField.clear();
    }

    public void viewProductDetails(MouseEvent mouseEvent) {
    }
    public void lightTheme(ActionEvent actionEvent) {
        try {
            Scene scene = menuBar.getScene();
            Stage stage = (Stage) scene.getWindow();
            stage.getScene().getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/css/lightTheme.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
            System.out.println("light " + scene.getStylesheets());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void darkTheme(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) menuBar.getScene().getWindow();
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource("/css/darkTheme.css").toExternalForm());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // You might have more methods for handling UI actions, such as viewProductDetails, etc.
}