package assignment08;

public class IntLinkedList {
	private Node head;
	private Node last;
	
	private class Node{
		private int i;
		private Node next;
		
	}
	public void startList(int i){
		if(head != null) {
			throw new RuntimeException("List already created");
		}
		else{
			head = new Node();
			head.i = i;
			last = head;
		}
	}
	public void appendList(int i){
		if(head == null){
			throw new RuntimeException("Must create list");
		}
		last.next = new Node();
		last = last.next;
		last.i = i;
	}
	public void remove(int i){
		if(head == null) throw new RuntimeException("List is empty");
		Node temp = head;
		if(head.i == i) head = head.next;
		else{
			while(temp.next != null){
				if(temp.next.i == i){
					temp.next = temp.next.next;
					break;
				}
				temp = temp.next;
			}
		}
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
	
	
	
	public static void main(String[] args){
		IntLinkedList primes = new IntLinkedList();
		primes.startList(2);
		for(int i = 3; i < 1000; i++){
			primes.appendList(i);
		}
		Node nextPrime = primes.head;
		System.out.print("[");
		try{
			while(true){
				System.out.print(nextPrime.i);
				Node temp = nextPrime;
				while(temp != null && temp.next != null){
					if(temp.next.i%nextPrime.i== 0){
						temp.next = temp.next.next;
					}
					temp = temp.next;
				}
				nextPrime = nextPrime.next;
				if(nextPrime != null) System.out.print(", ");
			}
		}
		catch(RuntimeException e){
			System.out.print("]");
		}
	}

}
