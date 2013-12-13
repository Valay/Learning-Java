import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
 * Valay Shah
 * Printing Factors of a number
 * 
 */

public class PrimeFactors {

	public static void main(String[] args){
			if(args.length != 1){   // if user enters arguments ohter than a number
				System.out.println("Usage: java PrintFactors [Integer]");
				System.exit(0);
			}
			try{
				int n = Integer.parseInt(args[0]);
				PrimeFactors pf = new PrimeFactors();
				pf.printFactors(n);
			}catch(NumberFormatException e){   // if user enters anything other than an integer
				System.out.println("Please enter an Integer!\n");
				System.out.println("Usage: java PrintFactors [Integer]");
				System.exit(0);
			}
		}
	
	// Takes care of printing stuff
	public void printFactors(int n){  
		if(n <= 0){   // <= 0 
			System.out.println("Please enter integer >= 0, only positive integers supported!");
			return;
		}
		System.out.println("1 * "+n);
		Set<ArrayList<Integer>> treeset = fetchFactors(n);
		for(ArrayList<Integer> ts : treeset){
			if(ts.size() != 0){     // to check for 1
				System.out.print(ts.get(0));
				for(int i=1;i<ts.size();i++){
					System.out.print(" * "+ts.get(i));
				}
				System.out.print("\n");
			}
		}
	}
	
	// Returns the unique factors in form of multiplication (Recursive function)
	private Set<ArrayList<Integer>> fetchFactors(int n){
		Set<ArrayList<Integer>> s = new HashSet<ArrayList<Integer>>();
		if(n == 1){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			s.add(temp);
			return s;
		}
		
		Set<Integer> factors = this.getFactors(n);
		Iterator<Integer> it = factors.iterator();
		it.next(); // skip 1
		int cur,mul;
		while(it.hasNext()){
			cur = it.next();
			mul = n/cur;
			Set<ArrayList<Integer>> sts = fetchFactors(mul);

			for(ArrayList<Integer> temp : sts){
				ArrayList<Integer> ts = new ArrayList<Integer>(temp);
				ts.add(cur);
				Collections.sort(ts);
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
	
	// Returns all the factors of a number excluding the number!
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
