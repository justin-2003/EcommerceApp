package com.example.ecommerceapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Product;

public class MainController {
    @FXML
    private TextField productNameField;

    @FXML
    private TextField productPriceField;

    @FXML
    private TableView<Product> productTableView;

    // You might have more fields like product description, quantity, etc.

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

    // You might have more methods for handling UI actions, such as viewProductDetails, etc.
}