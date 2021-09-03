import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.sql.Statement;  
   
public class CreateTable {  
   
    public static void createNewTable() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C://sqlite/Moviesdata.db";  
          
        String sql = "CREATE TABLE MOVIEDETAILS (\n"
        		+"MovieName Text NOT NULL,\n" 
                + "  LActor text NOT NULL,\n"  
                + " FemaleActoressName text NOT NULL,\n"  
                + " DirectorName text NOT NULL,\n"  
                + "Year NOT NULL);";  
          
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            stmt.execute(sql);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    public static void main(String[] args) {  
        createNewTable();  
    }  
   
}  