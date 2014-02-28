import java.util.ArrayList;
import java.util.List;

public class MathPuzzle {

	public static int c = 0;
	public static void main(String[] args) {

		List<Integer> li = new ArrayList<Integer>();
		li.add(1);
		li.add(2);
		li.add(3);
		li.add(4);
		li.add(5);
		li.add(6);
		li.add(10);
		li.add(12);

		comb((new ArrayList<Integer>()), li);
	}

	public static boolean checkSquare(List<Integer> li) {

		int[][] sq = new int[3][3];

		int count = 0;
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++) {
				if(j == 1 && k == 1 ){
					continue;
				}
				sq[j][k] = li.get(count);
				count++;
			}
		}
		
		// Conditions to check

		// W = S = N = E
		// W-S = 1
		// S-E = 2
		// E-N = 3
		
		// check if they satisfy the conditions
		 if( ((sq[0][0] * sq[0][1] * sq[0][2]) == (sq[0][0] * sq[1][0] * sq[2][0]))  &&
				 ((sq[0][0] * sq[1][0] * sq[2][0]) == (sq[2][0] * sq[2][1] * sq[2][2])) && 
				 ((sq[2][0] * sq[2][1] * sq[2][2]) == (sq[0][2] * sq[1][2] * sq[2][2])) 
				 && 
				 ((sq[0][0] + sq[1][0] + sq[2][0]) == (sq[2][0] + sq[2][1] + sq[2][2]) + 1) && 
				 ((sq[2][0] + sq[2][1] + sq[2][2]) == (sq[0][2] + sq[1][2] + sq[2][2]) + 2) &&
				 ((sq[0][2] + sq[1][2] + sq[2][2]) == (sq[0][0] + sq[0][1] + sq[0][2]) + 3)  ) {
			 System.out.println("This is the solution :" + li);
			 for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if(j == 1 && k == 1 ){
							sq[j][k] = 0;
						}
						System.out.print("  ["+j+"]["+k+"] :" + sq[j][k]);
					}
					System.out.println("");
				}
			 return true;
		 }
		 c++;
		 //System.out.println("Count "+c+" :" + li);
		 return false;
	}

	// Returns every permutation of the list
	private static List<Integer> comb(List<Integer> prefix, List<Integer> list) {
		int n = list.size();
		if (n == 0) {
			if (checkSquare(prefix)) {
				return prefix;
			}
		} else {
			for (int i = 0; i < list.size(); i++) {
				List<Integer> pref = new ArrayList<Integer>(prefix);
				pref.add(list.get(i));
				List<Integer> rest = new ArrayList<Integer>();
				rest.addAll(list.subList(0, i));
				rest.addAll(list.subList(i + 1, n));
				if (comb(pref, rest) != null) {
					return pref;
				}
			}
		}
		return null;
	}
}
