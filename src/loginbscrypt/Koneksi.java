/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginbscrypt;

import java.sql.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class Koneksi {
    private static Connection koneksi;
    public static String database = "latihan";
    public static String host = "localhost";
    public static String user = "root";
    public static String pass = "";
    
    public static Connection getConnection() throws SQLException{
        if(koneksi==null){
             new Driver();
             koneksi = DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+database+"?zeroDateTimeBehavior=convertToNull", user, pass);
        }
        return koneksi;
    }
}
