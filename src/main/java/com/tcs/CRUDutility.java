package com.tcs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CRUDutility {

    Connection con;
    MysqlConnector mysqlConnector = new MysqlConnector();

    public CRUDutility() throws SQLException, ClassNotFoundException {
        this.con = mysqlConnector.connector();
    }

    public void close() {
        try {
            mysqlConnector.closeConnector(con);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Get Person
     * @return
     * @throws SQLException
     */
    List<Person> getPerson() throws SQLException {

        //step 1 Declare Empty list of Persons
        List<Person> personList = new ArrayList<>();

        //step 2 create the statement object
        Statement stmt = con.createStatement();

        // Prepare your select Statement
        String select = "SELECT * FROM trainee_schema.trainee_user;";

        //step 3 execute select query
        ResultSet rs = stmt.executeQuery(select);
        while(rs.next()) {
            personList.add(new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }

        return personList;
    }


    /**
     * Add Person
     * @param userName
     * @param name
     * @param lastName
     * @return
     * @throws SQLException
     */
    Person createPerson(String userName, String name, String lastName) throws SQLException {

        //step 1 create the statement object
        Statement stmt = con.createStatement();

        //step 2 Prepare your select Statement
        String insert = " INSERT INTO `trainee_schema`.`trainee_user` (`username`, `name`, `lastname`) " +
                " VALUES " +
                " ('" + userName + "', '" + name + "', '" + lastName + "');";

        //step 3 execute insert query
        int result = stmt.executeUpdate(insert);

        //step 4 Preapre return statement
        Person person = new Person(result, userName, name, lastName);
        System.out.println("Record Inserted: (result="+result+") " + person.toString());
        return person;
    }


    /**
     * Upodate Person
     * @param id
     * @param userName
     * @param name
     * @param lastName
     * @return
     * @throws SQLException
     */
    Person updatePerson(int id, String userName, String name, String lastName) throws SQLException {

        //step 1 create the statement object
        Statement stmt = con.createStatement();

        //Step 2
        String update = " UPDATE `trainee_schema`.`trainee_user` SET " +
                " `username` = '" + userName + "', `name` = '"+name+"', `lastname` = '"+lastName+"' WHERE (`id` = '"+id+"'); ";

        //step 3 execute insert query
        int result = stmt.executeUpdate(update);

        //step 4 Preapre return statement
        Person person = new Person(id, userName, name, lastName);

        return person;
    }


    /**
     * Delete Person
     * @param id
     * @throws SQLException
     */
    void deletePerson(int id) throws SQLException {

        //step 1 create the statement object
        Statement stmt = con.createStatement();

        // setp 2 delete statement
        String delete = " DELETE FROM `trainee_schema`.`trainee_user` WHERE (`id` = '"+id+"'); ";

        //step 3 execute insert query
        int result = stmt.executeUpdate(delete);
    }
}
