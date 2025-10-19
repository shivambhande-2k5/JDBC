import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class main{

    private static final String url = "jdbc:mysql://127.0.0.1:3306/?user=root" ;
    private static final  String username = "root" ;
    private static final String password = "shivam123";

    public static void main(String[] args) {


        try {                                         // try block ke saath hamesha catch block likha hi hai 
            Class.forName("com.mysql.cj.jdbc.Driver");  // iska matlb hai com.mysql.cj mai drivers pade hai 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();   // OR  System.out.println(e.getMessage());
                                   // ye batata hai ki code kaha se kaha tak fata hai 
        }


        // CONNECTIONS 
         
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement() ;
            
        } catch (SQLException e) {

        System.out.println (e.getMessage());

        }
    
    }
    }
    
