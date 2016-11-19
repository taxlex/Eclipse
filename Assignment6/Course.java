package Assignment6;

import java.util.HashSet;
import java.util.Set;

public class Course {
	private static int nextCRN = 10001;
	private String title;
	private int crn;
	private Set<Student> enrollment;
	public Course(String atitle){
		title = atitle;
		crn = nextCRN;
		nextCRN++;
		enrollment = new HashSet<>();
	}
	public boolean isUndergrad(){
		throw new UnsupportedOperationException("No information about level of the course");
	}
	public boolean isGrad(){
		throw new UnsupportedOperationException("No information about level of the course");
	}
	public int getCrn(){
		return crn;
	}
	public void addStudent(Student astu){
		enrollment.add(astu);
	}
	public void tallyEnrollment(Student[] allStudents){
		for(int i = 0; i < allStudents.length ; i++){
			if(allStudents[i].hasCourse(getCrn()) == true) enrollment.add(allStudents[i]);
		}
	}
	public int getEnrollmentSize(){
		return enrollment.size();
	}
}
