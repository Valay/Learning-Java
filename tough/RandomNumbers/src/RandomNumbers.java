
import java.util.Random;

public class RandomNumbers {

	public static void main(String[] args){
		Random r = new Random();
		
		int[] hist = new int[32];
		
		for(int i=0;i<1000000;i++){
			hist[r.nextInt(32)] +=1;
		}
		
		for(int i=0;i<32;i++)
		System.out.println(hist[i]);
	}
}
