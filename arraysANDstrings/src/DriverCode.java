import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import definitions.UniqueCharacters;
import definitions.ReverseString;
import definitions.DuplicateChars;
import definitions.Anagrams;

public class DriverCode {
	public static void main(String[] args){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s = br.readLine();
			String t = br.readLine();
			// UniqueCharacters
			/* UniqueCharacters uc = new UniqueCharacters();
			uc.isUnique(s); */
			
			// ReverseString
			//ReverseString rs = new ReverseString();
			//System.out.println(rs.reverse(s));
			// Also implement reverse words in a string
			
			// Remove duplicate characters
			//DuplicateChars dc = new DuplicateChars();
			//System.out.println(dc.removeDuplicate(s.toCharArray()));
			
			// Strings are Anagrams?
			Anagrams a = new Anagrams();
			System.out.println(a.isAnagram(s, t));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
