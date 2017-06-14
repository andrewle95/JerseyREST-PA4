package com.uci.rest.service;

import com.uci.rest.db.DatabaseConnector;
import com.uci.rest.db.DatabaseUtils;
import com.uci.rest.model.Order;
import com.uci.rest.model.Todo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
	private final static String ALL_ORDERS_QUERY = "SELECT * FROM ORDERS";

    public static Order getOrderById(int id) {
        //Get a new connection object before going forward with the JDBC invocation.
        Connection connection = DatabaseConnector.getConnection();
        ResultSet resultSet = DatabaseUtils.retrieveQueryResults(connection, ALL_ORDERS_QUERY + " WHERE id = " + id);

        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    Order order = new Order();

                    order.setId(resultSet.getInt("id"));
                    order.setFirstName(resultSet.getString("firstname"));
                    order.setLastName(resultSet.getString("lastname"));
                    order.setPhoneNumber(resultSet.getString("phonenumber"));
                    order.setStreetAddress(resultSet.getString("streetaddress"));
                    order.setCity(resultSet.getString("city"));
                    order.setState(resultSet.getString("state"));
                    order.setZipCode(resultSet.getString("zipcode"));
                    order.setCreditCardNumber(resultSet.getString("creditcardnumber"));
                    order.setItems(resultSet.getString("items"));
                    order.setShippingMethod(resultSet.getString("shippingmethod"));


                    return order;

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
    
    public static boolean AddOrder(Order order) {

        String sql = "INSERT INTO ORDERS  (firstname, lastname, phonenumber, streetaddress, city, state, zipcode, creditcardnumber, items, shippingmethod)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConnector.getConnection();
        return DatabaseUtils.performDBUpdate(connection, sql, order.getFirstName(), order.getLastName(), order.getPhoneNumber(), order.getStreetAddress(), order.getCity(), order.getState(), order.getZipCode(), order.getCreditCardNumber(), order.getItems(), order.getShippingMethod());

    }
}
