package BST;

public class LinkedListToBalancedBST {

	public static void main(String[] args){
		
		Linklist head = new Linklist();
		Linklist ptr = head;
		for(int i=1;i<20;i++){
			Linklist ll = new Linklist();
			ll.value = i;
			ptr.next = ll;
			ptr = ptr.next;
		}
		
		
		BSTnode root = constructBalancedBST(head);
		
		inorder(root);
	}
	
	public static int listlength(Linklist head){
		int count=0;
		Linklist ptr = head;
		while(ptr != null){
			count++;
			ptr = ptr.next;
		}
		return count;
	}
	
	public static BSTnode constructBalancedBST(Linklist head){
		int end = listlength(head);
		int start = 0;
		//System.out.println(end);
		BSTnode root = SortedLLToBalancedBST(head, start, end-1);
		return root;
		
	}
	
	public static BSTnode SortedLLToBalancedBST(Linklist ptr, int start, int end){
		
		if(end <= start){
			return null;
		}
		int mid = start + (int)Math.ceil( ((double)end - (double)start) / 2.0 ) ;
		
		BSTnode left = SortedLLToBalancedBST(ptr, start, mid-1);
		BSTnode root = new BSTnode();
		root.value = ptr.value;
		root.left = left;
		ptr = ptr.next;
		BSTnode right = SortedLLToBalancedBST(ptr, mid+1, end);
		root.right = right;
		
		return root;
	}
	
	public static void inorder(BSTnode root){
		inorder(root.left);
		System.out.print(root.value+ " ");
		inorder(root.right);
	}
}

