/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author JoonaHa
 */
public class Course {
   
    private String name;
    private String fullName;
    private int[] exercises;
    private String term;
    private int year;
    

    public String getCourse() {
        return name;
    }

    public String getFullname() {
        return fullName;
    }

    public String getName() {
        return name;
    }

    public int[] getExercises() {
        return exercises;
    }

    public String getTerm() {
        return term;
    }

    public int getYear() {
        return year;
    }
    
    
    
    

    public void setFullname(String fullname) {
        this.fullName = fullname;
    }

    public int countAllExercises() {
        int all = 0;
        for (int exercise : exercises) {
            all += exercise;
        }
        
        return all;
    }
 
    
    
    
}


