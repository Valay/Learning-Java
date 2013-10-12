import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

class PivotIndex
{

	// Will not work for some corner cases
	public static int findPivot2(List<Integer> list){
		int leftptr, rightptr;
		int leftsum, rightsum;
		
		// Handling the base cases
		
		if(list.size() == 0 || list.size() == 1){
			return -1;
		}
		
		// Initialize the variables
		leftptr = 0;
		rightptr = list.size()-1;
		
		leftsum = list.get(leftptr);
		rightsum = list.get(rightptr);
		
		// Find the pivot element
		while(leftptr+1 <= rightptr-1){
			
			System.out.println(leftsum+"   "+rightsum);
			
			if(leftsum == rightsum){
				if(leftptr+1 == rightptr-1){
					return leftptr+1;
				}
				else{
					// Pivot is somewhere in the smaller list
					int x = findPivot(list.subList(leftptr+1,rightptr-1));
					if(x == -1){
						return -1;
					}else{
						return leftptr+x;
					}
				}
			}
			
			if(leftsum < rightsum){
				leftptr++;
				leftsum += list.get(leftptr);
			}else{
				rightptr--;
				rightsum += list.get(rightptr);
			}
		}
		return -1;
	}
	
	// Will work for every case and is more elegant!
	public static int findPivot1(List<Integer> list){
		
		// Base case
		if(list.size() == 0){
			return -1;
		}
		
		int sum_of_list=0;
		for(int i=0;i<list.size();i++){
			sum_of_list += list.get(i);
		}
		
		int running_sum=0, sum_right;
		for(int i=0;i<list.size();i++){
			
			sum_right = sum_of_list - list.get(i) - running_sum;
			
			if(sum_right == running_sum){
				return i;
			} 
			
			running_sum += list.get(i);
		}
		return -1;
	}

	// Read in the integer array
	public static void main(String args[]){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String s = br.readLine();    // Read from command line
		
			String tokens[] = s.split("[ ]+");
			List<Integer> list = new ArrayList<Integer>();  // create arraylist to store list of integers
		
			for(String token : tokens){
				if(!token.equals("")){
					list.add(Integer.parseInt(token));   // fill up the list
				}
			}
		
			System.out.println(findPivot1(list));   // call findPivot()
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}