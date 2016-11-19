package lab09;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
	private Node root;
	
	public void insertHelper(Node next, Integer value){
		if(next.getValue() > value){
			if(next.getLeft() == null){
				next.setLeft(value);
			}
			else insertHelper(next.getLeft(),value);
		}
		if(next.getValue() < value){
			if(next.getRight() == null){
				next.setRight(value);
			}
			else insertHelper(next.getRight(),value);
		}
	}
	public Integer findHelper(Node next, int i){
		if(next == null) return null;
		if(next.getValue() > i) return findHelper(next.getLeft(),i);
		if(next.getValue() < i) return findHelper(next.getRight(),i);
		return next.getValue();
	}
	public List<Integer> getElemsHelper(Node next,  List<Integer> list){
		if(next.getLeft() != null) getElemsHelper(next.getLeft(), list);
		list.add(next.getValue());
		if(next.getRight() != null) getElemsHelper(next.getRight(), list);
		return list;
	}
	
	public void insert(int i){
		if(root == null){
			root = new Node(i);
		}
		else insertHelper(root, i);	
	}
	public Integer find(int i){
		return(findHelper(root, i));
	}
	public List<Integer> getElems(){
		List<Integer> list = new ArrayList<Integer>();
		return getElemsHelper(root, list); 
	}
}
