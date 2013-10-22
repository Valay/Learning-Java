import java.io.*;
import java.util.ArrayList;

public class EditDistance {
    
    public static int dist1(String s1, String s2)  {
        /*
        * TODO: Implement the space-saving algorithm as described in part 1
        * Make sure to comment all your code as necessary!
        */
    	// Storing only two rows
    			int[] PrevEdit = new int[s2.length()];
    			int[] CurEdit = new int[s2.length()];
;
    			for(int i=0;i<s2.length();i++){
    				PrevEdit[i] = i;
    			}
    			for(int i=1;i<=s1.length();i++){
    				for(int j=0;j<s2.length();j++){
    					if(j==0){
    						CurEdit[j] = i;
    						continue;
    					}
    					else{
    						if(s1.charAt(i-1) == s2.charAt(j)){
    							//Base Case
    							CurEdit[j] = PrevEdit[j-1];
    						}
    						else{
    							CurEdit[j] = 1 + Math.min(CurEdit[j-1],Math.min(PrevEdit[j],PrevEdit[j-1]));
    							//CurEdit[j] = 1 + Math.min(PrevEdit[j],Math.min(CurEdit[j-1],PrevEdit[j-1]));
    							//CurEdit[j] = 1 + Math.min(PrevEdit[j-1],Math.min(PrevEdit[j],CurEdit[j-1]));
    						}
    					}
    				}
    				for(int k=0;k<s2.length();k++){
    					//Copy CurEdit to PrevEdit
    					PrevEdit[k] = CurEdit[k];
    				}
    			}
    			return CurEdit[s2.length()-1];
    }
    
    public static int dist3(String s1, String s2)  {
        /*
        * TODO: Implement the further optimized algorithm as described in part 3
        */
    	// Not copying values
		ArrayList<Integer> PrevEdit = new ArrayList<Integer>(s2.length());
		ArrayList<Integer> CurEdit = new ArrayList<Integer>(s2.length());
		for (int i = 0; i < s2.length(); i++) {
			PrevEdit.add(i);
			CurEdit.add(i);
		}
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (j == 0) {
					CurEdit.set(j, new Integer(i));
					continue;
				} else {
					if (s1.charAt(i - 1) == s2.charAt(j)) {
						// Base Case
						CurEdit.set(j, PrevEdit.get(j - 1));
					} else {
						CurEdit.set(j, 1 + Math.min(CurEdit.get(j - 1)
								.intValue(), Math.min(PrevEdit.get(j)
								.intValue(), PrevEdit.get(j - 1).intValue())));
					}
				}
			}
			for (int k = 0; k < s2.length(); k++) {
				// Copy CurEdit to PrevEdit
				PrevEdit.set(k, CurEdit.get(k));
			}
		}
		return CurEdit.get(s2.length() - 1).intValue();
    }
    
    public static int dist6(String s1, String s2)  {
        /*
        * TODO: Implement the diagonal algorithm as described in part 6
        */
    	// Traversing arrays diagonally2
		int n = s1.length();
		int m = s2.length();

		// using nxn table

		int table[][] = new int[n + 1][m + 1];

		table[0][0] = 0;

		int r = 1;

		for (; r <= n; r++) {
			int j = r;
			for (int i = 0; i <= m && j >= 0; i++) {
				if (j == 0)
					table[j][i] = i; // edges reached
				else if (i == 0)
					table[j][i] = j; // ''
				else {
					if (s1.charAt(j - 1) == s2.charAt(i - 1))
						table[j][i] = table[j - 1][i - 1];
					else
						table[j][i] = 1 + Math.min(table[j][i - 1],
								Math.min(table[j - 1][i], table[j - 1][i - 1]));

				}
				j--;
			}
		}

		// at this point: n rounds have passed, set r = n
		r = n;

		for (int i = 1; i <= m; i++) // column coordinate
		{
			int j = r;
			int k = i;
			for (; k <= m && j >= 0; k++) {
				// System.out.print(s1.charAt(j-1) + ", ");
				// System.out.println(s2.charAt(k-1));
				if (j == 0)
					table[j][k] = 1 + table[j][k - 1];
				else if (s1.charAt(j - 1) == s2.charAt(k - 1))
					table[j][k] = table[j - 1][k - 1];
				else
					table[j][k] = 1 + Math.min(table[j][k - 1],
							Math.min(table[j - 1][k], table[j - 1][k - 1]));

				j--;
			}
		}

		return table[n][m];
    }
    
    public static void main(String[] args) {
        boolean testingMode = (args.length > 0 && args[0].equals("-test"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1, s2;
        try {
            if (testingMode) {//run your code with the "-test" flag to enter inputs manually
                s1 = reader.readLine().replace("\n","").replace("\r","");
                s2 = reader.readLine().replace("\n","").replace("\r","");

                System.out.println(dist1(s1, s2));
                System.out.println(dist3(s1, s2));
                System.out.println(dist6(s1, s2));
            } else {//otherwise, generate and test on length 10000 inputs
                long start, end;
                int n = 10000, m=10000;
                
                double p = .5;
        
                String a = "a";
                String b = "b";
        
                StringBuilder sb1 = new StringBuilder(n);
                for (int i = 0; i < n; i++){
                    if (Math.random() < p){
                        sb1.append(a);
                    }else{
                        sb1.append(b);
                    }
                }
        
                StringBuilder sb2 = new StringBuilder(m);
                for (int i = 0; i < m; i++){
                    if (Math.random() < p){
                        sb2.append(a);
                    }else{
                        sb2.append(b);
                    }
                }
        
                s1=sb1.toString(); s2=sb2.toString();
                System.out.println("random strings:");

                start = System.currentTimeMillis();
                System.out.println("dist1 answer: " + EditDistance.dist1(s1,s2));
                end = System.currentTimeMillis();
                System.out.println("time: " + (end-start) + " ms");

                start = System.currentTimeMillis();
                System.out.println("dist3 answer: " + EditDistance.dist3(s1,s2));
                end = System.currentTimeMillis();
                System.out.println("time: " + (end-start) + " ms");
        
                start = System.currentTimeMillis();
                System.out.println("dist6 answer: " + EditDistance.dist6(s1,s2));
                end = System.currentTimeMillis();
                System.out.println("time: " + (end-start) + " ms");
                System.out.println();


                sb1 = new StringBuilder(n);
                for (int i = 0; i < n; i++){
                    sb1.append(a);
                }
        
                sb2 = new StringBuilder(m);
                for (int i = 0; i < m; i++){
                    sb2.append(b);
                }

                s1=sb1.toString(); s2=sb2.toString();
                System.out.println("opposite strings:");

                start = System.currentTimeMillis();
                System.out.println("dist1 answer: " + EditDistance.dist1(s1,s2));
                end = System.currentTimeMillis();
                System.out.println("time: " + (end-start) + " ms");

                start = System.currentTimeMillis();
                System.out.println("dist3 answer: " + EditDistance.dist3(s1,s2));
                end = System.currentTimeMillis();
                System.out.println("time: " + (end-start) + " ms");
        
                start = System.currentTimeMillis();
                System.out.println("dist6 answer: " + EditDistance.dist6(s1,s2));
                end = System.currentTimeMillis();
                System.out.println("time: " + (end-start) + " ms");
                System.out.println();

                sb1 = new StringBuilder(n);
                for (int i = 0; i < n; i++){
                    sb1.append(a);
                }
        
                sb2 = new StringBuilder(m);
                for (int i = 0; i < m; i++){
                    sb2.append(a);
                }

                s1=sb1.toString(); s2=sb2.toString();
                System.out.println("identical strings:");

                start = System.currentTimeMillis();
                System.out.println("dist1 answer: " + EditDistance.dist1(s1,s2));
                end = System.currentTimeMillis();
                System.out.println("time: " + (end-start) + " ms");

                start = System.currentTimeMillis();
                System.out.println("dist3 answer: " + EditDistance.dist3(s1,s2));
                end = System.currentTimeMillis();
                System.out.println("time: " + (end-start) + " ms");
        
                start = System.currentTimeMillis();
                System.out.println("dist6 answer: " + EditDistance.dist6(s1,s2));
                end = System.currentTimeMillis();
                System.out.println("time: " + (end-start) + " ms");
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Error reading input strings.");
        }
    }
}
