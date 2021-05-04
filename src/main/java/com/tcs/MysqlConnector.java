package com.tcs;

import java.sql.*;

public class MysqlConnector {

    public Connection connector() throws ClassNotFoundException, SQLException {
        //step1 load the driver class
        Class.forName("com.mysql.cj.jdbc.Driver");

        //step2 create  the connection object
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root12345");

        return con;
    }

    public void closeConnector(Connection con) throws SQLException {

        //step5 close the connection object
        con.close();
    }

    public static void main(String args[]) {
        try {
            //step1 load the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            //step2 create  the connection object
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root12345");

            //step3 create the statement object
            Statement stmt = con.createStatement();

            //step4 execute query
            ResultSet rs = stmt.executeQuery("SELECT * FROM trainee_schema.trainee_user;");
            while(rs.next()) {
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            }

            //step5 close the connection object
            con.close();

        } catch(Exception e) {
            System.out.println(e);
        }

    }
}