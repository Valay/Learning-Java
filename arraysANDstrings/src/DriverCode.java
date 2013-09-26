import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.LinkedList;

//import definitions.UniqueCharacters;
//import definitions.ReverseString;
//import definitions.DuplicateChars;
//import definitions.Anagrams;
import definitions.PascalTriangle;
import definitions.StringPermutations;

public class DriverCode {
	public static void main(String[] args){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s = br.readLine();
			//String t = br.readLine();
			
			
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
			//Anagrams a = new Anagrams();
			//System.out.println(a.isAnagram(s, t));
			
			// Listing Anagrams
			/*
			 * 
			 LinkedList<String> list = new LinkedList<String>();
			
			String s = null;
			
			do{
				s = br.readLine();
				try{
					if (Integer.parseInt(s) == 0)
						break;
				}catch(NumberFormatException n){
					//do nothing!
					list.add(s);
				}
			}while(true);
			
			*/
			//System.out.println(list);
			//definitions.ListAnagrams la = new definitions.ListAnagrams();
			//LinkedList<LinkedList<String>> listoflistofanagrams = la.listAnagrams(list);
			
			// Pascal Triangle
			//PascalTriangle p = new PascalTriangle();
			//p.pascalTriangle(s);
			
			// String permutations
			StringPermutations sp = new StringPermutations();
			sp.permute("", s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
