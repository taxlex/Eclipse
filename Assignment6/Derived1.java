package Assignment6;

public class Derived1 extends BaseClass{
	private String field1;
	public Derived1(String afield0, String afield1, String afield2){
		super(afield0, afield1, afield2);
		field1 = afield1;
	}
	public String toString(){
		String ret = super.toString() + field1;
		return ret;
	}
}
