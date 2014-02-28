package lru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;


public class LeastRecentlyUsedCache extends LinkedHashMap<Integer, Integer>{
	
	int cache_size;
	public LeastRecentlyUsedCache(){
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter cache_size: ");
		this.cache_size = Integer.parseInt(br.readLine());
		
		System.out.print("Enter number of page access: ");
		int num_seq = Integer.parseInt(br.readLine());
		int page;
		
		
		for(int i=0;i<num_seq;i++){
			System.out.print("Enter page: ");
			page = Integer.parseInt(br.readLine());
			if( lhm.get(page) == null){
				lhm.put(page, page);
			}
			
			System.out.println(lhm);
		}
	}
	

}
