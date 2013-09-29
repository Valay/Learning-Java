import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class QuickSort{
	
	public static void main(String[] args){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String[] data = (br.readLine()).split(" ");
			Integer[] intdata = new Integer[data.length];
		
			// Adding integers to Arraylist
			for(int i=0 ; i < data.length ; i++ ){
				try{
					intdata[i]= Integer.parseInt(data[i]);
				}catch(Exception e){
						// Catch the number format exception!
						System.out.println("exception!");
				}
			}
			
			// Calling recursive insertion sort
			quick_sort(intdata,0,intdata.length-1); 
			for(int j=0; j< intdata.length; j++){
				System.out.print(intdata[j]);
				System.out.print(" ");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private static void quick_sort(Integer[] data, int left, int right){
		
		if(left < right){
			double rand = Math.random();
			int pivot = (int)(rand*(double)(right-left+1))+left;
			
			int indx = partition(data, left, right, pivot);
			quick_sort(data, left, indx-1);
			quick_sort(data, indx+1, right);
		}
	} 
	
	private static int partition(Integer[] data, int left, int right, int pivotIndx){
		int pivotValue = data[pivotIndx];
		
		//swap the pivot to the end of the array
		data[pivotIndx] = data[right];
		data[right] = pivotValue;
		
		// Store the index to swap lesser elements
		int indx=left;
		int temp=0;
		
		for(int i=left;i<=right;i++){
			if(data[i] < pivotValue){
				temp = data[indx];
				data[indx] = data[i];
				data[i] = temp;
				
				indx++;
			}
		}
		temp = data[indx];
		data[indx] = pivotValue;
		data[right] = temp;
		return indx;
	}
}