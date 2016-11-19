package assignment07;

public class Add extends Expr{
	private Expr left;
	private Expr right;
	public Add(Expr lefta, Expr righta){
		left = lefta;
		right = righta;
	}
	public int eval(){
		return left.eval() + right.eval();
	}
}
