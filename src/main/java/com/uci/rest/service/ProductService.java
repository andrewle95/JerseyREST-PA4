package com.uci.rest.service;

import com.uci.rest.db.DatabaseConnector;
import com.uci.rest.db.DatabaseUtils;
import com.uci.rest.model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
	private final static String ALL_PRODUCTS_QUERY = "SELECT * FROM PRODUCTS";

    public static Product getProductById(int id) {
        //Get a new connection object before going forward with the JDBC invocation.
        Connection connection = DatabaseConnector.getConnection();
        ResultSet resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_PRODUCTS_QUERY + " WHERE id = " + id);

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    Product product = new Product();
                    
                    product.setId(resultSet.getInt("id"));
                    product.setProductName(resultSet.getString("productname"));
                    product.setProductPrice(resultSet.getString("productprice"));
                    product.setProductPicture(resultSet.getString("productpicture"));
                    product.setBrand(resultSet.getString("brand"));
                    product.setColor(resultSet.getString("color"));
                    product.setFrameMaterial(resultSet.getString("framematerial"));
                    product.setLensMaterial(resultSet.getString("lensmaterial"));
                    product.setFit(resultSet.getString("fit"));
                    product.setStyle(resultSet.getString("style"));



                    return product;

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {

                    // We will always close the connection once we are done interacting with the Database.
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;


    }

    public static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();

        Connection connection = DatabaseConnector.getConnection();
        ResultSet resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_PRODUCTS_QUERY);

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    Product product = new Product();
                    
                    product.setId(resultSet.getInt("id"));
                    product.setProductName(resultSet.getString("productname"));
                    product.setProductPrice(resultSet.getString("productprice"));
                    product.setProductPicture(resultSet.getString("productpicture"));
                    product.setBrand(resultSet.getString("brand"));
                    product.setColor(resultSet.getString("color"));
                    product.setFrameMaterial(resultSet.getString("framematerial"));
                    product.setLensMaterial(resultSet.getString("lensmaterial"));
                    product.setFit(resultSet.getString("fit"));
                    product.setStyle(resultSet.getString("style"));

                    products.add(product);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return products;
    }
}
