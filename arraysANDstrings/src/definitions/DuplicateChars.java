package definitions;


import java.lang.StringBuffer;
import java.util.HashSet;
import java.util.Arrays;

public class DuplicateChars {

	public char[] removeDuplicate(char[] s){
		if (s.length == 1){
			return s;
		}
		int endptr = 1;
		for(int i=1; i<s.length;i++){
			int j;
			for(j=0; j<endptr; j++){
				if(s[i] == s[j]) break;
			}
			if(j == endptr){
				s[endptr] = s[i];
				endptr++;
			}
		}
		return Arrays.copyOfRange(s, 0, endptr);
	}
}
