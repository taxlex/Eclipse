package assignment07;

public class Neg extends Expr {
	private Expr pos;
	public Neg(Expr apos){
		pos = apos;
	}
	public int eval(){
		if(pos.eval() == 0) return 1;
		else return 0;
	}
}
