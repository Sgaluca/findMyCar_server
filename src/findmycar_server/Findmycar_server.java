/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findmycar_server;

/**
 *
 * @author sgalu
 */
public class Findmycar_server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    Server server = new Server(6789);
    server.waitConnection();
    //ciao
   
    }
    
}
