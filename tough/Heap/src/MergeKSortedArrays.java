import java.util.ArrayList;
import java.util.List;



public class MergeKSortedArrays {

	public static void main(String[] args){
		
		List<List<Integer>> arrList =  new ArrayList<List<Integer>>();
		
		for(int i=0 ; i< 10; i++){
			List<Integer> a = new ArrayList<Integer>();
			
			for(int j=0;j<7; j++){
				int rand = 1 + (int)(Math.random() * (10));
				//System.out.println(rand);
				a.add(rand);
			}
			arrList.add(a);
		}
		
		System.out.println(arrList);
		
		MinHeap heap = new MinHeap();
		
		for(List<Integer> a : arrList){
			
		}
		
	}
}
