import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksiDB 
{
    public Connection getKoneksi() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        
        String url = "jdbc:mysql://localhost/datamahasiswa"; 
        
        Connection con = DriverManager.getConnection(url, "root", "");
       
        
        return con;
    }
}
