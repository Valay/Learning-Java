import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 
 Task
 Your task will be to write a program for reversing numbers in binary. For instance, the binary representation of 13 is 1101, and reversing it gives 1011, which corresponds to number 11.

Input
The input contains a single line with an integer N, 1 ² N ² 1000000000.

Output
Output one line with one integer, the number we get by reversing the binary representation of N.
 * 
 * 
 */
public class ReverseBinary {
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number=0;
		try {
			number = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String m = null;
		int reverse = 0;
		
		do{
			reverse = reverse << 1;
			if( (number & 0x01)==1 )
			{
				reverse = reverse | 1;
			}
			number = number >> 1;
			m = Integer.toBinaryString(number);
		}while(number != 0);
		
		System.out.println(reverse);
	}
}
