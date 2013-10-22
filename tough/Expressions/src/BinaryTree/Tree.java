package BinaryTree;

import java.util.Queue;
import java.util.LinkedList;

public class Tree {
	
	private Node root;
	
	public Tree(){
		root = new Node();
	}
	
	
	public void createPrefixTree(String s){
		// create a queue and push all the characters in the expression to the queue
		Queue<Character> q = new LinkedList<Character>();
		for(int i=0;i<s.length();i++){
			q.add(s.charAt(i));
		}
		this.root.createTree(q);
	}
	
	public void inorder(){
		this.root.inorder();
	}
}
