
import java.util.*;

public class FindDups {
	
	public static void main(String[] args) {
		List<Integer> i = new ArrayList<Integer>();
		for(String s:args){
			i.add(Integer.parseInt(s));
		}
		
		findDups(i);
	}
	
	public static void findDups(List<Integer> args){
		
		// Use HashSet or LinkedHashSet or TreeSet
		
		Set<Integer> dups = new HashSet<Integer>();
		//Set<String> dups = new TreeSet<String>();
		//Set<String> dups = new LinkedHashSet<String>();
	
		for(Integer s: args){
			if(!dups.add(s)){
				System.out.println("Duplicate :"+s);
			}
		}
		System.out.println("Count:"+dups.size()+dups);
	}

}
