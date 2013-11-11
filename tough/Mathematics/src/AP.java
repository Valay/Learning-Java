import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AP {
	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.parseInt(br.readLine());

		// read in the integers
		String[] tokens = br.readLine().split(" ");

		List<Integer> ap = new ArrayList<Integer>();
		long sum = 0;
		for (int i = 0; i < count; i++) {
			ap.add(Integer.parseInt(tokens[i]));
			sum += ap.get(i);
		}
		
		int diff = ((ap.get(ap.size() - 1) - ap.get(0)) / ap.size());
		
		// find the sum of AP
		long ap_sum = ((2 * ap.get(0) + ((count+1) - 1) * (diff)) * (count+1)) / 2;
		//System.out.println(ap_sum);
		System.out.println("" + (ap_sum - sum));
	}
}
