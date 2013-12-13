import java.util.List;

/* 
 * Mojority Element using Moore's voting algorithm
 * 
 */


public class MajorityElement {

	public boolean isMajor(List<Integer> nums){
		
		int x = MajorityElement.findCandidate(nums);
		// Make one pass through the list to check if this is indeed a majority element
		int count = 0;
		for(int i=0;i<nums.size();i++){
			if(nums.get(i) == x){
				count++;
			}
		}
		if( 2*count >= nums.size()){
			System.out.println(x+" : "+count);
			
			return true;
		}
		return false;
	}
	
	public static int findCandidate(List<Integer> nums){
		int n = nums.size();
		
		if(n == 1){
			return nums.get(0);
		}
		
		int major = nums.get(0);
		int count = 1;
		for(int i=1;i<n;i++){
			if(nums.get(i) == major){
				count++;
			}else{
				count--;
			}
			
			if(count == 0){
				major = nums.get(i);
				count = 1;
			}
		}
		return major;
	}
}
