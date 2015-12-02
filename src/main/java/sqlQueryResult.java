/**
 * Created by shahbazkhan on 11/30/15.
 *
 *  This is an Helper class which is Used to call JDBC functions
 */
import java.sql.*;
public class sqlQueryResult {

    public static String JDBCURL;

    public static String user;

    public static String pass;

    public static ResultSet rset;

    public sqlQueryResult(String url, String user, String pass) {
        this.JDBCURL = url;
        this.user = user;
        this.pass = pass;
    }

    // This Function returns a tables
    public ResultSet getResultSet(String query) {
        try {
            //  We Connect to the MYSQL OBJECT
            Connection conn = DriverManager.getConnection(
                    JDBCURL, user, pass); // MySQL

            // Initialize a STATEMENT
            Statement stmt = conn.createStatement();


            rset = stmt.executeQuery(query);


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rset;
    }

    // This functions update or edits a Table
    public void setResult(String query) {
        try {
            //  We Connect to the MYSQL OBJECT
            Connection conn = DriverManager.getConnection(
                    JDBCURL, user, pass); // MySQL

            // Initialize a STATEMENT
            Statement stmt = conn.createStatement();

            stmt.execute(query);


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
