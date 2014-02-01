
public class Driver {

	// Test Cases
	/*
	 *   ABCDEEEEDCD    CDEEEEDCDAB
	 *   
	 *   ABAD DABA
	 * 
	 */
	public static void main(String[] args){
		String s1 = "ABCDEEEEDCD";
		String s2 = "CDEEEEDCDAB";
		String s3 = "";
		
		// Check if strings are rotation of each other
//		StringRotation sr = new StringRotation();
//		System.out.println(sr.isRotated(s1,s2));
		
		// String reverse using recursion
		StringReverseUsingRecursion rev = new StringReverseUsingRecursion();
		rev.reverse2(s2);
	}
	
}
