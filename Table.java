import java.sql.DriverManager;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
   
public class Table {  
   
    private Connection connect() {  
        String url = "jdbc:sqlite:C://sqlite/SSSIT.db";  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }  
   
  
    public void selectAll(){  
        String sql = "SELECT * FROM MOVIEDETAILS";  
          
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            while (rs.next()) {  
                System.out.println(rs.getString("MovieName") +  "\t" +   
                                   rs.getString("LActor") + "\t" +  
                                   rs.getString("FemaleActoressName")+"\t" +
                                   rs.getString("DirectorName")+"\t"+
                                   rs.getDate("Year")+"\t");  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  

    public void selectMovieName(){  
        String sql = "SELECT LActor , MovieName FROM MOVIEDETAILS ";  
          
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) {  
                System.out.println(rs.getString("LActor") +  "\t" +   
                                   rs.getString("MovieName") + "\n" );  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
      
     
   
    public static void main(String[] args) {  
        Table app = new Table();  
        app.selectAll();
        app.selectMovieName();
    }  
   
}  