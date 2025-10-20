
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete_date {
    
    private static final String url = "jdbc:mysql://127.0.0.1:3306/jdbc_sql" ;
    private static final String username = "root" ;
    private static final String password = "shivam1234" ;

    public static void main (String [] args ){

        try {
            Class.forName ("com.mysql.cj.jdbc.Driver");

        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt (1, 4);
            
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0){
                System.out.println("Data deleted !");
            }else {
                System.out.println("Data not Deleted !");
            }
            
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
    }

}
