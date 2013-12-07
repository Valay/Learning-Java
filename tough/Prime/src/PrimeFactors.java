import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class PrimeFactors {

	public static void main(String[] args){
			int n = 24;
			PrimeFactors pf = new PrimeFactors();
			pf.printFactors(n);
			
		}
	
	public void printFactors(int n){
		System.out.println("1 * "+n);
		Set<TreeSet<Integer>> treeset = fetchFactors(n);
//		for(TreeSet<Integer> ts : treeset){
//			for(Integer i : ts){
//				System.out.print(i+" * ");
//			}
//			System.out.println("\r\r\r\n");
//		}
	}
	
	private Set<TreeSet<Integer>> fetchFactors(int n){
		Set<TreeSet<Integer>> s = new HashSet<TreeSet<Integer>>();
		if(n == 1){
			TreeSet<Integer> temp = new TreeSet<Integer>();
			temp.add(1);
			s.add(temp);
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
			Set<TreeSet<Integer>> sts = fetchFactors(mul);
			if(sts.isEmpty()){
				TreeSet<Integer> temp = new TreeSet<Integer>();
				temp.add(cur);
				sts.add(temp);
			}
			System.out.println(sts);
			for(TreeSet<Integer> temp : sts){
				TreeSet<Integer> ts = new TreeSet<Integer>(temp);
				ts.add(cur);
				s.add(ts);
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
