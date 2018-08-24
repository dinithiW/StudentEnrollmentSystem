/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Connectivity.ConnectionClass;
import Exception.MyException;
import Validity.Validation;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
//import static sun.net.www.http.HttpClient.New;


public class Subject {
    
    private String subjectCode;
    private String subjectName;
    private int credits;
    private int semester;
    private String degreeName;
    private String degreeType;
    private int yearOfStudy;
    private int compulsory;
    private String lecturer;
    private String instructor1;
    private String instructor2;
    private int examPercentage;
    private static int index = 30;

    Validation validation = new Validation();
    
    ConnectionClass connectionClass = new ConnectionClass();
    Connection connection = null;
    
    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode){
        this.subjectCode = subjectCode;
    }
    public void setSubjectCode(ComboBox combo,ComboBox combo2) throws MyException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        
        connection = connectionClass.getConnection();
        if(validation.isComboSelected(combo) && validation.isComboSelected(combo2)){
            
            String degreeName = (String) combo.getValue();
            String sql = ("SELECT DEGREE_CODE FROM DEGREE WHERE DEGREE_NAME = '"+degreeName+"'");
            String degree_code = connectionClass.executeSqlCommand(sql);
            
            String sql1 = ("SELECT FACULTY_CODE FROM DEGREE WHERE DEGREE_CODE = '"+degree_code+"'");
            String faculty_code = connectionClass.executeSqlCommand(sql1);
            
            String sql2 = ("SELECT FACULTY_NAME FROM FACULTY WHERE FACULTY_CODE = '"+faculty_code+"'");
            String faculty_name = connectionClass.executeSqlCommand(sql2);
            
            Map<String, String> dictionary = new HashMap<String, String>();
            dictionary.put("Faculty of Computing", "SCS");
            dictionary.put("Faculty of Business", "SSB");
            dictionary.put("Faculty of Engineering", "SSE");
            
            String value = dictionary.get(faculty_name);
            
            Integer iyear = (Integer) combo2.getValue();
            String year = iyear.toString();
            
            String sIndex = Integer.toString(index);
            String fullID = value+year+sIndex;
            index++;
            this.subjectCode = fullID;
            System.out.println("FullID "+fullID);
            
        }else{
            throw new MyException("Combobox not selected");
            
        }
        
    }

    
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName,Label label) throws MyException {
        if(validation.isFieldEmpty(subjectName)){
            label.setText("This field cannot be blank");
            throw new MyException("Subject Name cannot be empty");
        }else{
            label.setText("");
            this.subjectName = subjectName;
        }
        
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(String credits,Label label) throws MyException {
        
        if(validation.isFieldEmpty(credits)){
            label.setText("This field cannot be empty");
            throw new MyException("Field cannot be blank");
        }else if(!validation.isContactValid(credits)){
            label.setText("This field should be a number");
            throw new MyException("This field should be a number");
        }else{
            label.setText("");
            this.credits = Integer.parseInt(credits);
        }
        
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(ComboBox combo,Label label) throws MyException {
        if(validation.isComboSelected(combo)){
            int semester = (int) combo.getValue();
            this.semester = semester;
            label.setText("");
        }else{
            label.setText("Please select the semester");
            throw new MyException("Not selected semster");
        }
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(ComboBox combo,Label label) throws MyException {
       if(validation.isComboSelected(combo)){
            String degree_name = (String) combo.getValue();
            this.degreeName= degree_name;
            label.setText("");
        }else{
            label.setText("Please select the year of study");
            throw new MyException("Year not selected");
        }
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(ComboBox combo,Label label) throws MyException {
        if(validation.isComboSelected(combo)){
            int year = (int) combo.getValue();
            this.yearOfStudy = year;
            label.setText("");
        }else{
            label.setText("Please select the year of study");
            throw new MyException("Year not selected");
        }
    }

    public int getCompulsory() {
        return compulsory;
    }

    public void setCompulsory(ToggleGroup toggleGroup,Label label) throws MyException {
        
        if(validation.isRadiobtnSelected(toggleGroup)){
            
            RadioButton button = (RadioButton) toggleGroup.getSelectedToggle();
            String temp = button.getText();
            if(temp.equalsIgnoreCase("Compulsory")){
                this.compulsory = 1;
            }else{
                this.compulsory = 0;
            }
            label.setText("");
        }else{
            label.setText("Please select an option");
            throw new MyException("Status not selected");
        }
        
        
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(ComboBox combo,Label label) throws MyException {
        if(validation.isComboSelected(combo)){
            String lName = (String) combo.getValue();
            this.lecturer = lName;
            label.setText("");
        }else{
            label.setText("Please select a Lecturer");
            throw new MyException("Lecturer not selected");
        }
    }

    public String getInstructor1() {
        return instructor1;
    }

    public void setInstructor1(ComboBox combo,Label label) throws MyException {
        if(validation.isComboSelected(combo)){
            String IName = (String) combo.getValue();
            this.instructor1 = IName;
            label.setText("");
        }else{
            label.setText("Please select a Instructor");
            throw new MyException("Instructor not selected");
        }
    }

    public String getInstructor2() {
        return instructor2;
    }

    public void setInstructor2(ComboBox combo,Label label) throws MyException {
        if(validation.isComboSelected(combo)){
            String IName = (String) combo.getValue();
            this.instructor2 = IName;
            label.setText("");
        }else{
            label.setText("Please select a Instructor");
            throw new MyException("Instructor not selected");
        }
    }

    public String getDegreeType() {
        return degreeType;
    }

    
    public void setDegreeType(ToggleGroup group) throws MyException {
        if(validation.isRadiobtnSelected(group)){
            //label.setText("");
            RadioButton button = (RadioButton) group.getSelectedToggle();
            this.degreeType = button.getText();
        }else{
           // label.setText("*Please select an option");
            throw new MyException("Select degree type");
        }
    }
    
    public void setUniqueINstructors(String Instructor1,String Instructor2,Label label) throws MyException{
        if(Instructor1.equalsIgnoreCase(Instructor2)){
            label.setText("Please select two unique Instructors");
            throw new MyException("Wronggg");
        }else{
            label.setText("");
            
        }
    }

    
    public int getExamPercentage() {
        return examPercentage;
    }

    
    public void setExamPercentage(String examPercentage,Label label) throws MyException {
        if(validation.isContactValid(examPercentage) ){
            if(!validation.isFieldEmpty(examPercentage)){
                label.setText("");
                this.examPercentage = Integer.parseInt(examPercentage);
            }else{
                label.setText("This field cannot be blank");
                throw new MyException("Blank Field");
            }
            
        }else{
            label.setText("This should be a number");
            throw new MyException("Invalid number");
        }
        
    }
    
    
}
