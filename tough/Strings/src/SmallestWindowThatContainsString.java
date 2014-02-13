import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class SmallestWindowThatContainsString {

	public static void main(String[] args){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1,s2;
		SmallestWindowThatContainsString sts = new SmallestWindowThatContainsString();

		try {
			s1 = br.readLine();
			s2 = br.readLine();
			System.out.println(sts.smallestWindow(s1, s2));
		} catch (IOException e) {
			// 
			//pass
			e.printStackTrace();
		}
		
	}
	
	public String smallestWindow(String str1, String str2){
		int start=0, min_len=0, min =0, cur=0;
		Queue<Character> q = new LinkedList<Character>();
		Map<Character, Integer> hm = new HashMap<Character, Integer>(); 
		
		for(int i = 0; i < str2.length(); i++){
			char c = str2.charAt(i);
			hm.put(c, hm.get(c)==null?1:hm.get(c)+1);
		}
		
		Map<Character, Integer> hm2 = new HashMap<Character, Integer>(hm); 

		for(int i = 0; i < str1.length(); i++){
			char c = str1.charAt(i);
			if(hm.size() != 0){
				q.add(c);
				if(hm.get(c) != null){
					if(hm.get(c)-1 == 0){
						hm.remove(c);
					}else{
						Integer in = hm.get(c);
						in -= 1;
					}
				}
			}else{
				if(q.peek() == c){
					q.remove();
					while(hm2.get(q.peek()) == null){
						q.remove();
					}
					//if(min_len)
				}
			}
		}
		
		return str1;
	}
}
