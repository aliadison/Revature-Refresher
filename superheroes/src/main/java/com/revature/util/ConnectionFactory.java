package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ConnectionFactory {
   
    private static Connection connection = null;

    
    private ConnectionFactory() {

    }
    
    public static Connection getConnection() {
        if(connection == null) {
           
            ResourceBundle bundle = ResourceBundle.getBundle("DbConfig");
           
            String url = bundle.getString("url");
            String user = bundle.getString("username");
            String password = bundle.getString("password");
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch(SQLException exception) {
                exception.printStackTrace();
            }
        }
 
        return connection;
    }
}
