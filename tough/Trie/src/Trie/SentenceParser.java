package Trie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SentenceParser {

	private static TrieWrapper tw;
	public static void main(String[] args) throws IOException{
		
		// Read in dictionary and fill up the Trie
		FileInputStream s = new FileInputStream("/Users/valayshah/Dropbox/Coursera/dictionary.txt");

		BufferedReader br = new BufferedReader(new InputStreamReader(s));
		
		tw = new TrieWrapper();
		
		String line = br.readLine();
		while( line != null){
			// Read line from file
			tw.addString(line);
			line = br.readLine();
		}
		br.close();
		
		BufferedReader brs = new BufferedReader(new InputStreamReader(System.in));
		String sentence = brs.readLine();
		brs.close();
		ArrayList<String> list = parseSentence(sentence);
		System.out.println(list);
	}
	
	public static ArrayList<String> parseSentence(String sentence){
		
		ArrayList<String> list = new ArrayList<String>();
		if(sentence.equals("")){
			return list;
		}
		String word;
		for(int i=1;i<sentence.length()+1;i++){
			word = sentence.substring(0, i);
			System.out.println(word);
			if(tw.isWord(word)){
				list = parseSentence(sentence.substring(i, sentence.length()));
				if(list != null){
					list.add(word);
					return list;
				}
			}
		}
		return null;
	}
}
