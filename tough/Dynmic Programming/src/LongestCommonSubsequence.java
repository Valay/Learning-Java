import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LongestCommonSubsequence {
	
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1=null,str2=null;
		try {
			str1 = br.readLine();
			str2 = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int n = str1.length();
		int m = str2.length();
		
		int[][] tab = new int[n+1][m+1];
		
		for(int i=0;i<n;i++){
			tab[i][0] = 0;
		}
		
		for(int i=0;i<m;i++){
			tab[0][i] = 0;
		}
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					tab[i][j] = tab[i-1][j-1] + 1;
				}else{
					tab[i][j] = Math.max(tab[i-1][j], tab[i][j-1]);
				}
			}
		}
		
		System.out.println(tab[n][m]);
	}
}
