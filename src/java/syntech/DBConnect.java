package syntech;
/**
 *
 * @author Weskoo
 */
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.ejb.Stateless;

@Stateless
public class DBConnect {

    public static Connection serverConnect() throws ClassNotFoundException, SQLException
    {
        //set connection
        System.setProperty("javax.xml.accessExternalDTD", "all");
        Connection con=null;
        
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/webtest?","root","");
         
       return con;
    }
 
}