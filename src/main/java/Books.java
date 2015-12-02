/**
 * Created by shahbazkhan on 11/30/15.
 *  This is the main class for the JDBC project.
 */
import java.sql.*;
public class Books {

    // The Driver and the Database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "brolly91";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{

            // We initialize the MYSQL database with the JDBC drivers here

            // We Register the JDBC driver
            Class.forName(JDBC_DRIVER);

            //We Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute a query
            System.out.println("Creating database...");
            stmt = conn.createStatement();

            // Just trying to confirm that we don't get an Database exists error
           // stmt.execute("DROP DATABASE books");

            // We Create the Books database
            String sql = "CREATE DATABASE books";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");

            // We establish a Connection to the database with JDBC
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books" , USER , PASS);
            Statement myStmt = myConn.createStatement();

            // Using the Table Generator class to generate our tables
            tableGenerator tabGen= new tableGenerator(myStmt,myConn);

            // Create and initialize the tables with random values
            tabGen.createTable();
            tabGen.autoPopulate();
            System.out.println();
            System.out.println();



            /**
             *   All of the queries are listed below
             */


            // Select all authors from the authors table. Order the information
            // alphabetically by the author’s last name and first name.

            sqlQueryResult queryPrinter = new sqlQueryResult(DB_URL , USER , PASS);

            ResultSet query1 = queryPrinter.getResultSet("SELECT * FROM Books.authors ORDER BY last DESC");

            System.out.println("For the query: Select all authors from the authors table. Order the information\n" +
                    "alphabetically by the author’s last name and first name");
            System.out.println();
            System.out.println("The records selected are:");
            System.out.println();
            int rowCount = 0;
            System.out.println("AuthorID" + ", " + "First" + ", " + "Last");
            while(query1.next()) {   // Move the cursor to the next row
                int id = query1.getInt("authorID");
                String first = query1.getString("first");
                String last = query1.getString("last");
                System.out.println(id + ", " + first + ", " + last);
                ++rowCount;
            }
            System.out.println();
            System.out.println();


            // Select all publishers from the publishers table

            ResultSet query2 = queryPrinter.getResultSet("SELECT * FROM Books.publishers");

            System.out.println("For the query: Select all publishers from the publishers table");
            System.out.println();
            System.out.println("The records selected are:");
            System.out.println();

            System.out.println("publisherID" + ", " + "publisherName");
            while(query2.next()) {   // Move the cursor to the next row
                int id = query2.getInt("publisherID");
                String publisherName = query2.getString("publisherName");
                System.out.println(id + ", " + publisherName);
                ++rowCount;
            }
            System.out.println();
            System.out.println();


            // Select a specific publisher and list all books published by that
            // publisher. Include the title, year and ISBN number. Order the information alphabetically by title.

            System.out.println("For the query: Select a specific publisher and list all books published by that\n" +
                    "publisher. Include the title, year and ISBN number. Order the information alphabetically by title");
            System.out.println();
            System.out.println("The records selected are:");
            System.out.println();
            for(int i =1; i<15; i++){
                ResultSet query3 = queryPrinter.getResultSet("SELECT isbn, title, copyright FROM books.titles WHERE publisherID ="+i+"");
                while(query3.next()){
                    System.out.println(query3.getString("isbn") + " , " +  query3.getString("title") + " , " +  query3.getString("copyright"));
                }

            }
            System.out.println();
            System.out.println();



            // Add new author

            queryPrinter.setResult("INSERT INTO books.authors (first, last) VALUES ('Shahbaz', 'Khan');");
            // Print out author table with the recently added Author
            System.out.println("For the query: Add new author");
            System.out.println();
            System.out.println("The records selected are:");
            System.out.println();

            ResultSet query4 = queryPrinter.getResultSet("SELECT * FROM Books.authors");

            System.out.println("For the addition: We print out authors table after the additon");
            System.out.println();
            System.out.println("The updated records are:");
            System.out.println();
            int rowCount1 = 0;
            System.out.println("AuthorID" + ", " + "First" + ", " + "Last");
            while(query4.next()) {   // Move the cursor to the next row
                int id = query4.getInt("authorID");
                String first = query4.getString("first");
                String last = query4.getString("last");
                System.out.println(id + ", " + first + ", " + last);
                ++rowCount1;
            }
            System.out.println();
            System.out.println();


            // Edit/Update the existing information about an author
            queryPrinter.setResult("UPDATE books.authors SET first = \"Johnny\" WHERE authorID = 1");

            // Print out Author table with updated value
            ResultSet query5 = queryPrinter.getResultSet("SELECT * FROM Books.authors");

            System.out.println("For the update: Edit/Update the existing information about an author");
            System.out.println();
            System.out.println("The updated records are:");
            System.out.println();
            int rowCount2 = 0;
            System.out.println("AuthorID" + ", " + "First" + ", " + "Last");
            while(query5.next()) {   // Move the cursor to the next row
                int id = query5.getInt("authorID");
                String first = query5.getString("first");
                String last = query5.getString("last");
                System.out.println(id + ", " + first + ", " + last);
                ++rowCount1;
            }
            System.out.println();
            System.out.println();


            // Add a new title for an author

            queryPrinter.setResult("INSERT INTO books.titles (isbn, title, editionNumber, price)\n" +
                    " VALUES (\"890809809\",\"Book\", \"1234\", \"50\");");

            System.out.println("For the update: Add a new title for an author");
            System.out.println();
            System.out.println("The updated records are:");
            System.out.println();
            System.out.println("The new title is now added");


            // Add new publisher

            queryPrinter.setResult("INSERT INTO books.publishers (publisherName) VALUES (\"Shahbaz\");");
            // Print out the publishers Table with the new publisher added.
            ResultSet query6 = queryPrinter.getResultSet("SELECT * FROM Books.publishers");

            System.out.println("For the addition: We print out publishers table after the addition");
            System.out.println();
            System.out.println("The updated records are:");
            System.out.println();


            System.out.println("publisherID" + ", " + "publisherName");
            while(query6.next()) {   // Move the cursor to the next row
                int id = query6.getInt("publisherID");
                String publisherName = query6.getString("publisherName");
                System.out.println(id + ", " + publisherName);
                ++rowCount;
            }
            System.out.println();
            System.out.println();


            // Edit/Update the existing information about a publishe
            queryPrinter.setResult("UPDATE books.publishers SET publisherName = \"Shahbazi\" WHERE publisherID = 1;");
            System.out.println("For the update: Edit/Update the existing information about an author");
            System.out.println();
            System.out.println("The updated records are:");
            System.out.println();
            // Print out the publishers table with the updated value
            ResultSet query7 = queryPrinter.getResultSet("SELECT * FROM Books.publishers");

            System.out.println("For the update: We print out publishers table after the addition");
            System.out.println();
            System.out.println("The updated records are:");
            System.out.println();


            System.out.println("publisherID" + ", " + "publisherName");
            while(query7.next()) {   // Move the cursor to the next row
                int id = query7.getInt("publisherID");
                String publisherName = query7.getString("publisherName");
                System.out.println(id + ", " + publisherName);
                ++rowCount;
            }



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
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("System END");
    }
}

