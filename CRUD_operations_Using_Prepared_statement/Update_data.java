
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update_data {
    
    private static final String url = "jdbc:mysql://127.0.0.1:3306/jdbc_sql";
    private static final String username = "root";
    private static final String password = "shivam1234";
    
    public static void main (String[] args){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            Connection connection = DriverManager.getConnection(url,username, password);
            String Update_Query = "UPDATE students SET name = ? WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(Update_Query);
            preparedStatement.setString( 1 , "Puja");
            preparedStatement.setInt (2, 3);

            int rowAffected = preparedStatement.executeUpdate();
            
            if (rowAffected>0){
                System.out.println("DATA UPDATED");

            }else {
                System.out.println("Data update failed");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }}
    }

