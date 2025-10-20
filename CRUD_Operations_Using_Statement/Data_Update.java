
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Data_Update {
    
    private static final String url = "jdbc:mysql://127.0.0.1:3306/jdbc_sql";
    private static final String username = "root" ;
    private static final String password = "shivam1234" ;
 
    public static void main (String[] args){

        try {
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            String Query = String.format(" UPDATE students SET marks = %f WHERE id =%o", 95.0 , 2);
            int rowsAffected = statement.executeUpdate(Query);

            if (rowsAffected > 0 ){
                System.out.println(" Data Updated Successfully ");
            }else {
                System.out.println("Data Update failed !");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
