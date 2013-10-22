import BinaryST.BST;

public class Driver {

	public static void main(String args[]){
		
		BST b = new BST();
		b.insertAVL(8);
		b.insertAVL(5);
		b.insertAVL(10);
		b.insertAVL(11);
		b.insertAVL(9);
		b.insertAVL(12);
		b.insertAVL(1);
		b.insertAVL(5);
		b.insertAVL(4);
		b.insertAVL(13);
		b.insertAVL(17);
		b.insertAVL(3);
		b.insertAVL(7);
		b.insertAVL(6);
		
		b.inorder();
		b.preorder();
	}
	
}
