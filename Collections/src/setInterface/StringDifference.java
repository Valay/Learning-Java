package setInterface;

import java.util.*;

public class StringDifference {
	
	public static void main(String[] args) {
		
		Map<Character,Integer> s1 = new LinkedHashMap<Character,Integer>();
		Map<Character,Integer> s2 = new LinkedHashMap<Character,Integer>();
		
		for(int i=0;i<args[0].length();i++){
			Integer j = s1.get(args[0].charAt(i));
			s1.put(args[0].charAt(i), j==null? 1:j+1);
		}
		
		for(int i=0;i<args[1].length();i++){
			Integer j = s2.get(args[1].charAt(i));
			s2.put(args[1].charAt(i), j==null? 1:j+1);
		}
		System.out.println(args[0].substring(0, 1));
		System.out.println(s1);
		System.out.println(s2);
		s1.keySet().removeAll(s2.keySet());
		System.out.println(s1);
	}
}
