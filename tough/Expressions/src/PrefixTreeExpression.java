import BinaryTree.Tree;

public class PrefixTreeExpression {
	
	public static void main(String args[]){
		
		
		String s = "*+36+42";
		Tree t = new Tree();
		
		t.createPrefixTree(s);
		
		t.inorder();
	}
}
