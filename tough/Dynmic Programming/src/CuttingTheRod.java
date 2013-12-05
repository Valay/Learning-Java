
public class CuttingTheRod {
	
	public static void main(String[] args){
		int arr[] = {2, 5, 8, 9, 10, 17, 17, 20, 21, 25, 27};
		int len = 11;
		
		CuttingTheRod ctr = new CuttingTheRod();
		
		System.out.println(ctr.cutTheRod(len, arr));
	}
	
	public int cutTheRod(int n, int[] a){
		
		int[] tab = new int[n+1];
		tab[0] = 0;
		if (n == 1){
			return a[0];
		}
		for(int i=1;i <= n;i++){
			int m = a[i-1];
			
			for(int j=1;j<Math.ceil(i/2);j++){
				m = Math.max(m, tab[j]+tab[i-j]);
			}
			tab[i] = m;
		}
		return tab[n];
	}
}
