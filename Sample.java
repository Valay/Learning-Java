import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

class Sample{
	
	private int x;
	
	public int getIndex(){
		return x;
	}
	
	public String toString(){
		return ("Object :" + x);
	}
	public static void main(String args[]){
		
// Primitive data types 		
		// Sample s = new Sample();
// 		System.out.println(s.x);
// 		System.out.println(s);
// 		double value = 254.5443534534;
// 		
// 		Double i = value;
// 		System.out.println(i.floatValue());
// 		System.out.println(i.byteValue());
// 		System.out.println(i.doubleValue()); 
// 		System.out.println(i.longValue());
// 		System.out.println(i.shortValue());
// 		
// 		System.out.println(i.compareTo( 254.00));	
// 		
// 		String str = "02343";
// 		Integer in = new Integer(0);
// 		
// 		System.out.println(in.decode(str));	
		
		
// Set operations!
		Collection<Integer> c = new ArrayList<Integer>();
		
		c.add(4);
		c.add(6);
		c.add(6);
		c.add(3);
		c.add(5);
		c.add(2);
		c.add(5);
		c.add(0);
		
		Set<Integer> set = new HashSet<Integer>(c);
		Set<Integer> set2 = new HashSet<Integer>(c);
		
		set2.add(9);
		set2.add(1);
		
		// System.out.println(set);
// 		//String s = s.toString
// 		System.out.println(set.hashCode());
// 		
// 		System.out.println(set2.retainAll(set));
// 		System.out.println(set2);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(6);
		list.add(6);
		list.add(3);
		list.add(5);
		list.add(2);
		list.add(5);
		list.add(0);
		
		List<Integer> li = list.subList(2,5);
		
		// System.out.println(li);
// 		System.out.println(list);
// 		
// 		list.remove(li.add(3));
// 		
// 		System.out.println(li);
// 		System.out.println(list);

		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		m.put(1,2);
		m.put(2,3);
		m.put(3,4);
		m.put(4,5);
		m.put(5,6);
		m.put(6,1);
		
		System.out.println(m);
		
		for(Map.Entry<Integer, Integer> e : m.entrySet()){
			System.out.println(e);
		}
		
		for(Iterator<Map.Entry<Integer, Integer>> it = m.entrySet().iterator(); it.hasNext() ;){
			Map.Entry<Integer, Integer> es = it.next();
			if(es.getKey() == 1){
				it.remove();
			}
		}
		
		System.out.println(m);
	}
}