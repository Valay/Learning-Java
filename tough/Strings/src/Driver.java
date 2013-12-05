
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
		StringRotation sr = new StringRotation();
		System.out.println(sr.isRotated(s1,s2));
	}
	
}
