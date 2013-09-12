package definitions;
public class UniqueCharacters {
		
	public boolean isUnique(String s){
			int strlen = s.length()-1;
			
			
			for(int i=0; i<= (strlen/2) ; i++){
				if(s.charAt(i) != s.charAt(strlen-i)){
					System.out.println("Strings are not equal");
					return false;
				}
			}
			System.out.println("Strings are equal");
			return true;
	}
}
