import java.util.List;


public class OddOccurence {
	
	public int odd(List<Integer> nums){
		
		int x=nums.get(0);
		
		for(int i=1;i<nums.size();i++){
			x = x ^ nums.get(i);
		}
		
		return x;
	}
}
