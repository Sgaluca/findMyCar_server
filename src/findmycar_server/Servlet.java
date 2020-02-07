/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findmycar_server;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
/**
 *
 * @author sgalu
 */
@Path("/findmycar")
@ApplicationPath("/resurces")
public class Servlet extends HttpServlet{
    
    @GET
    @Path("/sayHello")
    public String getHelloWordMsg(){
        return "Hello Word";
        
    }
}
