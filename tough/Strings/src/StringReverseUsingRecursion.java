
public class StringReverseUsingRecursion {
	
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
	

}
