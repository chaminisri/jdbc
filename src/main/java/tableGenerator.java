/**
 * Created by shahbazkhan on 11/30/15.
 */

import java.sql.*;
public class tableGenerator {
    Statement stMt;
    Connection coNN;
    public tableGenerator(Statement stmt, Connection conn) {
        stMt=stmt;
        coNN=conn;
    }
    public void createTable(){
         /* String sql1 = "CREATE TABLE AUTHOR " +
                  "(id INTEGER not NULL, " +
                  " first VARCHAR(255), " +
                  " last VARCHAR(255), " +
                  " age INTEGER, " +
                  " PRIMARY KEY ( id ))"; */

        String sql1="CREATE TABLE authors "
                + "(authorID INTEGER not NULL, "
                + " first VARCHAR(255), "
                + " last VARCHAR(255), "
                + " PRIMARY KEY ( authorID ))";

        String sql4="CREATE TABLE authorISBN "
                + "(authorID INT, "
                + "isbn CHAR(10), "
                + "FOREIGN KEY ( authorID )REFERENCES authors( authorID ), "
                + "FOREIGN KEY ( isbn )REFERENCES titles( isbn ))";

        String sql2="CREATE TABLE publishers "
                + "(publisherID INTEGER, "
                + " publisherName char(100), "
                + " PRIMARY KEY ( publisherID))";

        String sql3="CREATE TABLE titles "
                + "(isbn CHAR(10), "
                + " title VARCHAR(500), "
                + " editionNumber INTEGER, "
                + " copyright CHAR(4), "
                + " publisherID INTEGER, "
                + " price FLOAT, "
                + " PRIMARY KEY ( isbn ), "
                + " FOREIGN KEY ( publisherID )REFERENCES publishers( publisherID ))";
        try{
            stMt.executeUpdate(sql1);
            stMt.executeUpdate(sql2);
            stMt.executeUpdate(sql3);
            stMt.executeUpdate(sql4);
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }

    }
}
