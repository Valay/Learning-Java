
import java.io.*;

public class EditDistance {

	public static int editDistance(String s1, String s2) {
		/*
		 * TODO: Implement the space-saving algorithm as described in homework 1
		 * problem 4 Make sure to comment all your code as necessary!
		 */
		
        int n = s1.length();
        int m = s2.length();
        
        int[][] Edit = new int[n+1][m+1];
        
        //Base case for 0
        Edit[0][0] = 0;
        
        for(int i=1;i<=n;i++)
        {
            Edit[i][0] = i;
            for(int j=1;j<=m;j++)
            {
                Edit[0][j] = j;
                if( s1.charAt(i-1) == s2.charAt(j-1) )
                    Edit[i][j] = Edit[i-1][j-1];
                else
                    Edit[i][j] = Math.min(Edit[i-1][j-1], Math.min( Edit[i-1][j], Edit[i][j-1]) ) +1;
            }
        }
        return Edit[n][m];
	}

	public static void main(String[] args) {
		boolean testingMode = (args.length > 0 && args[0].equals("-test"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String s1, s2;
		try {
			if (testingMode) {
				s1 = reader.readLine();
				s2 = reader.readLine();
				System.out.println(editDistance(s1, s2));
			} else {
				System.out.print("> Input the first string: ");
				s1 = reader.readLine();
				System.out.print("> Input the second string: ");
				s2 = reader.readLine();
				System.out.println("> editDistance outputs "
						+ editDistance(s1, s2));
			}
		} catch (IOException e) {
			System.err.println("Error reading input strings.");
		}
	}
}

