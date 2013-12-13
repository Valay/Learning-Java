/* This code seems to be incorrect */
public class MinimumJump {
	
	int[] arr = new int[10];
	
	public static void main(String[] args){
		int min=1, max=8;
		
		MinimumJump mj = new MinimumJump();
		for(int i=0;i<10;i++){
			mj.arr[i] = min + (int)(Math.random() * (max-min));
		}
		
		int[] T = new int[10];
		T[9] = 0;
		int temp = Integer.MAX_VALUE;
		for(int i=8;i>=0;i--){
			temp = Integer.MAX_VALUE;
			for(int j=1;j+i<10 && j<mj.arr[i];j++){
				temp = Math.min(temp, T[i+j]);
			}
			System.out.println(temp);
			T[i] = temp+1;
		}
		for(int i : mj.arr){
			System.out.print(i+" ");
		}
		System.out.println("");
		for(int i : T){
			System.out.print(i+" ");
		}
		System.out.println("");
		System.out.println(T[0]);
	}
}
