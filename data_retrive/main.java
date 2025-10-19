
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class main{

    private static final String url = "jdbc:mysql://127.0.0.1:3306/jdbc_sql" ;
    private static final  String username = "root" ;
    private static final String password = "shivam1234";

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
            Statement statement =  connection.createStatement() ;
            String query =" SELECT * FROM students" ;        // QUERY LIKHNA 
            ResultSet resultset = statement.executeQuery(query);    // Jb bhi database se data lena ho tab (statement.executeQuery();) Use krna hota hai 
                                                                    // Jb koi CRUD Operation perform krna ho tb (statement.executeUpdate();) USe krte hai 
            /*
             ResultSet ke instance mai iss table ko Hold kiya hai.
             Hold krna matlab : upar ki query ka output dega jo bhi milega uspe Operation perform krne ke liye resultset
             instance mai save kiya hai  
            */         

            while (resultset.next()) {              // Ye while loop hume table ki rows ka output one by one dega
                                                    // resultset.next() iska matlb hai ye ek boolean return krega jo bataega
                                                    // ki table koi row bachi hai ya fir nhi 
                                                            
                int id = resultset.getInt("id");
                String name = resultset.getString("name");
                int age = resultset.getInt("age");
                double marks = resultset.getDouble("marks");

                System.out.println("ID : " + id);
                System.out.println("NAME : " + name);
                System.out.println("AGE : " + age);
                System.out.println("MARKS : " + marks);

            }              
        } catch (SQLException e) {

        System.out.println (e.getMessage());

        }
    
    }
    }
    
