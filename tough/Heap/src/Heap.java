
import java.util.ArrayList;
import java.util.List;

/** Implementation of max MaxHeap*/
/*
 * 
 */
class MaxHeap
{
	
	private List<Integer> MaxHeap = new ArrayList<Integer>();
	
	public boolean isEmpty(){
		if(MaxHeap.isEmpty()){
			return true;
		}
		return false;
	}
	
	public void MaxHeapAdd(int a){
		MaxHeap.add(a);
		int index = MaxHeap.size()-1;
		MaxHeapifyUp(index);
	}
	
	private void MaxHeapifyUp(int ci){
		// get parent index;
		int pi = (int)Math.floor(((double)ci-1.0)/2.0);;
		
		// MaxHeapify!
		while(pi >= 0){
			if(MaxHeap.get(pi) < MaxHeap.get(ci)){
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
		temp = MaxHeap.get(a);
		MaxHeap.set(a, MaxHeap.get(b));
		MaxHeap.set(b,temp);
	}
	
	private boolean MaxHeapifyDown(int pi){
		// get children indexes;
		
		int L = 2*pi + 1;
		int R = 2*pi + 2;
		
		
		if(MaxHeap.size() > L && MaxHeap.get(L) > MaxHeap.get(pi)){
			swap(L, pi);
			MaxHeapifyDown(L);
		}
		
		if(MaxHeap.size() > R && MaxHeap.get(R) > MaxHeap.get(pi)){
			swap(R, pi);
			MaxHeapifyDown(R);
		}
		return true;
	}
	
	// Always remove the top - highest priority element of the MaxHeap
	public int MaxHeapRemove(){
		if(MaxHeap.isEmpty()){
			return -1;
		}
		int ret_value = MaxHeap.get(0);
		if(MaxHeap.size() != 1){
			MaxHeap.set(0, MaxHeap.remove(MaxHeap.size()-1));
			// MaxHeapify
			MaxHeapifyDown(0);
		}
		else
			MaxHeap.remove(0);
		return ret_value;
	}
	
	// Returns the highest priority element without removing it
	public int MaxHeapPoll(){
		return MaxHeap.get(0);
	}

	public static void main(String args[]){
		
		MaxHeap h = new MaxHeap();
		
		h.MaxHeapAdd(5);
		h.MaxHeapAdd(9);
		h.MaxHeapAdd(6);
		h.MaxHeapAdd(1);
		h.MaxHeapAdd(4);
		h.MaxHeapAdd(2);
		h.MaxHeapAdd(7);
		h.MaxHeapAdd(8);
		//h.MaxHeapAdd(4);
		h.MaxHeapAdd(3);
		h.MaxHeapAdd(0);
		//h.MaxHeapAdd(1);
		
		System.out.println(h.MaxHeap);
		//System.out.println(h.MaxHeap.size());
		System.out.println(h.MaxHeapRemove());
		System.out.println(h.MaxHeapPoll());
		
		while(!h.isEmpty()){
			System.out.println(h.MaxHeapRemove());
		}
		
		h.MaxHeapAdd(6);
		h.MaxHeapAdd(1);
		h.MaxHeapAdd(4);
		h.MaxHeapAdd(2);
		h.MaxHeapAdd(7);
		
		while(!h.isEmpty()){
			System.out.println(h.MaxHeapRemove());
		}
	}

}