package Assignment6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Student {
	private static int nextID = 10001;
	private String name;
	private int id;
	private Set<Course> schedule;
	private String major;
	private ArrayList<Course> allCourses = new ArrayList<>();
	
	public Student(String amajor){
		major = amajor;
		id = nextID;
		nextID++;
		schedule = new HashSet<>();
		name = Question1.name(id);
	}
	protected Set<Course> getSchedule(){
		return schedule;
	}
	public boolean isUndergrad(){
		return false;
	}
	public boolean isGrad(){
		return false;
	}
	public String getName(){
		return name;
	}
	public ArrayList<Course> getAllCourses(){
		return allCourses;
	}
	public void addCourse(Course cor){
		schedule.add(cor);
	}
	public void adjustSchedule(){}
	
	
	public boolean hasCourse(int crn){
		boolean x = false;
		for(Course i : schedule){
			if(i.getCrn() == crn) x = true;
		}
		return x;
	}
	public boolean hasUndergradClass(){
		return false;
	}
}
