import java.util.ArrayList;
import java.util.List;


public class MinHeap<T> implements Comparable<T> {

	List<T> heap = new ArrayList<T>();

	public boolean isEmpty(){
		if(heap.isEmpty()){
			return true;
		}
		return false;
	}
	
	public void heapAdd(T a){
		heap.add(a);
		int index = heap.size()-1;
		heapifyUp(index);
	}
	
	// Always remove the top - highest priority element of the heap
		public T heapRemove(){
			if(heap.isEmpty()){
				return null;
			}
			T ret_value = heap.get(0);
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
		public T heapPoll(){
			return heap.get(0);
		}
		
		private void swap(int a, int b){
			T temp;
			temp = heap.get(a);
			heap.set(a, heap.get(b));
			heap.set(b,temp);
		}
		
		public void heapifyDown(int pi){
			int L = 2*pi+1;
			int R = 2*pi+2;
			
			if(L < heap.size() && heap.get(pi) > heap.get(L) ){
				swap(pi,L);
				heapifyDown(L);
			}
			
			if(R < heap.size() && heap.get(pi) > heap.get(R) ){
				swap(pi,R);
				heapifyDown(R);
			}
		}
		
		public void heapifyUp(int idx){
			int pi = (int)Math.floor((idx -1)/2.0);
			
			if(pi >= 0){
				if(heap.get(pi) > heap.get(idx)){
					swap(pi,idx);
					heapifyUp(pi);
				}
			}
		}

		@Override
		public int compareTo(T o) {
			if()
			return 0;
		}
		
//		public static void main(String[] args){
//			MinHeap h = new MinHeap();
//			
//			h.heapAdd(5);
//			h.heapAdd(9);
//			h.heapAdd(6);
//			h.heapAdd(1);
//			h.heapAdd(4);
//			h.heapAdd(2);
//			h.heapAdd(7);
//			h.heapAdd(8);
//			//h.heapAdd(4);
//			h.heapAdd(3);
//			h.heapAdd(0);
//			//h.heapAdd(1);
//			
//			//System.out.println(h.heap);
//			//System.out.println(h.heap.size());
//			System.out.println(h.heapRemove());
//			System.out.println(h.heapPoll());
//			
//			while(!h.isEmpty()){
//				System.out.println(h.heapRemove());
//			}
//			
//			h.heapAdd(6);
//			h.heapAdd(1);
//			h.heapAdd(4);
//			h.heapAdd(2);
//			h.heapAdd(7);
//			
//			while(!h.isEmpty()){
//				System.out.println(h.heapRemove());
//			}
//		}
	
}
