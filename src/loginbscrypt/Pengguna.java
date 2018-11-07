/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginbscrypt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Acer
 */
public class Pengguna {
    private String username, password;

    public Pengguna() {
    }

    public Pengguna(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public boolean cekLogin(){
        try{
            String sql = "SELECT * FROM tbpengguna WHERE username=?";
            PreparedStatement ps = Koneksi.getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.last();
            if(rs.getRow()==1){
                String passData = rs.getString(3);

                //match passwordinput and passwordindatabase
                if(BCrypt.checkpw(password, passData)){
                    //set session
                    //Session.setUsername(username);
                    //Session.setJabatan(rs.getString(4));
                    //return value true
                    return true;
                }
                else{
                    //record not found in database
                    return false;
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    
}
