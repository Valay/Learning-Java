import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.readLine().split(" ");
        
        List<Integer> nums = new ArrayList<Integer>();
        
        for(String s : str){
                nums.add(Integer.parseInt(s));
        }
        
        
        int [] arr = new int[nums.size()];
        
        int j=0;
        for(Integer i : nums){
        	arr[j] = i;
        	j++;
        }
        
        (new Solution()).qs(arr, 0, nums.size()-1);
        
//        for(int i=0;i<j;i++){
//        	System.out.print(arr[i]+" ");
//        }
        
        int min = (int)Math.pow(10, 7);
        
        List<Integer> pos = new ArrayList<Integer>();
//        System.out.println(arr.length);
        for(int i=1;i<arr.length;i++){
        	if(Math.abs(arr[i] - arr[i-1]) == min){
                pos.add(i-1);
                continue;
            }
        	
        	if(Math.abs(arr[i] - arr[i-1]) < min){
                min = Math.abs(arr[i] - arr[i-1]);
                pos.clear();
                pos.add(i-1);
            }

        }
        
//        System.out.println(min);
//        System.out.println(pos);
        
        for(int i=0;i<pos.size();i++){
            System.out.print(arr[pos.get(i)] + " " + arr[pos.get(i)+1] + " ");
        }
        
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
//    public void quicksort(List<Integer> nums, int low, int high){
//    
//        if(low >= high){
//            return;
//        }
//        
//        int pivot = low + (int) (Math.random() * (high - low) + 1);
//        
//        int pos = partition(nums, pivot, low, high);
//        quicksort(nums, low, pos-1);
//        quicksort(nums, pos+1,high);
//        
//        return;
//    }
//    
//    public int partition(List<Integer> nums, int pivot, int low, int high){
//    
//        int temp;
//        int pivotValue = nums.get(pivot);
//        
//        // swap pivot with last element in the array
//        temp = nums.get(high);
//        nums.set(high, pivotValue);
//        nums.set(pivot, temp);
//        
//        int position = low;
//        
//        int l= low,h = high;
//        
//        while(l < h){
//            if(nums.get(l) <= pivotValue){
//                //swap
//                temp = nums.get(position);
//                nums.set(position, nums.get(l));
//                nums.set(l,temp);
//                position++;
//            }
//            l++;
//        }
//        temp = nums.get(high);
//        nums.set(high, nums.get(position));
//        nums.set(position, temp);
//        
//        return position-1;
//    }
}