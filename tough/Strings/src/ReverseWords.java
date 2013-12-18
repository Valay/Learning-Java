
public class ReverseWords {
	public static void main(String[] args){
		String str = "Please reverse this string";
		ReverseWords rw = new ReverseWords();
		System.out.println(rw.reverseWords(str));
	}
	
	public String reverseWords(String s){
		String rev = this.reverse(s);
		String revWords = "";
		int last_index=0;
		
		for(int j=0;j<rev.length();j++){
			
			if(rev.charAt(j) == ' '){
				revWords = revWords + reverse(rev.substring(last_index, j))+ " ";
				last_index = j+1;
				continue;
			}
			
			if(j == rev.length()-1){
				revWords = revWords + reverse(rev.substring(last_index, j+1));
			}
		}
		
		return revWords;
	}
	
	public String reverse(String s){
		String rev = "";
		for(int i=0;i<s.length();i++){
			rev = s.charAt(i)+rev;
		}
		
		return rev;
	}
}
