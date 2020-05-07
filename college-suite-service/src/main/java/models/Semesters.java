/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author SHINJIRU
 */
public class Semesters {
    
    
    	int id;
	String name;	
	int year;
        List<String> subjects;
	
	public Semesters()
	{
	 	
	}
	public Semesters(int id, String name, int year,List<String> subjects) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
                this.subjects=subjects;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<String> getSubjects(){
            return subjects;
        }
        public void setSubjects(List<String> subjects){
            this.subjects=subjects;
        }
}
 
    
