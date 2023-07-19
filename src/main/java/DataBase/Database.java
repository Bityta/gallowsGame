package DataBase;

import static DataBase.DatabaseValues.USER;
import static DataBase.DatabaseValues.PASSWORD;
import static DataBase.DatabaseValues.URL;


import java.sql.*;


public class Database {


    public static void print() {

        Connection conn = null;



        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();


            ResultSet set = statement.executeQuery("SELECT * FROM word");


            while (set.next()) {
                System.out.print(set.getString("id") + ".");
                System.out.println(" " + set.getString("word"));
            }


        } catch (
                Exception e) {
            System.out.println("Error connection");
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }


}
