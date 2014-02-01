package QuickSort;

public class Quicksort {

	public int[] quicksort(int[] array){
		qs(array, 0, array.length-1);
		return array;
	}
	
	public int partition(int[] array,int left, int right, int pivotIndex ){
		//System.out.println(right);
		int pivotValue = array[pivotIndex];
		int temp = array[right];
		array[right] = pivotValue;
		array[pivotIndex] = temp;
		
		int storeIndex = left;
		
		for(int i=left; i<= right-1; i++){
			if(array[i] <= pivotValue){
				temp = array[storeIndex];
				array[storeIndex] = array[i];
				array[i] = temp;
				storeIndex++;
			}
		}
		temp = array[storeIndex];
		array[storeIndex] = pivotValue;
		array[right] = temp;
		
		return storeIndex;
	}
	
	private void qs(int[] array,int left, int right){
		//System.out.println(right);
		if(left < right){
			int pivot = left + (int) ( Math.random() * ((right - left)+1) );
			
			int pivotIndex = partition(array, left, right, pivot);
			
			qs(array, left, pivotIndex-1);
			qs(array,pivotIndex+1,right);
		}
	}
}
