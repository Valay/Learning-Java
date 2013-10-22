/* Valay Shah
 * Gumroad Interview with Amir
 * 
 * Problem definition:
 * Regular expression matching
 * 
 *  Match the string in pattern to sample
 *  
 *  '[a-z]' -- Matches a particular character with that character
 *  '.' -- Matches any single character
 *  '*' -- Matches zero or more occurrences of any characters
 * 
 *  isMatch(pattern, sample);
 */


public class RegexMatching {

	public static void main(String args[]){
		
		// change the pattern and sample here!
		String pattern = "ab*..cd*.**e.*gfgf";
		String sample = "abqcdcdjefgfgf"; 
		
		// sanity check for pattern
		for(int i=0;i<sample.length();i++){
			if( !isAlpha(sample.charAt(i)) && !isDot(sample.charAt(i)) && !isStar(sample.charAt(i)) ){
				System.out.println("Pattern Not Valid!");
				System.exit(0);
			}
		}
		
		// sanity check for sample
		for(int i=0;i<sample.length();i++){
			if(!isAlpha(sample.charAt(i))){
				System.out.println("Sample Not Valid!");
				System.exit(0);
			}
		}
		
		System.out.println(isMatch(pattern, sample));
	}
	
	private static boolean isMatch(String pattern, String sample){
		
		int i=0;
		int j=0;
		
		//Base case 1 : both string empty
		if(pattern.isEmpty() && sample.isEmpty()){
			return true;
		}
		
		//Base case 2 : 
		if(pattern.isEmpty() && !sample.isEmpty()){
			return false;
		}
		
		//Base case 3 : if sample empty and pattern contain alphabet or dot
		if(pattern.length() >= 1 && !(pattern.charAt(0) == '*') && sample.isEmpty()){
			return false;
		}
		
		//Base case 4 : if sample is empty and pattern contains only star
		if(pattern.length() == 1 && pattern.charAt(0) == '*' && sample.isEmpty()){
			return true;
		}
		
		// parse the pattern and check if sample follows pattern!
		while(i<pattern.length()){
			//check for alphabet
			if(isAlpha(pattern.charAt(i))){
				if(j < sample.length() && pattern.charAt(i) == sample.charAt(j)){
					i++;
					j++;
					continue;
				}else{
					return false;
				}
			}
			
			//check for '.'
			if(isDot(pattern.charAt(i))){
				// Assuming that sample is valid ie. it only contains characters between [a-z]
				if(j >= sample.length()){
					return false;
				}
				i++;
				j++;
				continue;
			}
			
			//check for '*'
			if(isStar(pattern.charAt(i))){
				// Match zero or more characters!
				//check if its the last star
				if(i == pattern.length()-1){
					return true;
				}
				int k = j;
				boolean flag = false;
				while(k < sample.length()){
					// check all the possibilities until we get a match (factorial time)
					flag = flag || isMatch(pattern.substring(i+1),sample.substring(k));
					if(flag == true){
						return true;
					}
					k++;
				}
				return false;
			}
			
			return false;
		}
		// Okay the pattern is parsed check if there is still any sample left!
		if(j >= sample.length()){
			return true;
		}
		return false;
	}
	
	private static boolean isAlpha(char c){
		return (c >= 'a' && c <= 'z');
	}
	
	private static boolean isDot(char c){
		return c == '.';
	}
	
	private static boolean isStar(char c){
		return c == '*';
	}
}
