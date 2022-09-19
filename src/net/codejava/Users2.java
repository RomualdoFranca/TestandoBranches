package net.codejava;

import java.sql.*;
import java.util.Scanner;

public class Users2 {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        String jdbcURL = "jdbc:mysql://localhost:3306/simpleCrud";
        String dbUserName = "root";
        String dbPassword = "PuG@10%92";

        Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassword);

//      Atualizando BD sem Scanner
        String username = "Lua";
        String password = "peludos";
        String fullname = "Lua Lora";
        String email = "lua@email.com";

        String sql = "INSERT INTO users (username, password, fullname, email)" +
                "VALUES(?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        statement.setString(3, fullname);
        statement.setString(4, email);

        int rows =  statement.executeUpdate();

        if (rows > 0) {
            System.out.println("A new user has been inserted successfully");
        }

        connection.close();
        scanner.close();


//        if (connection != null) {
//            System.out.println("Connected to the database");
//        }
    }
}
