package lab10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Driver {
	public static <T extends Comparable<T>> void sortCopy(List<T> list){
		List<T> copy = new ArrayList<>(list);
		System.out.println(copy);
		Collections.sort(copy);
		System.out.println(copy);
	}
	public static <T> void sortCopyBy(List<T> list, Comparator<? super T> comp) {
	    List<T> copy = new ArrayList<>(list);
	    System.out.println(copy);
	    Collections.sort(copy, comp);
	    System.out.println(copy);
	}
	public static void main(String[] args){
		Person test1 = new Person("Alexander", "Benedict");
		Person test2 = new Person("Alexander", "Benedict");
		Person test3 = new Person("Alexande", "Benedict");
		Person test4 = new Person("George", "Benedict");
		Person test5 = new Person("John", "Smith");
		Person test6 = new Person("Jane", "Oak");
		List<Person> people = new ArrayList<>();
		people.add(test1);
		people.add(test2);
		people.add(test3);
		people.add(test4);
		people.add(test5);
		people.add(test6);
		sortCopy(people);
		System.out.println("==================================================");
		Student testa = new Student(test1,3);
		Student testb = new Student(test2,2);
		Student testc = new Student(test3,1);
		Student testd = new Student(test4,4);
		Student teste = new Student(test5,2);
		Student testf = new Student(test6,3);
		List<Student> students = new ArrayList<>();
		students.add(testa);
		students.add(testb);
		students.add(testc);
		students.add(testd);
		students.add(teste);
		students.add(testf);
		sortCopy(students);
		System.out.println("==================================================");
		Comparator<Student> byStudents = Student::compareByGPA;
		sortCopyBy(students, byStudents);
		System.out.println("==================================================");
		Comparator<Student> byNameLength = Student::compareByNameLength;
		sortCopyBy(students, byNameLength);
		System.out.println("Bonus ==================================================");
		//My answer to Bonus
		sortCopyBy(students, byStudents.reversed().thenComparing(byNameLength));
		}
}
