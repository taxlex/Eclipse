package assignment08;

public class IntLinkedList2 {
private Node head;
private Node last;

	private class Node{
		private int i;
		private Node next;
		
		public Node(int num){
			i = num;
		}
		public Node remove(int j){
			if(j == i) return next;
			else if(next != null) next = next.remove(j);
			else last = this;
			return this;
		}
	}
	
	
	public void startList(int i){
		if(head != null) {
			throw new RuntimeException("List already created");
		}
		else{
			head = new Node(i);
			last = head;
		}
	}
	public void appendList(int i){
		if(head == null){
			throw new RuntimeException("Must create list");
		}
		last.next = new Node(i);
		last = last.next;
	}
	public void remove(int i){
		if(head == null) throw new RuntimeException("List is empty");
		head = head.remove(i);
	}
	@Override
	public String toString(){
		if(head == null) return "[]";
		StringBuffer sb = new StringBuffer("[");
		Node temp = head;
		while(temp.next != null){
			sb.append(temp.i);
			sb.append(", ");
			temp = temp.next;
		}
		sb.append(temp.i);
		sb.append("]");
		return sb.toString();
	}
}
