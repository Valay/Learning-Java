import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MaximumSubarray{
	public static void main(String[] args){
		Integer[] ret_values = new Integer[3];
		try{
			
			// Test example : 100 113 110 85 105 102 86 63 81 101 94 106 101 79 94 90 97
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] StockData;
			StockData = (br.readLine()).split(" ");
		
			Integer[] Stock = new Integer[StockData.length];
			Integer[] difference = new Integer[StockData.length];	
			difference[0] = 0;

			for( int i=0; i<StockData.length; i++ ){
				Stock[i] = Integer.parseInt(StockData[i]); 
			}

			for( int i=1; i<Stock.length; i++ ){
				difference[i] = Stock[i] - Stock[i-1]; 
			}		

			//ret_values = maximumSubarray(difference,1,difference.length-1);
			ret_values = maximumSubarrayLinearTime(difference,1,difference.length-1);
			
			System.out.println("The max sum is "+ret_values[0]+ " with start "+ret_values[1]+" and end "+ret_values[2]);
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	// This is linear time solution
	private static Integer[] maximumSubarrayLinearTime(Integer[] diff, int start, int end){
		int sum = 0;
		int left = 0;
		int right = 0;
		Integer[] max_so_far = new Integer[3];
		max_so_far[0] = 0;
		
		
		for(int i=start; i<= end; i++){
			sum += diff[i];
			if(sum <= 0){
				left = i;
				sum = 0;
				right = i+1;
			}
			
			if (sum > 0){
				right = i;
			}
			
			if (sum >= max_so_far[0]){
				max_so_far[1] = left;
				max_so_far[0] = sum;
				max_so_far[2] = right;
			}
		}
		if (max_so_far[0] == 0){
			max_so_far[1] = max_so_far[2] = 0;	
		}
		return max_so_far;
		
		// or follow this link http://en.wikipedia.org/wiki/Maximum_subarray_problem 
		// Look at the c++ algorithm!
	}
	
	
	// This function takes O(n*logn) time  Note: It returns max_left pointer as starting point of next number which is higher
	private static Integer[] maximumSubarray(Integer[] diff, int start, int end){
		if (end == start){
			Integer[] ret = new Integer[3];
			ret[0] = diff[start];
			ret[1] = start;
			ret[2] = end;
			return ret;
		}
		
		int mid;
		
		Integer[] LeftArray;
		Integer[] RightArray;
		Integer[] CrossArray;

		mid = (int) Math.floor(( (double)end + (double)start)/2.0);

		LeftArray = maximumSubarray(diff,0,mid);
		
		RightArray = maximumSubarray(diff,mid+1,end);

		CrossArray = maximumCrossSubarray(diff,start,mid,end);

		if (LeftArray[0] > RightArray[0] && LeftArray[0] > CrossArray[0])
			return LeftArray;

		if (RightArray[0] > LeftArray[0] && RightArray[0] > CrossArray[0])
			return RightArray;

		return CrossArray;
	}

	private static Integer[] maximumCrossSubarray(Integer[] diff, int start, int mid, int end){
		Integer[] results = new Integer[3];
		int left_sum = Integer.MIN_VALUE;
		int right_sum = Integer.MIN_VALUE;
		int max_left=mid,max_right=mid+1;
		int sum = 0;
		
		// Find max-sum on left side
		for(int i=mid; i>=start; i--){
			sum = sum + diff[i];
			if (sum > left_sum){
				left_sum = sum;
				max_left = i;
			}
		}
		sum = 0;
		// Find max-sum on right side
		for(int j=mid+1; j<=end; j++){
			sum = sum + diff[j];
			if (sum > right_sum){
				right_sum = sum;
				max_right = j;
			}
		}
		results[0] = left_sum + right_sum;
		results[1] = max_left;
		results[2] = max_right;
		return results;
	}
}

