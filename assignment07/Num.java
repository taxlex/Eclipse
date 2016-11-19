package assignment07;

public class Num extends Expr {
	private int val;
	public Num(int aval){
		val = aval;
	}
	public int eval(){
		return val;
	}
}
