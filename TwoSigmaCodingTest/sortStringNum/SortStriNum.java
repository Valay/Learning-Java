package sortStringNum;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class SortStriNum {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new ArrayList<String>();
		List<String> strList = new ArrayList<String>();
		List<Integer> intList = new ArrayList<Integer>();
		
		try {
			String s = br.readLine();

			if(s.equals("")){
				System.exit(0);
			}
			StringTokenizer st = new StringTokenizer(s);
			
			while(st.hasMoreTokens()){
				list.add(st.nextToken());
			}
			
			for(int i=0;i<list.size();i++){
				if(isInteger(list.get(i))){
					intList.add(Integer.parseInt(list.get(i)));
					list.set(i, "i");
				}
				else{
					strList.add(list.get(i));
					list.set(i, "s");
				}
				
			}
			
			Collections.sort(intList);
			Collections.sort(strList);
			
			int strIndex =0;
			int intIndex = 0;
			
			for(int i=0;i<list.size();i++){
				if(list.get(i).equals("s")){
					list.set(i, strList.get(strIndex));
					strIndex++;
				}
				else{
					list.set(i, Integer.toString(intList.get(intIndex)));
					intIndex++;
				}
			}
			System.out.print(list.get(0));
			for(int i=1;i<list.size();i++){
				System.out.print(" "+list.get(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean isInteger(String s){
		try{
			Integer.parseInt(s);
			return true;
		}catch(NumberFormatException n)
		{
			return false;
		}
	}
}
