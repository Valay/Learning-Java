
public class PascalTriangle {

	public static void main(String[] args){
		
		int n = 25;
		
		PascalTriangle pt = new PascalTriangle();
		pt.printPascal(n);
	}
	
	public void printPascal(int n){
		for(int i=0;i<=n;i++){
			for(int j=0;j<=i;j++){
				System.out.print(    (factorial(i) /  (factorial(i-j) * factorial(j)))    + " ");
			}
			System.out.println();
		}
	}
	
	public int factorial(int n){
		if(n == 0 || n == 1){
			return 1;
		}
		return factorial(n-1)*n;
	}
}
