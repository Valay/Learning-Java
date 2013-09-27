package BinaryTrees;

public class BinaryTree{
	
	private BinaryNode root;
	
	public BinaryTree(){
		root = null;
	}
	
	public BinaryTree(int value){
		root = new BinaryNode(value, null, null);
	}
	
	public boolean insert(int value){
		return this.root.insertNode(value);
	}
	
	public void postorder(){
		System.out.print("\nPostOrderTraversal: ");
		this.root.traversePostOrder();
	}
	
	public void inorder(){
		System.out.print("\nInOrderTraversal: ");
		this.root.traverseInOrder();
	}
	
	public void preorder(){
		System.out.print("\nPreOrderTraversal: ");
		this.root.traversePreOrder();
	}
	
	public void roworder(){
		System.out.print("\nRowOrderTraversal: ");
		this.root.traverseRowOrder();
	}
	
	public boolean isBalanced(){
		return this.root.isBalanced();
	}
}
