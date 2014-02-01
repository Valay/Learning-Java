
public class RemoveDuplicates {

	public static void main(String[] args){
		String s = "abaabaab";
		
		RemoveDuplicates rd = new RemoveDuplicates();
		
		System.out.println(rd.removeDuplicates(s));
	}
	
	public String removeDuplicates(String str){
		
		int[] charMap = new int[256];
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(charMap[(int)c] != 1){
				charMap[(int)c] = 1;
				sb.append(c);
			}else{
				// duplicate found!
				//pass
			}
		}
		
		return sb.toString();
	}
}
