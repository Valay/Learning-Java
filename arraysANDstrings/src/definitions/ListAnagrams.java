package definitions;

import java.util.LinkedList;
import java.util.List;

public class ListAnagrams {
	
	// For more faster implementation go to this URL : http://docs.oracle.com/javase/tutorial/collections/interfaces/map.html
	
	definitions.Anagrams a = new definitions.Anagrams();
	
	public LinkedList<LinkedList<String>> listAnagrams(List<String> list){
		
		LinkedList<LinkedList<String>> listoflist = new LinkedList<LinkedList<String>>();
		System.out.println(list);
		for(String l : list){
			
			if (listoflist.isEmpty()){
				LinkedList<String> g = new LinkedList<String>();
				g.add(l);
				listoflist.add(g);
				continue;
			}
			
			int added_to_any_list = 0;
			for(LinkedList<String> s : listoflist){
				if( a.isAnagram(l, s.get(0)) ){
					s.add(l);
					added_to_any_list = 1;
				}
			}
		
			if(added_to_any_list == 0){
				LinkedList<String> g = new LinkedList<String>();
				g.add(l);
				listoflist.add(g);
			}
			
		}
		

		System.out.println(listoflist);
		
		return listoflist;
	}
}
