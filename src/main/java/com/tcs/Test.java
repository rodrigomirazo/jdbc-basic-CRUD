package com.tcs;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CRUDutility crudUtility = new CRUDutility();

        System.out.println(
                "\nGet Users: \n " +
                crudUtility.getPerson()
        );

        System.out.println(
                "\nUpdate User with id=1:\n" +
                        crudUtility.updatePerson(1, "MyUserName", "Rodrigo", "Mirazo")
        );

        System.out.println(
                "\nGet Users:" +
                        crudUtility.getPerson()
        );


        System.out.println(
                "\nInsert User: \n " +
                        crudUtility.createPerson("newUserCreated", "name1", "lastname1")
        );

        System.out.println(
                "\nGet Users:" +
                        crudUtility.getPerson()
        );

        crudUtility.deletePerson(4);

        crudUtility.close();
    }
}
