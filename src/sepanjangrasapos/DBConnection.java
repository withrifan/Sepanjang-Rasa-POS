package sepanjangrasapos;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/sepanjangrasadb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
  
    
 //   public static ResultSet getStaffData() throws Exception { 
  //      Connection conn = getConnection(); 
  //      Statement stmt = conn.createStatement(); 
  //      String query = "SELECT * FROM tb_staff"; 
   //     return stmt.executeQuery(query); 
    //}
//}
