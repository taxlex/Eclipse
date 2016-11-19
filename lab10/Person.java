package lab10;

public class Person implements Comparable<Person> {
	private String firstname;
	private String lastname;

    public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Person(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	@Override
	public String toString(){
		String retString = lastname + ", " + firstname;
		return retString;
	}

	/**
     * Compares this person to other based on lastname then firstname
     *   (if lastnames are equal, compare firstnames)
     * @param other the other Person to compare this Person to
     * @return  < 0 if this Person is less than other
     *            0 if this Person is equal to other
     *          > 0 if this Person is greater than other
     */
    public int compareTo(Person other) {
        if(lastname.compareTo(other.getLastname()) == 0){
        	return firstname.compareTo(other.getFirstname());
        }
        return lastname.compareTo(other.getLastname());
    }
}
