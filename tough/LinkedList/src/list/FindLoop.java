package list;

public class FindLoop {
		  public static class ListNode {
		    public int value;
		    public ListNode next;
		    
		    public ListNode(){
		    	
		    }
		  }
		 
		  public static void main(String[] args){
			  ListNode head = new ListNode();
			  head.value = 1;
				ListNode ptr = head;
				//head.next = head;
				for(int i=2;i<20;i++){
					ListNode ll = new ListNode();
					ll.value = i;
					ptr.next = ll;
					ptr = ptr.next;
				}
				
				ptr = head;
				ListNode end;
				while(ptr.value == 10){
					ptr = ptr.next;
				}
				end = ptr;
				
				while(ptr.next != null){
					ptr = ptr.next;
				}
				ptr.next = end;
				
			System.out.println(hasLoops(head));
		  }
		  
		  
		  public static boolean hasLoops( ListNode myList ) {
		      
		      // return because list is null
		      if(myList == null) 
		        return false;

		      // using Floyd's cycle finding algorithm
		    ListNode slow, fast; 

		    slow = fast = myList; // make both refer to the start of the list.

		    while(true) {

		        slow = slow.next;          // 1 hop.

		        if(fast.next != null)
		            fast = fast.next.next; // 2 hops.
		        else
		            return false;          // next node null => no loop.

		        if(slow == null || fast == null) // if either hits null..no loop.
		            return false;

		        if(slow == fast) // if the two ever meet...we must have a loop.
		            return true;
		    }
		  }
}
