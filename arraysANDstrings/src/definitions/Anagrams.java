package definitions;

public class Anagrams {

	public boolean isAnagram(String s, String t){
		//String filtereds = s.replaceAll("[^a-zA-Z]", "");
		//String filteredt = t.replaceAll("[^a-zA-Z]", "");
		
		if ( s.length() != t.length() )
			return false;
		
		int[] uniquechars = new int[256];
		
		for(int i=0;i<s.length();i++){
			int c = (int)s.charAt(i);
			uniquechars[c] += 1;
		}
		
		for(int i=0;i<t.length();i++){
			int c = (int)t.charAt(i);
			if (uniquechars[c] == 0){
				return false;
			}
		}
		
		return true;
	}
}
