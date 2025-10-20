
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Retrive_data {
    
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
            
            Connection connection = DriverManager.getConnection(url, username ,password);

            String query = "SELECT marks FROM students WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble (1,1);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                double marks = resultSet.getDouble("marks");
                System.out.println("Marks : " + marks);
            }else {
                System.out.println("Marks not Found ! ");
            }


            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
