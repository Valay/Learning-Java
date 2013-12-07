import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class PrimeFactors {

	public static void main(String[] args){
			System.out.println(args[0]+" "+args[1]);
			int n = Integer.parseInt(args[1]);
			PrimeFactors pf = new PrimeFactors();
			pf.printFactors(n);
		}
	
	public void printFactors(int n){
		System.out.println("1 * "+n);
		Set<ArrayList<Integer>> treeset = fetchFactors(n);
		for(ArrayList<Integer> ts : treeset){
			System.out.print(ts.get(0));
			for(int i=1;i<ts.size();i++){
				System.out.print(" * "+ts.get(i));
			}
			System.out.print("\n");
		}
	}
	
	private Set<ArrayList<Integer>> fetchFactors(int n){
		Set<ArrayList<Integer>> s = new HashSet<ArrayList<Integer>>();
		if(n == 1){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			s.add(temp);
			return s;
		}
		
		Set<Integer> factors = this.getFactors(n);
		//System.out.println(factors);
		Iterator<Integer> it = factors.iterator();
		it.next(); // skip 1
		int cur,mul;
		while(it.hasNext()){
			cur = it.next();
			mul = n/cur;
			//System.out.println(cur+" "+mul);
			Set<ArrayList<Integer>> sts = fetchFactors(mul);

			for(ArrayList<Integer> temp : sts){
				ArrayList<Integer> ts = new ArrayList<Integer>(temp);
				ts.add(cur);
				Collections.sort(ts);
				//System.out.println(ts);
				s.add(ts);
			}
			// also add the cur and mul to the list
			if(mul != 1){
				ArrayList<Integer> cm = new ArrayList<Integer>();
				cm.add(cur);
				cm.add(mul);
				Collections.sort(cm);
				s.add(cm);
			}
		}
		return s;
	}
	
	public TreeSet<Integer> getFactors(int n){
		int counter=1;
		if(n%2 !=0){
			counter = 2;;
		}
		
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for(int i=1;i<=(n/2);i=i+counter){
			if(n%i == 0){
				ts.add(i);
			}
		}
		
		if(ts.size() == 1){
			ts.add(n);
		}
		return ts;
	}
}
