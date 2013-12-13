package BinaryST;
public class BST {

	private Node root;

	private class Node {
		int value; // value = --- what the value represents
		//boolean b; // b = true => black node, b = false => red node! (for
					// Red-black Tree)
		int count; // count = number of nodes in subtree rooted at this node!
		Node left;
		Node right;

		public Node(int key) {
			this.value = key;
			this.right = null;
			this.left = null;
		}
	}
	
//	public void inorderSuccessor(){
//		inorderSuccessor(root, (Node)null);
//	}
//	
//	private void inorderSuccessor(Node r, Node x){
//		if(r == null){
//			return;
//		}else{
//			inorderSuccessor(r.right,x);
//			r.next = x;
//			x = r;
//			inorderSuccessor(r.left,x);
//		}
//	}
	// size
	public int size() {
		return root.count;
	}

	// isBalanced
	public boolean isBalanced() {
		return isBalanced(root);
	}

	private boolean isBalanced(Node n) {
		if (Math.abs(n.left.count - n.right.count) <= 1) {
			return true;
		}
		return false;
	}

	// isValid (check validation of Binary Search Tree
	public boolean isValid() {
		return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValid(Node n, int min, int max) {
		if (n.value > min && n.value < max) {
			return (isValid(n.left, min, n.value) && isValid(n.right, n.value,
					max));
		}
		return false;
	}

	// Implementation of isValid using Inorder traversal!

	// Insert into AVL tree
	public void insertAVL(int key) {
		if (root == null) {
			root = new Node(key);
			root.count = 1;
		} else {
			insertAVL(root, key);
		}
	}

	private void insertAVL(Node n, int key) {
		if (n.value == key) {
			System.out.println("Key Exist!");
			return;
		} else if (n.value > key) {
			if (n.left != null) {
				insertAVL(n.left, key);
			} else {
				n.left = new Node(key);
				n.left.count = 1;
				n.count += 1;
				return;
			}
		} else if (n.value < key) {
			if (n.right != null) {
				insertAVL(n.right, key);
			} else {
				n.right = new Node(key);
				n.right.count = 1;
				n.count += 1;
				return;
			}
		}
		// Okay the node is inserted 
		// Check if the tree is Balanced!
		if( count(n.left) - count(n.right) < 1){
			// The tree is right heavy
			if(n.right.left != null && n.right.right != null && count(n.right.left) - count(n.right.right) > 1){
				// Trees right subtree is left heavy --- perform double left rotation
				// rotate through trees right node
				n.right = rotateRight(n.right);
			}
			// perform single left rotation
			n = rotateLeft(n);
		}else if( count(n.left) - count(n.right) > 1){
			// The tree is left heavy
			if(n.left.left != null && n.left.right != null && count(n.left.left) - count(n.left.right) < 1){
				// Trees right subtree is left heavy --- perform double left rotation
				// rotate through trees right node
				n.left = rotateLeft(n.left);
			}
			// perform single left rotation
			n = rotateRight(n);
		}
		n.count = count(n.left) + count(n.right) + 1;
	}

	private int count(Node n){
		if(n == null){
			return 0;
		}else{
			return n.count;
		}
	}
	private Node rotateRight(Node n){
		Node temp;
		temp = n.left;
		n.left = n.left.right;
		temp.right = n;
		return temp;
	}
	
	private Node rotateLeft(Node n){
		Node temp;
		temp = n.right;
		n.right = n.right.left;
		temp.left = n;
		return temp;
	}
	
	// Delete from AVL tree
	public void deleteAVL(int key) {

	}

	// Inserting into BST
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

	// Deleting value from BST
	public void delete(int key) {
		root = delete(root, key);
	}

	private Node delete(Node n, int key) {
		if (key > n.value) {
			if (n.right != null) {
				n.right = delete(n.right, key);
			} else {
				// raise exception!
				// throw new ElementNotFoundException();
				System.out.println("Element Not Found!");
			}
		} else if (key < n.value) {
			if (n.left != null) {
				n.left = delete(n.left, key);
			} else {
				// raise exception
				// throw new ElementNotFoundException();
				System.out.println("Element Not Found");
			}
		} else {
			if (n.left == null) {
				return n.right;
			} else if (n.right == null) {
				return n.left;
			} else {
				// delete min from right sub-tree
				if (n.right.left != null) {
					n.value = deleteMin(n.right);
				} else {
					n.value = n.right.value;
					n.right = n.right.right;
				}
			}
		}
		return n;
	}

	// Delete minimum from tree
	private int deleteMin(Node n) {
		int temp;
		if (n.left.left != null) {
			return deleteMin(n.left);
		} else {
			temp = n.left.value;
			n.left = n.left.right;
			return temp;
		}
	}

	// Searching for an element into BST
	public boolean search(int key) {
		return search(root, key);
	}

	private boolean search(Node n, int key) {
		if (n != null) {
			if (n.value == key) {
				return true;
			} else if (n.value < key) {
				return search(n.right, key);
			} else {
				return search(n.left, key);
			}
		}
		// element not found!
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

	// class ends!
}
