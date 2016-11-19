package lab10;

public class Mul extends Expr {
    private Expr left;
    private Expr right;

    public Mul(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

    public int eval() {
        return left.eval() * right.eval();
    }
    public String toString(){
    	String retString = "";
    	retString += "(";
    	retString += left.toString();
    	retString += " * ";
    	retString += right.toString();
    	retString += ")";
    	return retString;
    }
}