/**
 * Created by shahbazkhan on 11/30/15.
 */
import java.sql.*;
public class Books {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/Books";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "brolly91";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating database...");
            stmt = conn.createStatement();

//            String sql = "CREATE DATABASE Books";
//            stmt.executeUpdate(sql);
//            System.out.println("Database created successfully...");

            System.out.println("Creating a table");

            
            String table3 = "CREATE TABLE AUTHORS " +
                    "(authorID INTEGER not NULL, " +
                    " firstName VARCHAR(255), " +
                    " lastName VARCHAR(255), " +
                    " PRIMARY KEY ( authorID ))";

            stmt.executeUpdate(table3);
            System.out.println("Created 'authors' table in given database...");

            String table2 = "CREATE TABLE PUBLISHERS " +
                    "(publisherID INTEGER not NULL, " +
                    " publisherName CHAR(100), " +
                    " PRIMARY KEY ( publisherID )) ";
            stmt.executeUpdate(table2);
            System.out.println("Created 'publishers' table...");

            String table4 = "CREATE TABLE TITLES " +
                    "(isbn CHAR(10), " +
                    " title VARCHAR(100), " +
                    " editionNumber INTEGER, " +
                    " copyright CHAR(4), " +
                    " publisherID INTEGER, " +
                    " price FLOAT, " +
                    " PRIMARY KEY ( isbn ), " +
                    " FOREIGN KEY ( publisherID )REFERENCES publishers( publisherID ))";
            stmt.executeUpdate(table4);
            System.out.println("Created 'titles' table...");







        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}//end JDBCExample

