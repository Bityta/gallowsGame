package DataBase;

import java.sql.*;
import java.util.ArrayList;

import static DataBase.DatabaseValues.*;
import static Utils.Utils.readFile;

public class DatabaseFunction {
    public static void insertWord(){

        ArrayList<String> word = readFile();



            Connection conn = null;

            try {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);

                Statement st = conn.createStatement();
                Statement myStmt = conn.createStatement();



                    for (int i = 0; i < word.size(); i++) {

                    String sql = "INSERT INTO mydb.word (id, word)" + " VALUES (" + (i+1) + ",'" + word.get(i) + "')";
                    myStmt.executeUpdate(sql);


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
