import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import list.LinkedList;


public class Driver {
	
	public static void main(String[] args){
		String[] numbers = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			numbers = br.readLine().split("\\s+");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LinkedList<Integer> l = new LinkedList<Integer>();
		for(String s:numbers){
			l.insertHead(Integer.parseInt(s));
		}
		
		l.print();
		System.out.println(l.getMiddle());
	}
}
