package list;

public class LinkedList<T> {
	
	T data;
	LinkedList<T> next;
	
	public LinkedList(T a){
		data = a;
	}
	
	public T getData(){
		return this.data;
	}
	
	public void setData(T a){
		data = a;
	}
}
