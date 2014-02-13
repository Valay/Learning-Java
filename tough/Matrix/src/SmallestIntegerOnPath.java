
public class SmallestIntegerOnPath {

	public static void main(String[] args){
		int[][] matrix = { };
		
		System.out.println(minimumPointOnMaximalPath(matrix));
	
	}
	
	public static void print(int[][] mat){
		int n = mat.length;
		int m = mat[0].length;
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}
	

	public static int minimumPointOnMaximalPath(int[][] matrix) {
		
	
		int n =  matrix.length;
		int m = matrix[0].length;
		
		
		int[][] sum = new int[n][m];
		
		sum[0][0] = matrix[0][0];
		int min = matrix[0][0];
    
		for(int i=1;i<n;i++){
			if(matrix[i][0] < min){
				sum[i][0] = matrix[i][0];
				min = matrix[i][0];
			}else{
				sum[i][0] = min;
			}
		}
		
		
		for(int i=1;i<m;i++){
			if(matrix[0][i] < min){
				sum[0][i] = matrix[0][i];
				min = matrix[0][i];
			}else{
				sum[0][i] = min;
			}
		}
		
		
		for(int i=1;i<n;i++){
			for(int j=1;j<m;j++){
				sum[i][j] = Math.min( Math.max(sum[i-1][j], sum[i][j-1]) , matrix[i][j]);
			}
		}
		
		return sum[n-1][m-1];
	}
}
