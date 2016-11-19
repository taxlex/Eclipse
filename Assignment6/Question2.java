package Assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Question2 {
	public static Course[] courseArray;
	public static Student[] studentArray;
	static{
		Random rand = new Random();
		courseArray = new Course[600];
		studentArray = new Student[6000];
		for(int i = 0; i < 400; i++){
			courseArray[i] = new UndergradCourse(Question1.name(rand.nextInt(308915776)));
		}
		for(int j = 400; j < 600 ; j++){
			courseArray[j] = new GraduateCourse(Question1.name(rand.nextInt(308915776)));
		}
		for(int q = 0; q < 5000 ; q++){
			studentArray[q] = new UndergradStudent(Question1.name(rand.nextInt(308915776)));
			studentArray[q].adjustSchedule();
		}
		for(int p = 5000; p < 6000 ; p++){
			studentArray[p] = new GraduateStudent(Question1.name(rand.nextInt(308915776)),Question1.name(rand.nextInt(308915776)));
			studentArray[p].adjustSchedule();
		}
		for(int v = 0; v < 600; v++){
			courseArray[v].tallyEnrollment(studentArray);
		}
		
		ArrayList<Course> list = new ArrayList<Course>(Arrays.asList(courseArray));
		Collections.shuffle(list);
		courseArray = list.toArray(courseArray);
		
		ArrayList<Student> lista = new ArrayList<Student>(Arrays.asList(studentArray));
		Collections.shuffle(lista);
		studentArray = lista.toArray(studentArray);
		
		for(int t = 0; t < 6000; t++){
			int x = rand.nextInt(600);
			studentArray[t].addCourse(courseArray[x]);
			courseArray[x].addStudent(studentArray[t]);
			x = rand.nextInt(600);
			studentArray[t].addCourse(courseArray[x]);
			courseArray[x].addStudent(studentArray[t]);
			x = rand.nextInt(600);
			studentArray[t].addCourse(courseArray[x]);
			courseArray[x].addStudent(studentArray[t]);
			x = rand.nextInt(600);
			studentArray[t].addCourse(courseArray[x]);
			courseArray[x].addStudent(studentArray[t]);
			//studentArray[t].adjustSchedule();
		}
		
	}
	
	
	
	public static int maxClassSize(Course[] acourse){
		int x = 0;
		for(int i = 0; i < acourse.length ; i++){
			if(acourse[i].getEnrollmentSize() > x) x =acourse[i].getEnrollmentSize();
		}
		return x;
	}
	
	public static int minClassSize(Course[] acourse){
		int x = Integer.MAX_VALUE;
		for(int i = 0; i < acourse.length ; i++){
			if(acourse[i].getEnrollmentSize() < x && acourse[i].getEnrollmentSize()!= 0 ) x =acourse[i].getEnrollmentSize();
		}
		return x;
	}
	
	public static double avgClassSize(Course[] acourse){
		double x = 0;
		for(int i = 0; i < acourse.length ; i++){
			x += acourse[i].getEnrollmentSize();
		}
		return x/(acourse.length);
	}
	public static double percentUndergrad(Student[] astu){
		double inc = 0;
		double incgrad = 0;
		for(int i = 0; i < astu.length ; i++){
			if(astu[i].isGrad() == true){
				incgrad++;
				if(astu[i].hasUndergradClass() == true) inc++;
			}
		}
		return (inc/incgrad)*100;
	}
	public static void main(String[] args){
		System.out.println(courseArray[0].getEnrollmentSize());
		System.out.println("Max class size: " + maxClassSize(courseArray));
		System.out.println("Min class size: " + minClassSize(courseArray));
		System.out.println("Avg class size: " + avgClassSize(courseArray));
		System.out.println("Percent of grad students in undergrad classes: " + percentUndergrad(studentArray) + "%");
		studentArray[5900].addCourse(courseArray[1]);
		System.out.println(studentArray[5900].hasCourse(courseArray[1].getCrn()));
	}
}
