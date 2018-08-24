/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Validity.Validation;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 *
 * @author Dinithi W
 */
public class Lecturer extends Person{
    
    private String UGDegreeName;
    private String UGDegreeInstitute;
    private int UDegreeCompleteYear;
    private int salary;
    private String faculty;
    private String ID;
    private static int index = 1;
    
    Validation validation1 = new Validation();
    
    public String getUGDegreeName() {
        return UGDegreeName;
    }

    public void setUGDegreeName(String UGDegreeName,Label label,int count[]) {
        if(validation.isFieldEmpty(UGDegreeName)){
            count[0]++;
            label.setText("*Please enter the name of the degree");
        }else{
            label.setText("");
            this.UGDegreeName = UGDegreeName;
        }
    }

    public String getUGDegreeInstitute() {
        return UGDegreeInstitute;
    }

    public void setUGDegreeInstitute(String UGDegreeInstitute,Label label,int count[]) {
        if(validation.isFieldEmpty(UGDegreeInstitute)){
            count[0]++;
            label.setText("*Please enter the Degree Institute");
        }else{
            label.setText("");
            this.UGDegreeInstitute = UGDegreeInstitute;
        }
    }

    public int getUDegreeCompleteYear() {
        return UDegreeCompleteYear;
    }

    public void setUDegreeCompleteYear(ComboBox combo,Label label,int count[]) {
        if(validation.isComboSelected(combo)){
            label.setText("");
            int tempYear = (int) combo.getValue();
            this.UDegreeCompleteYear = tempYear;
        }else{
            count[0]++;
            label.setText("*Please select the Year of completion");
        }
       
    
    }
    
    public int getSalary() {
        return salary;
    }

    public void setSalary(String salary,Label label,int count[]) {
        if(!validation.isContactValid(salary)){
            label.setText("*Please enter a valid number");
            count[0]++;
        }else{
            if(validation.isFieldEmpty(salary)){
                label.setText("*Please enter the salary");
                count[0]++;
            }else{
                label.setText("");
                this.salary = Integer.parseInt(salary);
            }
        }

    }
    
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(ComboBox combo,Label label,int count[]) {
        if(validation.isComboSelected(combo)){
            label.setText("");
            this.faculty = (String) combo.getValue();
        }else{
            count[0]++;
            label.setText("*Please select the Faculty of Study");
        }
    }

    public String getID() {
        return ID;
    }

        public void setID(ComboBox combo,int id,int count[]) {
        if(validation.isComboSelected(combo)){
            
            String faculty = (String) combo.getValue();
            
            Map<String, String> dictionary = new HashMap<String, String>();
            dictionary.put("Faculty of Computing", "C");
            dictionary.put("Faculty of Business", "B");
            dictionary.put("Faculty of Engineering", "E");
            
            String value = dictionary.get(faculty);
           
            String sindex = Integer.toString(index);
            String sID = Integer.toString(id);
            
            String fullID = sID+sindex+value;
            index++;
            this.ID = fullID;
            System.out.println("FullID "+fullID);
            
        }else{
            count[0]++;
            
        }
        
        
        
    }

    public void setID(String id) {
         this.ID = id;
    }
    
    
}
