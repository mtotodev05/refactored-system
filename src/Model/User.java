/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;

/**
 *
 * @author Esperant
 */
public class User extends Base{
    
    private String username;
    private String password;
    
    public boolean addUser(String username,String password) throws SQLException{
        boolean success = true;
        String sql;
        try{
            getConnection();
            sql="INSERT INTO USER(Username,Password) VALUES(?,?)";
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            pst.setString(2,password);
            pst.executeUpdate();
            success=true;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            closeConnection();
        }        
        return success;
    }
    
    public boolean lookUpUsername(String username) throws SQLException{
        boolean success= true;
        String sql;
        try{
            getConnection();
            sql="SELECT * FROM USER WHERE Username=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            rst=pst.executeQuery();
            if(rst.next()){
                System.out.println("Username Found");
                success= true;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            closeConnection();
        }
       
        return success;
    }
    
}