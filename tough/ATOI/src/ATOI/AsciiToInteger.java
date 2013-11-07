package ATOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AsciiToInteger {
	public static void main(String[] args){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String s = br.readLine();
			
			if (s == null || "".equals(s.trim())){
				System.out.println("String must not be empty!");
				System.exit(0);
			}
			
			s = s.trim();
			
			boolean neg = false;
			char sign = s.charAt(0);
			if(sign == '+' || sign == '-'){
				if(sign == '-'){
					neg = true;
				}
				s=s.substring(1);
			}
			
			int number = 0;
			
			for(int i=0;i<s.length();i++){
				if(Character.isDigit(s.charAt(i))){
					number = number*10+(s.charAt(i) - '0');  // Most important line of code!
				}else{
					System.out.println("Not a number");
					System.exit(0);
				}
			}
			
			if(neg){
				number = -number;
			}
			System.out.println(number);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
