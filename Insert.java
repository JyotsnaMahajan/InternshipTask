import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
   
public class Insert {  
   
    private static final String MovieName = null;

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
   
  
    public void insert(String LActor, String FemaleActoressName,String DirectorName,Date Year) {  
        String sql = "INSERT INTO MOVIEDETAILS(MovieName,LActor,FemaleActoressName,DirectorName,Year) VALUES(?,?,?,?,?)";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, MovieName);  
            pstmt.setString(1, LActor);  
            pstmt.setString(1, FemaleActoressName);  
            pstmt.setString(1, DirectorName);  
            pstmt.setDate(1,Year);
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    public static void main(String[] args) {  
   
        Insert app = new Insert();  
        app.insert("shershaah","sidharth malhotra","Kiara Advani","Vishnuvardhan","2021-08-12");  
        app.insert("Rustom","Akshay Kumar","Ileana D'Cruz\r\n" + "Tinu Suresh Desai\r\n" + "2016-08-12");  
      
    }


}  
