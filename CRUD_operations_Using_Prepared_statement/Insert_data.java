
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException ;


public class Insert_data {
    
    private static final String url = "jdbc:mysql://127.0.0.1:3306/jdbc_sql";
    private static final String username = "root";
    private static final String password = "shivam1234";
    public static void main (String [] args){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            String Query = " INSERT INTO students(name,age,marks) VALUES (? , ? , ?)";  
            PreparedStatement preparedStatement = connection.prepareStatement(Query);  // Querye ko yaha pe dalte hai 

            preparedStatement.setString(1, "Shri");
            preparedStatement.setInt(2 , 22);
            preparedStatement.setDouble (3 , 80);

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected >0 ){
                System.out.println("DATA INSERTED SUCCESSFULLY ");
            }else {
                System.out.println("DATA INSERT FAILED ! ");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
