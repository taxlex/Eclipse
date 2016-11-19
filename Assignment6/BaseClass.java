package Assignment6;

public class BaseClass {
	private String field0;
	public BaseClass(String afield0, String afield1, String afield2){
		field0 = afield0;
	}
	public String toString(){
		return field0;
	}
	public static void main(String[] args){
		Derived1 testa = new Derived1("Hello ","World ","!!!");
		System.out.println(testa.toString());
		Derived2 testb = new Derived2("Hello ","World ","!!!");
		System.out.println(testb.toString());
		BaseClass testc = new BaseClass("Hello ","World ","!!!");
		System.out.println(testc.toString());
	}

}
