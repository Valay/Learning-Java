package list;

public class LinkedList<T> {
	
	LL<T> head = null;
	
	private class LL<T>{
		T data;
		LL<T> next;
		
		public LL(T a){
			this.data = a;
			this.next = null;
		}
	}
	
	public void reverseList(){
		if(this.head == null){
			return;
		}
		LL<T> cur = this.head;
		LL<T> prev = null;
		LL<T> nxt = cur.next;
		
		while(cur != null){
			cur.next = prev;
			prev = cur;
			if(nxt != null){
				cur = nxt;
				nxt = cur.next;
			}else{
				head = cur;
				return;
			}
		}
		return;
	}
	
	public void insertHead(T a){
		if(head == null){
			head = new LL<T>(a);
			return;
		}
		LL<T> newnode = new LL<T>(a);
		newnode.next = head;
		head = newnode;
	}
	
	public void insertTail(T a){
		LL<T> newnode = new LL<T>(a);
		if(head == null){
			head = newnode;
			return;
		}
		LL<T> temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = newnode;
		return;
	}
	
	public T deleteHead(){
		if(head != null){
			T temp = head.data;
			head = head.next;
			return temp;
		}
		return null;
	}
	
	public void delete(T a){
		if(head == null){
			return;
		}
		
		if(head.data == a){
			head = head.next;
			return;
		}
		
		LL<T> temp = head;
		while(temp.next != null){
			if(temp.next.data == a){
				temp.next = temp.next.next;
				return;
			}
			temp = temp.next;
		}
	}
	
	public T getMiddle(){
		LL<T> temp1 = head;
		LL<T> temp2 = head;
		T b = null;
		while(temp2 != null){
			if(temp2.next == null){
				b = temp1.data;
				break;
			}
			temp2 = temp2.next;
			if(temp2.next == null){
				b = temp1.data;
				break;
			}
			temp2 = temp2.next;
			temp1 = temp1.next;
		}
		
		return b;
	}
	
	public void print(){
		LL<T> temp = head;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		return;
	}
}
