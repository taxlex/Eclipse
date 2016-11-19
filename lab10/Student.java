package lab10;

public class Student implements Comparable<Student>{
	private Person person;
	private int GPA;
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getGPA() {
		return GPA;
	}
	public void setGPA(int gPA) {
		GPA = gPA;
	}
	public Student(Person person, int gPA) {
		super();
		this.person = person;
		GPA = gPA;
	}
	@Override
	public String toString(){
		String retString = person.toString() + " (" + GPA + ")";
		return retString;
	}
	public static int compareByGPA(Student a, Student b){
		return a.GPA - b.GPA;
	}
	public static int compareByNameLength(Student a, Student b){
		int aint = a.person.getFirstname().length() + a.person.getLastname().length();
		int bint = b.person.getFirstname().length() + b.person.getLastname().length();
		return aint - bint;
	}
	public int compareTo(Student other) {
        if(person.getLastname().compareTo(other.getPerson().getLastname()) == 0){
        	return person.getFirstname().compareTo(other.getPerson().getFirstname());
        }
        return person.getLastname().compareTo(other.getPerson().getLastname());
    }
}
