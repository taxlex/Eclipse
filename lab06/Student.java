package lab06;

public class Student {
	private int age;
	private String name;
	private boolean male;
	public Student(int age, String name, boolean male) {
		super();
		this.age = age;
		this.name = name;
		this.male = male;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	
}