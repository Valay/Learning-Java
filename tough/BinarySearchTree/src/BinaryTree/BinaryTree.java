package BinaryTree;

public class BinaryTree {

	private Node root;

	private class Node {
		int value; // value 
		int count; // count = rank of node
		Node left;
		Node right;

		public Node(int key) {
			this.value = key;
			this.right = null;
			this.left = null;
		}
	}

	// size
	public int size() {
		return root.count;
	}


	// Inserting into Binary Search Tree
	public boolean insert(int key) {
		if (root == null) {
			root = new Node(key);
		} else {

			return insert(root, key);
		}
		return true;
	}

	private boolean insert(Node n, int key) {
		if (n.value > key) {
			if (n.left != null) {
				return insert(n.left, key);
			} else {
				n.left = new Node(key);
				return true;
			}
		}
		if (n.value < key) {
			if (n.right != null) {
				return insert(n.right, key);
			} else {
				n.right = new Node(key);
				return true;
			}
		}
		// value already exist!
		return false;
	}



	
	// Inorder traversal
	public void inorder(){
		if(root == null){
			return;
		}else{
			inorder(root);
		}
	}
	private void inorder(Node n){
		if(n.left != null){
			inorder(n.left);
		}
		System.out.print(n.value+ " ");
		if(n.right != null){
			inorder(n.right);
		}
	}
	
	// Pre traversal
		public void preorder(){
			if(root == null){
				return;
			}else{
				preorder(root);
			}
		}
		private void preorder(Node n){
			System.out.print(n.value+ " ");
			if(n.left != null){
				preorder(n.left);
			}
			if(n.right != null){
				preorder(n.right);
			}
		}
		
		public boolean equals(BinaryTree b){
			return equal(this.root,b.root);
		}
		
		private boolean equal(Node a, Node b){
			boolean left_flag = false;
			boolean right_flag = false;
			
			if(a.value == b.value){
				if( a.left != null && b.left != null){
					left_flag = equal(a.left,b.left);
				}
				if( a.right != null && b.right != null){
					right_flag = equal(a.right,b.right);
				}
				return (left_flag || (a.left == null && b.left == null)) && (right_flag || (a.right == null && b.right == null));
			}
			return false;
		}
		
		public int getHeight(){
			return getHeight(this.root);
		}

		private int getHeight(Node a){
			if(a == null){
				return 0;
			}
			return (1 + Math.max(getHeight(a.left), getHeight(a.right)));
		}
		
		public BinaryTree mirror(){
			BinaryTree bt = new BinaryTree();
			if(this.root != null){
				bt.root = new Node(this.root.value);
				mirror(this.root,bt.root);
			}
			return bt;
		}
		
		private void mirror(Node a, Node b){
			
			if(a.left == null){
				b.right = null;
			}else{
				b.right = new Node(a.left.value);
				mirror(a.left, b.right);
			}
			
			if(a.right == null){
				b.left = null;
			}else{
				b.left = new Node(a.right.value);
				mirror(a.right, b.left);
			}
		}
	// class ends!
}

