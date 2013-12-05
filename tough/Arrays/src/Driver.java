import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Driver {
	
	// General test case:
	/*
	 * 5 10 3 0 -1 7 -5 8 -4 2 -100 -49 56 78 21 94 50 -43 65 -2 32 45 
	 * 
	 * 4 7 67 89 23 12 34 9 56 8 2 3 5 0 8 6 34 1 2 4 9 7 7
	 * 
	 * 1 9 2 8 3 7 4 6 5 
	 * 
	 * 
	 */
	
	public static void main(String[] args){
		String[] numbers = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			numbers = br.readLine().split(" ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Integer> nums = new ArrayList<Integer>();
		for(String s:numbers){
			nums.add(Integer.parseInt(s));
		}
		
		/*
		 * Majority Test
		 * 5 4 6 7 5 3 5 5 2 5 5 7 5 8 5 5 1 1
		 * 3 4 5 9 9 7 8 2 1 2 0 3 4 8 5 4 1
		 */
		MajorityElement me = new MajorityElement();
		System.out.println(me.isMajor(nums));
		
		// call functions that uses array
		
	}
	
}
