/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import View.*;
import javax.swing.JOptionPane;
import Model.*;

/**
 *
 * @author brian-kamau
 */
public class NewUserController {
        static newAccountHandler accounts = new newAccountHandler();
        static NewUserV newUser = new NewUserV();
        static User usermodel = new User();
    
    
    
       static class newAccountHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
            String username = newUser.getUsername().getText();
            String password = newUser.getPassword().getText();
            String c_Password=newUser.getPassword2().getText();
            if(username.isEmpty()){
                JOptionPane.showMessageDialog(newUser, "Enter Username");
                return;
            }
            if(password.isEmpty()){
                JOptionPane.showMessageDialog(newUser,"Enter Password");
                return;
            }if(c_Password.isEmpty()){
                JOptionPane.showMessageDialog(newUser,"Confirm Password");
                return;
            }
            if(!password.equals(c_Password)){
                JOptionPane.showMessageDialog(newUser,"Passwords Do Not Match");
                return;
            }
            else{
                if(usermodel.lookUpUsername(username)){
                    usermodel.addUser(username, password);
                }else{
                    JOptionPane.showMessageDialog(newUser, "Username Already Exists");
                }
            }
                       
            
            
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
        }
        
    }
       
       public static JFrame showPage(){
           newUser.signUp().addActionListener(accounts);
           newUser.setVisible(true);
           return newUser;
       }
}