package com.qlnv.connectSQL;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectMysql {

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlnv", "root",
                    "12345678");
            return connection;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.print("Ket noi that bai voi csdl");
            System.err.print(e.getMessage() + "\n" + e.getClass() + "\n" + e.getCause());
            e.printStackTrace();
        }
        return null;
    }
}