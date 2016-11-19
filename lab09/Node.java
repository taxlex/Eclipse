package lab09;

public class Node {
	private Integer value;
	private Node Left;
	private Node Right;
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Node getLeft() {
		return Left;
	}
	public void setLeft(Integer val) {
		Left = new Node(val);
	}
	public Node getRight() {
		return Right;
	}
	public void setRight(Integer val) {
		Right = new Node(val);
	}
	public Node(Integer value) {
		this.value = value;
		Left = null;
		Right = null;
	}
	
}
