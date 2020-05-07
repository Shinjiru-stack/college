/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author SHINJIRU
 */
import models.Semesters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
//import models.Semester;
public class SemesterService {
        
    	static HashMap<Integer,Semesters> SemesterIdMap=getSemesterIdMap();
 
 
	public SemesterService() {
		super();
                //Semesters a=new Semesters();
		if(SemesterIdMap==null)
		{
			SemesterIdMap=new HashMap<>();
			
			Semesters javaBook=new Semesters(1, "Head first java", 620,Arrays.asList("1","2","3"));
			Semesters springBook=new Semesters(4, "Spring in action",500,Arrays.asList("1","3"));
			Semesters pythonBook=new Semesters(3, "Learning Python",250,Arrays.asList("1","2"));
			Semesters hiberanteBook=new Semesters(2, "Hibernate in action",300,Arrays.asList("1"));
 
 
			SemesterIdMap.put(1,javaBook);
			SemesterIdMap.put(4,springBook);
			SemesterIdMap.put(3,pythonBook);
			SemesterIdMap.put(2,hiberanteBook);
		}
	}
 
    /**
     *
     * @return
     */
    public static List<Semesters> getAllSemesters()
	{
		List<Semesters>  Semesters = new ArrayList<>(SemesterIdMap.values());
		return Semesters;
	}
 
	public Semesters getSemesters(int id)
	{
		Semesters Semester= SemesterIdMap.get(id);
		return Semester;
	}
	public Semesters addSemesters(Semesters Semester)
	{
		Semester.setId(getMaxId()+1);
		SemesterIdMap.put(Semester.getId(), Semester);
		return Semester;
	}
 
	public Semesters updateSemesters(Semesters Semester)
	{
		if(Semester.getId()<=0)
			return null;
		SemesterIdMap.put(Semester.getId(), Semester);
		return Semester;
 
	}
	public void deleteSemesters(int id)
	{
		SemesterIdMap.remove(id);
	}
 
	public  static HashMap<Integer, Semesters> getSemesterIdMap() {
		return SemesterIdMap;
	}
 
	// Utility method to get max id
	public static int getMaxId()
	{ int max=0;
	for (int id:SemesterIdMap.keySet()) { 
		if(max<=id)
			max=id;
 
	} 
	return max;
	}

}
