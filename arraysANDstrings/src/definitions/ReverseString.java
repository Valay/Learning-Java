package definitions;

import java.lang.StringBuffer;
import java.util.ArrayList;

public class ReverseString {
	
	public String reverse(String s){
		StringBuffer rev = new StringBuffer(s);
		rev.reverse();
		return (new String(rev));
	}
	
	public String reverseWords(String s){
		String[] words = s.split(" ");
		String rev = "";
		ArrayList<String> str = new ArrayList<String>();
		for(String word: words){
			rev += new StringBuffer(word).reverse().toString();
			rev += " ";
		}
		return rev;
	}
}
