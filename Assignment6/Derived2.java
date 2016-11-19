package Assignment6;

public class Derived2 extends BaseClass{
	private String field2;
	public Derived2(String afield0, String afield1, String afield2){
		super(afield0,afield1,afield2);
		field2 = afield2;
	}
	public String toString(){
		String ret = field2 + " " + super.toString();
		return ret;
	}
}
