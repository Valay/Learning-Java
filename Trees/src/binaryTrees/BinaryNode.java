package BinaryTrees;

import java.util.Stack;

public class BinaryNode {

	private int value;
	private BinaryNode left;
	private BinaryNode right;
	
	public BinaryNode(){
		this.value = 0;
		this.left = null;
		this.right = null;
	}
	
	public BinaryNode(int val, BinaryNode left, BinaryNode right){
		this.value = val;
		this.left = left;
		this.right = right;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setValue(int val){
		this.value = val;
	}
	
	public BinaryNode getLeftChild(){
		if(this.left != null){
				return this.left;
		}
		return null;
	}
	
	public BinaryNode getRightChild(){
		if(this.right != null){
			return this.right;
		}
		return null;
	}
	
	public boolean insertNode(int value) {//throws ValueAlreadyExistException{
		if(this.getValue() > value){
			BinaryNode leftChild = this.getLeftChild();
			if(leftChild == null){
				return this.insertLeft(value);
			}
			return this.left.insertNode( value);
		}
		
		if(this.getValue() < value){
			BinaryNode rightChild = this.getRightChild();
			if(rightChild == null){
				return this.insertRight(value);
			}
			return this.right.insertNode(value);
		}
		
		//throw new ValueAlreadyExistException("This "+ value +"already exist!");
		System.out.println("Value already exist!");
		return false;
	}
	
	public boolean insertLeft(int value){
		this.left = new BinaryNode(value, null, null);
		return true;
	}
	
	public boolean insertRight(int value){
		this.right = new BinaryNode(value, null, null);
		return true;
	}
	
	public void traverseInOrder(){
		if(this.left != null){
			this.left.traverseInOrder();
		}
		
		System.out.print(this.value+" ");
		
		if(this.right != null){
			this.right.traverseInOrder();
		}
	}
	
	public void traversePreOrder(){
		System.out.print(this.value+" ");
		
		if(this.left != null){
			this.left.traversePreOrder();
		}
		
		if(this.right != null){
			this.right.traversePreOrder();
		}
	}
	
	public void traversePostOrder(){
		if(this.left != null){
			this.left.traversePostOrder();
		}
		
		if(this.right != null){
			this.right.traversePostOrder();
		}
		
		System.out.print(this.value+" ");
	}
	
	
	public void traverseRowOrder(){
		Stack<BinaryNode> s = new Stack<BinaryNode>();
		BinaryNode temp;
		s.push(this);
		
		while(!s.empty()){
			temp = s.pop();
			System.out.print(temp.value+" ");
			if(temp.left != null){
				s.push(temp.left);
			}
			
			if(temp.right != null){
				s.push(temp.right);
			}
		}
	}
	
	public boolean isBalanced(){
		
		return true;
	}
}
