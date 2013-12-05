import BinaryST.BST;
import BinaryTree.BinaryTree;

public class Driver {

	public static void main(String args[]){
		
//		BST b = new BST();
//		b.insertAVL(8);
//		b.insertAVL(5);
//		b.insertAVL(10);
//		b.insertAVL(11);
//		b.insertAVL(9);
//		b.insertAVL(12);
//		b.insertAVL(1);
//		b.insertAVL(5);
//		b.insertAVL(4);
//		b.insertAVL(13);
//		b.insertAVL(17);
//		b.insertAVL(3);
//		b.insertAVL(7);
//		b.insertAVL(6);
//		
//		b.inorder();
//		b.preorder();
		
		
		BinaryTree bt1 = new BinaryTree();
		BinaryTree bt2 = new BinaryTree();
		
		bt1.insert(8);
		bt1.insert(5);
		bt1.insert(10);
		bt1.insert(11);
		bt1.insert(9);
		bt1.insert(12);
		bt1.insert(1);
		bt1.insert(5);
		bt1.insert(4);
		bt1.insert(13);
		bt1.insert(17);
		bt1.insert(3);
		bt1.insert(7);
		bt1.insert(6);
		
		bt2.insert(8);
		bt2.insert(5);
		bt2.insert(10);
		bt2.insert(11);
		bt2.insert(9);
		bt2.insert(12);
		bt2.insert(1);
		bt2.insert(5);
		bt2.insert(4);
		bt2.insert(13);
		bt2.insert(17);
		bt2.insert(3);
		bt2.insert(7);
		bt2.insert(6);
		
		System.out.println(bt1.equals(bt2));
		System.out.println(bt1.getHeight());
		
		BinaryTree bt3 = bt1.mirror();
		bt1.inorder();
		System.out.println(" ");
		bt3.inorder();
	}
	
}
