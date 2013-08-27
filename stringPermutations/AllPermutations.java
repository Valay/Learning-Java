package stringPermutations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


// Prints all unique permutations of a string

public class AllPermutations {

	public static Set<String> perms = new HashSet<String>();
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		
		String line = null;
		try {
			line = br.readLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		perms = permutations(line);
		
		System.out.println(perms);
		System.out.println(perms.size());
	}
	
	public static Set<String> permutations(String s){
		String temp;
		
		if(s.length() == 1){
			perms.add(s);
			return perms;
		}
		
		perms = permutations(s.substring(1,s.length()));
		
		Set<String> newList = new HashSet<String>();
		
		for(String str:perms){
			temp = str;
			for(int j=0;j<temp.length()+1;j++){
				newList.add(temp.substring(0,j)+s.charAt(0)+temp.substring(j,temp.length()) );
			}
		}
		return newList;
	}
}
