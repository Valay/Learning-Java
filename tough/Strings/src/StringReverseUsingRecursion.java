
public class StringReverseUsingRecursion {
	
	// Using recursion
	public void reverse(String s){
		if(s.length() == 0){
			return;
		}
		if(s.length() == 1){
			System.out.print(s);
			return;
		}
		this.reverse(s.substring(1));
		System.out.print(s.charAt(0));
		return;
	}
	
	// Using StringBuilder class
	public void reverse2(String s){
		
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		sb.insert(2, 1234);
		System.out.println(sb);
	}
	

}
