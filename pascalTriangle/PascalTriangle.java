package pascalTriangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PascalTriangle {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = 0;
		try {
			i = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pascalTriangle(i);
	}
	
	public static void pascalTriangle(int n){
		
		for(int i=0;i<n;i++){
			for(int j=0;j<=i;j++){
				System.out.print( factorial(i) / (factorial(i-j)*factorial(j) ));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static int factorial(int n){
		int j=1;
		if(n==0){
			return 1;
		}
		
		for(int i=1;i<=n;i++){
			j=j*i;
		}
		return j;
	}
}
