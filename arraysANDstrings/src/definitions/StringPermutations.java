package definitions;

import java.util.List;
//import java.util.ArrayList;

public class StringPermutations {

	//ArrayList<String> a = new ArrayList<String>();
	
	public void permute(String b,String s){	
			
		int n = s.length();
		if (n == 0) System.out.println(b);
		else{
			for(int i=0;i< n ;i++){
				permute(b+s.charAt(i),s.substring(0, i)+s.substring(i+1, n));
			}
		}
	}
}
