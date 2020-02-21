/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findmycar_server;

import java.sql.*;

public class DatabaseConnection {

    private Connection con;
    private String address = "192.168.1.21";
    private String port = "3306";
    private String db = "findmycar_db";
    private String dbUserName = "user";
    private String dbPassword = "userpsw001";

    public DatabaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DatabaseConnection(String address, String port, String db, String dbUserName, String dbPassword) {
        this.address = address;
        this.port = port;
        this.db = db;
        this.dbUserName = dbUserName;
        this.dbPassword = dbPassword;
        
            try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getDbserName() {
        return dbUserName;
    }

    public void setDbUserName(String userName) {
        this.dbUserName = userName;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String password) {
        this.dbPassword = password;
    }

    public boolean startCon(){

        try {//"jdbc:mysql://localhost:port/db","usrname","password"
            con = DriverManager.getConnection("jdbc:mysql://" + address + ":" + port + "/" + db + "," + dbUserName + "," + dbPassword);
            return true;

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return false;
    }
    public void closeCon() {
        try {
            con.close();
        } catch (SQLException e) {
            //trova un modo per gestire a video questa eccezione
            e.printStackTrace();
        }
    }

    public boolean dbLogin(String usrName, String psw) {
        try {
            Statement stat = con.createStatement();
            ResultSet result = stat.executeQuery("SELECT username, password from user where username = '" + usrName + "' and password = '" + psw + "'");
            if (result.getRow() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //settare tutti i dati necessari per registrare l'utente
    public void dbRegister() {
        try {
            Statement stat = con.createStatement();
            stat.executeQuery("");
            /*
            scrivere il codice per la queri
             */

        } catch (SQLException e) {
            //trova un modo per gestire a video questa eccezione
            e.printStackTrace();
        }
    }
}