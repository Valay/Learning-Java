package binaryTrees;

public class BinaryTree<T> {

	private T value;
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	
	public BinaryTree(){
		this.value = null;
		this.left = null;
		this.right = null;
	}
	
	public BinaryTree(T val){
		this.value = val;
		this.left = null;
		this.right = null;
	}
	
	public T getValue(){
		return this.value;
	}
	
	public void setValue(T val){
		this.value = val;
	}
	
}
