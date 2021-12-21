package com.main;
/**
 * This is the student class where the required details of Student name, RedID and GPA are declared.
 * It also contains the getter and setter methods which can be used for accessing variables to 
 * provide encapsulation.
 */
public class Student{
    String name;
    int redId;
	double gpa;
	

	Student(String name,int redId, double gpa){
        this.name = name;
        this.redId = redId;
        this.gpa = gpa;
    }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRedId() {
		return redId;
	}

	public void setRedId(int redId) {
		this.redId = redId;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
    /**
	 * This method is to convert the object into string.
	 */
    public String toString() {
        return "\nStudent Name: " + name + "\nRed ID: " + redId + "\nGPA: " + gpa;
    }


}
