/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validity;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Dinithi W
 */
public class Validation {
    
    public boolean isFieldEmpty(String name){
       
        return name.equalsIgnoreCase("");    
    }
    
    public boolean isContactValid(String number){
        
        int numberLength = number.length();
        
        for(int i=0;i<numberLength;i++){
            char temp = number.charAt(i);
            if(!(temp>='0'&& temp<='9')){
                return false;
            }
        }
        return true;
    }
    
    public boolean isemailValid(String email){
        
        int emailLen = email.length();
       
        for(int i=0;i<emailLen;i++){
            char temp = email.charAt(i);
            if(temp=='@') return true;
        }
        return false;
    }
    
    public boolean isRadiobtnSelected(ToggleGroup group){
        
        return group.getSelectedToggle()!=null;
        
    }
    
    public boolean isComboSelected(ComboBox combo){
        
        return combo.getSelectionModel().getSelectedIndex()!= -1;
    }
    
    public boolean isZScoreValid(String zscore){
        try{
            double dzscore = Double.parseDouble(zscore);
        }catch(Exception e){
            return false;
        }
        
        return true;
    }
}
