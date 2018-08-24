/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Validity.Validation;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import javafx.scene.control.RadioButton;
/**
 *
 * @author Dinithi W
 */
abstract class Person {
    
    private String name;
    private String address;
    private String homeContact;
    private String mobileContact;
    private String email;
    private String NIC;
    private String gender;
    private int DoBDate;
    private int DoBMonth;
    private int DoBYear;
    
    Validation validation = new Validation();

    //returns the name
    public String getName() {
        return name;
    }

    //sets the name after validating
    public void setName(String name,Label label,int count[]) {
        if(!validation.isFieldEmpty(name)){
            label.setText("");
            this.name = name;
        }else{
            count[0]++;
            label.setText("*This field cannot be left blank");
        }
    }

    //returns the addres
    public String getAddress() {
        return address;
    }

    //sets the address after verifying
    public void setAddress(String address,Label label,int count[]) {
        if(!validation.isFieldEmpty(address)){
            label.setText("");
            this.address = address;
        }else{
            count[0]++;
            label.setText("*This field cannot be left blank");
        }
        
    }

    //returns the home contact
    public String getHomeContact() {
        return homeContact;
    }

    //sets the home contact number after verifying
    public void setHomeContact(String homeContact,Label label,TextField textField,int count[]) {
        if(!validation.isContactValid(homeContact)){
            count[0]++;
            textField.clear();
            label.setText("*Please enter a valid number");
        }else{
            if(validation.isFieldEmpty(homeContact)){
                count[0]++;
                label.setText("*This field cannot be left blank");
        }else{
                label.setText("");
            this.homeContact = homeContact;
            }
        } 
    }

    //returns the mobile number
    public String getMobileContact() {
        return mobileContact;
    }

    //sets the mobile number after verifying
    public void setMobileContact(String mobileContact,Label label,TextField textField,int count[]) {
        if(!validation.isContactValid(mobileContact)){
            count[0]++;
            textField.clear();
            label.setText("*Please enter a valid number");
        }else{
            if(validation.isFieldEmpty(mobileContact)){
                count[0]++;
            label.setText("*This field cannot be left blank");
        }else{
            label.setText("");
            this.mobileContact = mobileContact;
            }
        } 
    }

    //returns the email address 
    public String getEmail() {
        return email;
    }

    //sets the email address after verifying
    public void setEmail(String email,Label label,TextField textField,int count[]) {
        if(!validation.isemailValid(email)){
            count[0]++;
            textField.clear();
            label.setText("*Please enter a valid email address");
        }else{
            if(validation.isFieldEmpty(email)){
                count[0]++;
                label.setText("*This field cannot be left blank");
            }else{
                label.setText("");
                this.email = email;
            }
        }
    }

    //returns the NIC
    public String getNIC() {
        return NIC;
    }

    //sets the NIC after verifying
    public void setNIC(String NIC,Label label,TextField textField,int count[]) {
        if(validation.isFieldEmpty(NIC)){
            count[0]++;
            label.setText("*This field cannot be left blank");
        }else{
            label.setText("");
            this.NIC = NIC;
        }
        }

    //returns the gender
    public String getGender() {
        return gender;
    }
    
    //sets the gender after verifying
    public void setGender(ToggleGroup group,Label label,int count[]) {
        if(validation.isRadiobtnSelected(group)){
            label.setText("");
            RadioButton button = (RadioButton) group.getSelectedToggle();
            this.gender = button.getText();
        }else{
            count[0]++;
            label.setText("*Please select an option");
        }
        
    }

    //returns DoB Date
    public int getDoBDate() {
        return DoBDate;
    }
    
    //sets the date of birth after verifying that an option is selected
    public void setDoBDate(ComboBox combo,Label label,int count[]) {
        
        if(validation.isComboSelected(combo)){
            int tempDate = (int) combo.getValue();
            label.setText("");
            this.DoBDate = tempDate;
        }else{
            count[0]++;
            label.setText("*Please select the Date of birth");
        }
        
    }

    //return the Month of birth
    public int getDoBMonth() {
        return DoBMonth;
    }

    //sets the month of birth after verifying that an option has been selected
    public void setDoBMonth(ComboBox combo,Label label,int count[]) {
        
        if(validation.isComboSelected(combo)){
            String months[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
            String tempMonth = (String) combo.getValue();
            int month = Arrays.asList(months).indexOf(tempMonth);
            label.setText("");
            this.DoBMonth = month+1;
        }else{
            count[0]++;
            label.setText("*Please select the Month of birth");
        }
    }

    //returns the year of birth
    public int getDoBYear() {
        return DoBYear;
    }

    //sets the year of birth after verifying that an option has been selected
    public void setDoBYear(ComboBox combo,Label label,int count[]) {
        if(validation.isComboSelected(combo)){
            int tempYear = (int) combo.getValue();
            label.setText("");
            this.DoBYear = tempYear;
        }else{
            count[0]++;
            label.setText("*Please select the Year of birth");
        }
    }
  
}
