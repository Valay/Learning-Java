
import java.util.ArrayList;
import java.util.List;


class Heap
{
	
	private List<Integer> heap = new ArrayList<Integer>();
	
	public boolean isEmpty(){
		if(heap.isEmpty()){
			return true;
		}
		return false;
	}
	
	public void heapAdd(int a){
		heap.add(a);
		int index = heap.size()-1;
		heapifyUp(index);
	}
	
	private void heapifyUp(int ci){
		// get parent index;
		int pi = (int)Math.floor(((double)ci-1.0)/2.0);;
		
		// heapify!
		while(pi >= 0){
			if(heap.get(pi) < heap.get(ci)){
				swap(pi,ci);
				ci = pi;
				pi = (int)Math.floor(((double)ci-1.0)/2.0);
			}else{
				return;
			}
		}
	}
	
	private void swap(int a, int b){
		int temp;
		temp = heap.get(a);
		heap.set(a, heap.get(b));
		heap.set(b,temp);
	}
	
	private boolean heapifyDown(int pi){
		// get children indexes;
		
		int L = 2*pi + 1;
		int R = 2*pi + 2;
		
		
		if(heap.size() > L && heap.get(L) > heap.get(pi)){
			swap(L, pi);
			heapifyDown(L);
		}
		
		if(heap.size() > R && heap.get(R) > heap.get(pi)){
			swap(R, pi);
			heapifyDown(R);
		}
		return true;
	}
	
	// Always remove the top - heighest priority element of the heap
	public int heapRemove(){
		if(heap.isEmpty()){
			return -1;
		}
		int ret_value = heap.get(0);
		if(heap.size() != 1){
			heap.set(0, heap.remove(heap.size()-1));
			// heapify
			heapifyDown(0);
		}
		else
			heap.remove(0);
		return ret_value;
	}
	
	// Returns the highest priority element without removing it
	public int heapPoll(){
		return heap.get(0);
	}

	public static void main(String args[]){
		
		Heap h = new Heap();
		
		h.heapAdd(5);
		h.heapAdd(9);
		h.heapAdd(6);
		h.heapAdd(1);
		h.heapAdd(4);
		h.heapAdd(2);
		h.heapAdd(7);
		h.heapAdd(8);
		//h.heapAdd(4);
		h.heapAdd(3);
		h.heapAdd(0);
		//h.heapAdd(1);
		
		System.out.println(h.heap);
		//System.out.println(h.heap.size());
		System.out.println(h.heapRemove());
		System.out.println(h.heapPoll());
		
		while(!h.isEmpty()){
			System.out.println(h.heapRemove());
		}
		
		h.heapAdd(6);
		h.heapAdd(1);
		h.heapAdd(4);
		h.heapAdd(2);
		h.heapAdd(7);
		
		while(!h.isEmpty()){
			System.out.println(h.heapRemove());
		}
	}

}