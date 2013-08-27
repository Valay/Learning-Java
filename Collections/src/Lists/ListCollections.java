package Lists;

import java.util.*;

public class ListCollections {

	public static void main(String[] args) {
		int c;
		String temp;
		Random rnd = new Random(1000000000);
		List<String> l = new ArrayList<String>();
		
		for(String s: args){
			l.add(s);
		}
		
		for(int i=1;i<l.size()+1;i++){
			c = rnd.nextInt(i);
			temp = l.get(c);
			l.set(c, l.get(i-1));
			l.set(i-1,temp);
		}
		System.out.println(l);
		
		//System.out.println(s);
	}
}
