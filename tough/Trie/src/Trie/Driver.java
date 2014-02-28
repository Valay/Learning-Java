package Trie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {

	public static void main(String[] args) throws IOException{
		///Users/valayshah/Dropbox/Coursera/dictionary.txt
		
		// Read file


		FileInputStream s = new FileInputStream("/Users/valayshah/Dropbox/Coursera/dictionary.txt");

		BufferedReader br = new BufferedReader(new InputStreamReader(s));
		
		TrieWrapper tw = new TrieWrapper();
		
		String line = br.readLine();
		while( line != null){
			// Read line from file
			tw.addString(line);
			line = br.readLine();
		}
		
		
		BufferedReader brs = new BufferedReader(new InputStreamReader(System.in));
		int entry = 0;
		String word;
		while(entry != -1){
			System.out.print("Enter String or -1 to exit : ");
			word = brs.readLine();
			try{
				entry = Integer.parseInt(word);
				continue;
			}catch(Exception e){
				entry = 0;
				if(tw.isWord(word)){
					System.out.println("Present");
				}else{
					System.out.println("Absent");
				}
			}
			
		}
	}
}
