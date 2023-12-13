package dao;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Category;
import model.Product;

import java.sql.*;
public class DbConnectivityClass {

    final static String DB_NAME = "CSC311_BD_TEMP";
    service.MyLogger lg = new service.MyLogger();
    final static String SQL_SERVER_URL = "jdbc:mysql://csc311.database.windows.net/";
    final static String DB_URL = "jdbc:mysql://csc311.database.windows.net/" + DB_NAME;
    final static String USERNAME = "CSCAdmin@serverAdmin";
    final static String PASSWORD = "adminpassworD!";

    private final ObservableList<Product> data = FXCollections.observableArrayList();

    public ObservableList<Product> getData() {
        connectToDatabase();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM products ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                lg.makeLog("No data");
            }
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String picture = resultSet.getString("picture");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                boolean availability = resultSet.getBoolean("availability");
                int stockQuantity = resultSet.getInt("stockQuantity");
                String category = resultSet.getString("category");

                // Convert the string to the corresponding Category enum
                Category category1 = Category.valueOf(category);

                data.add(new Product(id,name, picture, price, description, availability, stockQuantity, category1));
            }
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public boolean connectToDatabase() {
        boolean hasRegisteredProducts = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(SQL_SERVER_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME + "");
            statement.close();
            conn.close();

            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS products ("
                    + "id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "name VARCHAR(200) NOT NULL,"
                    + "picture VARCHAR(200) NOT NULL,"
                    + "price DOUBLE NOT NULL,"
                    + "description VARCHAR(200) NOT NULL,"
                    + "availability BOOLEAN NOT NULL,"
                    + "stockQuantity INT NOT NULL,"
                    + "category VARCHAR(200) NOT NULL)";
            statement.executeUpdate(sql);

            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM products");

            if (resultSet.next()) {
                int numProducts = resultSet.getInt(1);
                if (numProducts > 0) {
                    hasRegisteredProducts = true;
                }
            }

            statement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hasRegisteredProducts;
    }

    // Add more methods for other database operations (insert, update, delete) as needed
}
