/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Validity.Validation;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Dinithi W
 */
public class Student extends Person{
  
    private String intake;
    private String degreeType;
    private String faculty;
    private String degreeName;
    private String ALStream;
    private double zscore;
    private int rank;
    private String Subject1;
    private String Sub1Grade;
    private String Subject2;
    private String Sub2Grade;
    private String Subject3;
    private String Sub3Grade;
    private String UGDegreeName;
    private String UGDegreeInstitute;
    private int UDegreeCompleteYear;
    //private String subject;
    private String ID;
    private int yearOfStudy;
    private static int index = 1;
    Validation validation1 = new Validation();
   
    public String getIntake() {
        return intake;
    }

    public void setIntake(ToggleGroup tgroup,Label label,int count[]) {
        if(validation.isRadiobtnSelected(tgroup)){
            label.setText("");
            RadioButton button = (RadioButton) tgroup.getSelectedToggle();
            this.intake = button.getText();
            
        }else{
            count[0]++;
            label.setText("*Please select an option");
        }
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(ToggleGroup tgroup,Label label,int count[]) {
        if(validation.isRadiobtnSelected(tgroup)){
            label.setText("");
            RadioButton button = (RadioButton) tgroup.getSelectedToggle();
            this.degreeType = button.getText();
        }else{
            count[0]++;
            label.setText("*Please select an option");
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

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(ComboBox combo,Label label,int count[]) {
        if(validation.isComboSelected(combo)){
            label.setText("");
            this.degreeName = (String) combo.getValue();
        }else{
            count[0]++;
            label.setText("*Please select the Degree Name");
        }
    }

    public String getALStream() {
        return ALStream;
    }

    public void setALStream(ComboBox combo,Label label,int count[]) {
        if(validation.isComboSelected(combo)){
            label.setText("");
            this.ALStream = (String) combo.getValue();
        }else{
            count[0]++;
            label.setText("*Please select the A/L stream");
        }
    }

    public double getZscore() {
        return zscore;
    }

    public void setZscore(String zscore,Label label,TextField textField,int count[]) {
        
        if(!validation.isZScoreValid(zscore)){
            count[0]++;
            textField.clear();
            label.setText("*Please enter a valid number");
            
        }else{
            if(validation.isFieldEmpty(zscore)){
                count[0]++;
                label.setText("*This field cannot be left blank");
            }else{
                label.setText("");
                this.zscore = Double.parseDouble(zscore);
            }
        }
        
    }

    public int getRank() {
        return rank;
    }

    public void setRank(String rank,Label label,TextField textField,int count[]) {
        if(!validation.isContactValid(rank)){
            count[0]++;
            textField.clear();
            label.setText("*Please enter a valid number");
        }else{
            if(validation.isFieldEmpty(rank)){
                count[0]++;
                label.setText("*This field cannot be left blank");
            }else{
                label.setText("");
                this.rank = Integer.parseInt(rank);
            }
        }
    }

    public String getSubject1() {
        return Subject1;
    }

    public void setSubject1(String Subject1,Label label,int count[]) {
        if(validation.isFieldEmpty(Subject1)){
            count[0]++;
            label.setText("*Please enter the first subject");
        }else{
            label.setText("");
            this.Subject1 = Subject1;
        }
        
    }

    public String getSub1Grade() {
        return Sub1Grade;
    }

    public void setSub1Grade(ComboBox combo,Label label,int count[]) {
        if(validation.isComboSelected(combo)){
            label.setText("");
            this.Sub1Grade =  (String) combo.getValue();
        }else{
            count[0]++;
            label.setText("*Please select the grade for subject 1");
        }
    }

    public String getSubject2() {
        return Subject2;
    }

    public void setSubject2(String Subject2,Label label,int count[]) {
        if(validation.isFieldEmpty(Subject2)){
            count[0]++;
            label.setText("*Please enter the second subject");
        }else{
            label.setText("");
            this.Subject2 = Subject2;
        }
    }

    public String getSub2Grade() {
        return Sub2Grade;
    }

    public void setSub2Grade(ComboBox combo,Label label,int count[]) {
        if(validation.isComboSelected(combo)){
            label.setText("");
            this.Sub2Grade = (String) combo.getValue();
        }else{
            count[0]++;
            label.setText("*Please select the grade for Subject 2");
        }
    }

    public String getSubject3() {
        return Subject3;
    }

    public void setSubject3(String Subject3,Label label,int count[]) {
        if(validation.isFieldEmpty(Subject3)){
            count[0]++;
            label.setText("*Please enter the third subject");
        }else{
            label.setText("");
            this.Subject3 = Subject3;
        }
    }

    public String getSub3Grade() {
        return Sub3Grade;
    }

    public void setSub3Grade(ComboBox combo,Label label,int count[]) {
        if(validation.isComboSelected(combo)){
            label.setText("");
            this.Sub3Grade = (String) combo.getValue();
        }else{
            count[0]++;
            label.setText("*Please select the grade for subject 3");
        }
    }

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

    
    public String getID() {
        return ID;
    }

    
    public void setID(String id){
        this.ID = id;
    }
    
    public void setID(ComboBox combo,int id,String DegreeType,int count[]) {
        if(validation.isComboSelected(combo)){
            
            String facluty = (String) combo.getValue();
            
            Map<String, String> dictionary = new HashMap<String, String>();
            dictionary.put("Faculty of Computing", "C");
            dictionary.put("Faculty of Business", "B");
            dictionary.put("Faculty of Engineering", "E");
            
            String value = dictionary.get(faculty);
            
            String degree = "";
            
            if(DegreeType.equalsIgnoreCase("undergraduate")){
                degree = "U";
            }else{
                degree = "P";
            }
            
            String sID = Integer.toString(id);
            String sIndex = Integer.toString(index);
            String fullID = sID+value+sIndex+degree;
            index++;
            this.ID = fullID;
            System.out.println("FullID "+fullID);
            
        }else{
            count[0]++;
            
        }
        
        
        
    }

    
    public int getYearOfStudy() {
        return yearOfStudy;
    }

    
    public void setYearOfStudy(ComboBox combo,Label label,int count[]) {
        
        if(validation.isComboSelected(combo)){
            label.setText("");
            int year = (int) combo.getValue();
            this.yearOfStudy = year;
        }else{
            label.setText("Please select the year");
            count[0]++;
        }
        
    }
    
    
    
}
