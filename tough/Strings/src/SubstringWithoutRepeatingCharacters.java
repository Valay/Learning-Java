import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class SubstringWithoutRepeatingCharacters {

	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		
		try {
			s = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int max_len = 0;
		int max_start = 0;
		int max_end = 0;
		int cur_len = 0;
		int start =0;
		int end =0;
		
		int pos;
		Map<Character,Integer> visited = new HashMap<Character,Integer>();
		
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(visited.containsKey(c)){
				pos = visited.get(c);
				for(int j= start;j<=pos;j++){
					visited.remove(s.charAt(j));
				}
				start = pos+1;
				if(end <= pos){
					end = pos+1;
				}
				visited.put(c, i);
				cur_len = end - pos;
			}else{
				visited.put(c, i);
				end = i;
				cur_len++;
			}
			if(cur_len > max_len){
				max_start = start;
				max_end = end;
				max_len = cur_len;
			}
		}
		
		System.out.println("Max length : "+ max_len);
		System.out.println("String : "+ s.substring(max_start, max_end+1));
	}
}
