import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class AmazonQuestion {
    
	public static void main(String[] args){
		
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		//[4, 2, 73, 11, -5] and [-5, 73, -1, 9, 9, 4, 7]
		a.add(4);
		a.add(2);
		a.add(73);
		a.add(11);
		a.add(-5);
		
		b.add(-5);
		b.add(73);
		b.add(-1);
		b.add(9);
		b.add(9);
		b.add(4);
		b.add(7);
		
		System.out.println(intersection(a,b));
		
	}
	
	public static List<Integer> intersection (List<Integer> a, List<Integer> b) {
 
		Set<Integer> s = new HashSet<Integer>(a);
		
		s.retainAll(b);
		//s.clear();
		List<Integer> x = new ArrayList<Integer>(s);
		
		return x;
		
    }
}