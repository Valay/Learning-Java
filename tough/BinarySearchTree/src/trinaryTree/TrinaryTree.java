package trinaryTree;


public class TrinaryTree {
	
	private Node root;

	private class Node {
		int value; // value = --- what the value represents
		Node left;
		Node right;
		Node center;
		
		public Node(int key) {
			this.value = key;
			this.center = null;
			this.right = null;
			this.left = null;
		}
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
			if(n.center != null){
				return insert(n.center, key);
			}else{
				n.center = new Node(key);
				return true;
			}
			
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
			}else {
				if(n.center != null){
					n.center.left = n.left;
					n.center.right = n.right;
					return n.center;
				}
				if (n.left == null) {
					return n.right;
				} else if (n.right == null) {
					return n.left;
				} else {
					// delete min from right sub-tree
					if (n.right.left != null) {
						Node temp;
						temp = n;
						n = deleteMin(n.right);
						n.left = temp.left;
						n.right = temp.right;
					} else {
						n.value = n.right.value;
						n.right = n.right.right;
					}
				}
			}
			return n;
		}

		// Delete minimum from tree
		private Node deleteMin(Node n) {
			if (n.left.left != null) {
				return deleteMin(n.left);
			} else {
				Node temp;
				temp = n.left;
				n.left = n.left.right;
				return temp;
			}
		}
	
		private void inorder(Node n){
			if(n == null){
				System.out.println("");
				return;
			}
			
			if(n.left != null){
				inorder(n.left);
			}
			Node temp = n;
			while(temp != null){
				System.out.print(temp.value+ " ");
				temp = temp.center;
			}
			if(n.right != null){
				inorder(n.right);
			}
		}	
		
	public static void main(String[] args){
		TrinaryTree t = new TrinaryTree();
		t.insert(5);
//		t.insert(4);
//		t.insert(9);
//		t.insert(5);
//		t.insert(7);
//		t.insert(2);
//		t.insert(2);
		
		t.inorder(t.root);
		t.delete(5);
		t.inorder(t.root);
		//t.delete(9);
		//t.inorder(t.root);
	}
}
