import java.io.*;
import java.util.ArrayList;


public class EditDistance {

	public static int editDistance2(String s1, String s2){
		int[] PrevEdit = new int[s2.length()];
		int[] CurEdit = new int[s2.length()];
		long startTime = 0;
		long endTime = 0;
		//long diffTime = 0;
		
		startTime = System.currentTimeMillis();
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
					}
				}
				
			}
			for(int k=0;k<s2.length();k++){
				//Copy CurEdit to PrevEdit
				PrevEdit[k] = CurEdit[k];
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		return CurEdit[s2.length()-1];
		
	}
	
	public static int editDistance3(String s1, String s2){
		
		ArrayList<Integer> PrevEdit = new ArrayList<Integer>(s2.length());
		ArrayList<Integer> CurEdit = new ArrayList<Integer>(s2.length());
		
		
		for(int i=0;i<s2.length();i++){
			PrevEdit.add(i);
			CurEdit.add(i);
		}
		
		for(int i=1;i<=s1.length();i++){
			for(int j=0;j<s2.length();j++){
				if(j==0){
					CurEdit.set(j,new Integer(i));
					continue;
				}
				else{
					if(s1.charAt(i-1) == s2.charAt(j)){
						//Base Case
						CurEdit.set(j,PrevEdit.get(j-1));
					}
					else{
						CurEdit.set(j, 1 + Math.min(CurEdit.get(j-1).intValue(),Math.min(PrevEdit.get(j).intValue(),PrevEdit.get(j-1).intValue())));
					}
				}
				
			}
			for(int k=0;k<s2.length();k++){
				//Copy CurEdit to PrevEdit
				PrevEdit.set(k, CurEdit.get(k));
			}
		}
		return CurEdit.get(s2.length()-1).intValue();
	}
	
	public static int editDistance4(String s1, String s2){
		
        int n = s1.length();
        int m = s2.length();
        
        int[][] Edit = new int[n+1][m+1];
        
        //Base case for 0
        Edit[0][0] = 0;
		
		for(int i=0;i<n; i++){
			Edit[i][0] = 0;
		}
		
		for(int i=0;i<m; i++){
			Edit[0][i] = 0;
		}
		
        int k;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
				k = i;
                if( s1.charAt(k-i-1) == s2.charAt(j-1) )
                    Edit[i][j] = Edit[i-1][j-1];
                else
                    Edit[i][j] = Math.min(Edit[i-1][j-1], Math.min( Edit[i-1][j], Edit[i][j-1]) ) +1;
            }
        }
        return Edit[n][m];
		
	}

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
						+ editDistance2(s1, s2));
			}
		} catch (IOException e) {
			System.err.println("Error reading input strings.");
		}
	}
}

