package Maps;

import java.util.*;

public class MapInterface {

	public static void main(String[] args) {
		Map<String,Integer> h = new LinkedHashMap<String,Integer>();
		
		for(String s:args){
			Integer i = h.get(s);
			h.put(s, i==null?1:i+1);
		}
		
		System.out.println(h);
			
	}
}
