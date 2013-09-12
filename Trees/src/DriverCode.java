

import BinaryTrees.BinaryTree;

public class DriverCode {
	public static void main(String[] args){
		BinaryTree t = new BinaryTree(50);
		
		t.insert(70);
		t.insert(100);
		t.insert(10);
		t.insert(35);
		t.insert(60);
		t.insert(13);
		t.insert(4);
		t.insert(80);
		
		t.preorder();
		t.postorder();
		t.inorder();
		t.roworder();
	}
}
