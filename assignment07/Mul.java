package assignment07;

public class Mul extends Expr{
	private Expr left;
	private Expr right;
	public Mul(Expr lefta, Expr righta){
		left = lefta;
		right = righta;
	}
	public int eval(){
		return left.eval()*right.eval();
	}
}
