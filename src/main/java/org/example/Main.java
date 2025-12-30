package org.example;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    static void main(String[] args) {
        System.out.println("Demo dag 2");

        //Enda anslutningen
        Connection db = Database.getConnection();

        //statement har 2 metoder: executeQuery & executeUpdate
        try {
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery("SHOW DATABASES");

            System.out.println("---------");
            System.out.println("Databases:");

            //Iterator med .next
            while (rs.next()) {
                System.out.println(rs.getString("Database"));
            }

            String sql = "INSERT INTO Accounts (name, noOfEmployees, status) VALUES ( 'Panduro', 323, 'Customer')";
            int affectedRows = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("Affected rows " + affectedRows);

            ResultSet keys = stmt.getGeneratedKeys();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
