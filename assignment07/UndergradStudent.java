package assignment07;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import Assignment6.Course;
import Assignment6.Student;
import assignment07.CSGenedCourse.CSGened;
/*
 * I named assignment06 "Assignment6" so the
 * import will need to be changed for testing
 */




public class UndergradStudent extends Student {
	public CSGenedCourse Course;
	public UndergradStudent(String amajor){
		super(amajor);
	}
	@Override
	public boolean isUndergrad(){
		return true;
	}
/*
	public int countUndergrad(Set<Course> sch){
		int inc = 0;
		for(Course i : sch){
			if(i.isGrad() == true) inc++;
		}
		return inc;
	}
	@Override
	public void adjustSchedule(){
		Random rand = new Random();
		int x = 0;
		while(countUndergrad(getSchedule()) > 2){
			for(Course i : getSchedule()){
				if(i.isGrad() == true){
					getSchedule().remove(i);
					while(getSchedule().add(new Course(Question1.name(x))) == false){
						x = rand.nextInt(308915776);
					}
					getSchedule().add(new Course(Question1.name(x)));
				}
			}
		}
		
	}
*/
	public boolean satisfiesCSGened(){
		try (PrintWriter out = new PrintWriter("test.log")) {

			   ArrayList<Set<CSGenedCourse.CSGened>> waysToSatisfy = new ArrayList<>();
			   waysToSatisfy.add(new HashSet<CSGened>());
			   boolean Csatisfied = false;
			   boolean Osatisfied = false;
			   boolean F1satisfied = false;
			   for(Course crs : getAllCourses()){
				   if(crs instanceof CSGenedCourse){
					   CSGenedCourse gecrs = (CSGenedCourse)crs;
					   out.println(Arrays.toString(gecrs.getGeneds()));
					   int sz = waysToSatisfy.size();
					   int len = gecrs.getGeneds().length;
						   for(int i = 0 ; i < len-1 ; i++){
							   for(int j = 0; j < sz ; j++){
							   HashSet<CSGened> temp = new HashSet<CSGened>();
							   temp.addAll(waysToSatisfy.get(j));
							   waysToSatisfy.add(temp);
						   }
					   }
					   for(Set<CSGened> s : waysToSatisfy) out.println(s);
					   for(int i = 0; i < len; i++){
						   for(int j = i*sz; j < (i+1)*sz; j++){
							   if(gecrs.getGeneds()[i] == CSGened.C) Csatisfied = true; 
							   else if(gecrs.getGeneds()[i] == CSGened.O) Osatisfied = true; 
							   else if(gecrs.getGeneds()[i] == CSGened.J){
								   Csatisfied = true;
								   Osatisfied = true;
							   }
							   else if(gecrs.getGeneds()[i] == CSGened.F1) F1satisfied = true;
							   else waysToSatisfy.get(j).add(gecrs.getGeneds()[i]); 
						   }
					   }
					   for(Set<CSGened> s : waysToSatisfy) out.println(s);
				   }
			   }
			   for(Set<CSGened> s : waysToSatisfy){
				   if(s.contains(CSGened.B)== true){
					   s.remove(CSGened.B);
					   s.add(CSGened.S);
					   s.add(CSGened.Y);
					   out.println(s + " " + Csatisfied + " " + Osatisfied + " " + F1satisfied);
					   if(s.size() == 9 && Csatisfied == true && Osatisfied == true && F1satisfied == true) return true;
				   }
			   }

			       out.close();
		}
			 catch (FileNotFoundException e) {
			       e.printStackTrace();
			} 
			return false;
	}
}