
import java.sql.Connection;
import java.sql.DriverManager ;
import java.sql.SQLException;
import java.sql.Statement;


public class Data_Insert {
    
    private static final String url = "jdbc:mysql://127.0.0.1:3306/jdbc_sql" ;
    private static final String username = "root" ;
    private static final String password = "shivam1234";

    public static void main (String[] args){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");


        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());

        }

        try {
            Connection connection = DriverManager.getConnection(url,username, password);
            Statement statement = connection.createStatement();

            // DIFFERENCE 

            String Query = String.format("INSERT INTO students (name,age,marks) VALUES ('%s', %o, %f)" , "Puja", 21, 91.6);
            int rowsAffected = statement.executeUpdate(Query);      // .exectueUpdate krne pe ye hume deta hai ki kitne rows affect hue hai 
            
            if (rowsAffected > 0 ){
                System.out.println("Data Inserted Successfully !! ");
            }
            else {
                System.out.println("Data Not Inserted ! ");
            }
        } catch (SQLException e) {
        }}

    }

