import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class RecursiveInsertionSort{
	
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
			insertion_sort(intdata,intdata.length-1); 
			for(int j=0; j< intdata.length; j++){
				System.out.print(intdata[j]);
				System.out.print(" ");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private static void insertion_sort(Integer[] data, int key_index){
		if (key_index != 0){
			insertion_sort(data, key_index-1);
		}
		int key = data[key_index];
		for(int i=key_index-1; i>=0 ; i--){
			if (data[i] > key){
				data[i+1] = data[i];
			}
			else{
				data[i+1] = key;
				break;
			}
		}
		return;
	}
}