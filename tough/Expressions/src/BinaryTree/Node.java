package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
	
	char value;
	Node left;
	Node right;
	
	public Node getLeft(){
		return this.left;
	}
	
	public Node getRight(){
		return this.right;
	}
	
	public void setValue(char value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
	
	
	public void createTree(Queue<Character> q){
		
		Character c = q.poll();
		if(c != null){
			if(Character.isDigit(c)){
				this.value = c;
				this.left = null;
				this.right = null;
				return;
			}
			
			if(isOperator(c)){
				this.value = c;
				this.left = new Node();
				this.right = new Node();
				this.left.createTree(q);
				this.right.createTree(q);
				return;
			}
			System.out.println("Error!");
		}
		return;
	}	
	
	private static boolean isOperator(char c){
		if(c == '+' || c == '-' || c == '*' || c == '/'){
			return true;
		}else
			return false;
	}
	
	public void inorder(){
		if(this.left != null){
			this.left.inorder();
		}
		
		System.out.print(this.value + " ");
		
		if(this.right != null){
			this.right.inorder();
		}
	}
}
