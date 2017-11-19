/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import javax.swing.JFrame;
import View.*;
import java.awt.event.ActionEvent;
import Model.*;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author Esperant
 */
public class RequestCar {
    static RequestView request = new RequestView();
    static searchHandler searchcar = new searchHandler();
    static AvailableCars carsmodel = new AvailableCars();
    
    static class searchHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            try{
                String model = request.getModel().getText();
                String make = request.getMake().getSelectedItem().toString();
                if(!model.isEmpty()){
                if(carsmodel.findCarExists(model, make)){
                    
                    carsmodel.getCarExists(model, make);
                    request.getTagNo().setText(carsmodel.getCarExists(model, make).get(0));
                    request.getCategory().setText(carsmodel.getCarExists(model, make).get(1));
                    request.getMaker().setText(make);
                    request.getModeler().setText(model);
                    request.getYear().setText(carsmodel.getCarExists(model, make).get(4));
                
                
                }else{
                    System.out.println("Car Not Found");
                    JOptionPane.showMessageDialog(request, "Car Not Found");
                }
                }else{
                    JOptionPane.showMessageDialog(request,"Enter Car Model");
                    return;
                }
                
                
                
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
                                    
            
        }
        
        
        
    }
    
    
    
    public static JFrame showPage(){
        request.setVisible(true);
        request.searchCar().addActionListener(searchcar);
        return request;
    }
    
    
    
}
