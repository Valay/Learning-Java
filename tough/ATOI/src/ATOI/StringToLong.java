package ATOI;

public class StringToLong {
	
	public static void main(String[] args){
		// Add strings to test  (test different values)
		test();
	}
	
	// Program to parse string to long
	public static long stringToLong(String s)
	{
		if(s.length() == 0){
			return 0;
		}
		long l=0;
	    /* code goes here to convert a string to a long */
		int j=0;
		int k=1;
		
		// It might be a sign first
		if(s.charAt(0) == '+' || s.charAt(0) == '-'){
			j=1;
			if(s.charAt(0)=='-'){
				k=-1;
			}
		}
		
		// Next all should be digits with an optional trailing 'l' or 'L'
		for(int i=j;i<s.length();i++){
			if(Character.isDigit(s.charAt(i))){
				l = l*10+ (s.charAt(i) - 48);
			}
			else{
				if(i == s.length()-1 && (s.charAt(i) == 'L' || s.charAt(i) == 'l') ){
						//it is still correct
				}else{ // trailing 'l' or 'L' not found!
					System.out.println("Not a number!");
					System.exit(0);  // A better way to do this is to throw an exception here!
					// for example  [ throw NumberFormatException ]
				}
			}
		}
		l = l*-k;
		return l;
	}
	
	
	// Test stringToLong
	public static void test() {
	    long i = stringToLong("123");
	    if (i == -123)
	        System.out.println("Parsed Correctly!");
	    else
	    	System.out.println("Not a Number!");
	    	
	}
}
