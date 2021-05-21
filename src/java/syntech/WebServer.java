package syntech;
/**
 *
 * @author Weskoo
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "WebServer")
public class WebServer {
    Connection con;

    public WebServer() throws ClassNotFoundException, SQLException {
        this.con = DBConnect.serverConnect();
    }
 
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    //this is a simple 'INSERT' web service operation
    @WebMethod(operationName = "insert")
    public void insert(@WebParam(name = "id") String id, @WebParam(name = "name") String name) {

         try {
            String sq="INSERT INTO `test`(`id`, `name`) VALUES ('"+id+"','"+name+"')";
            PreparedStatement pst=con.prepareStatement(sq);
            pst.execute();
        
        } catch (Exception e) {
          
        }   
    }
    
    //this is a simple 'UPDATE' web service operation
    @WebMethod(operationName = "update")
    public void update(@WebParam(name = "id") String id, @WebParam(name = "name") String name ) {

        try {
            String squpdate = "UPDATE test SET name='"+name+"' where id='"+id+"'";
            PreparedStatement pst=con.prepareStatement(squpdate);
            pst.execute();
        } catch (Exception e) {
            
        }  
    }
    
    //this is a simple 'DELETE' web service operation
    @WebMethod(operationName = "delete")
    public void delete(@WebParam(name = "id") String id) {

        try {
         
            String sql="DELETE FROM test where id='"+ id +"'";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.execute();
         
        } catch (Exception e) {
            
        }
       
    }
 
}