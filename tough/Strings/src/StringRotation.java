
public class StringRotation {
	/*
	 * idea: Concatenate string1 with other and check if new string contains string2
	 */
	public boolean isRotated(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		//System.out.println(s2.toString());
		String temp = s1.concat(s2);
		return temp.contains(s2);
	}
}
