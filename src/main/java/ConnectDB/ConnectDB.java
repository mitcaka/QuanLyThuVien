/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ADMIN
 */
public class ConnectDB {
    public static Connection getConnection()
    {
        String userid = "root";
        String pass = "";
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/qlthuvien?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf8";
            conn = DriverManager.getConnection(dbURL, userid, pass);
        } catch (Exception ex) {
            System.out.println("Loi ket noi"+ ex.getMessage());
        }
        return conn;
    }
}
