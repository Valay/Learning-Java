package Trie;

public class TrieWrapper {

	private Trie root;
	
	public TrieWrapper(){
		this.root = new Trie();
		this.root.marker = false;
	}
	
	public boolean addString(String s){
		if(isWord(s)){
			return false;
		}
		
		Trie temp = this.root;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			int cval = (int)c - 97;
			if(temp.tarr[cval] == null){
				temp.tarr[cval] = new Trie();
			}
			temp = temp.tarr[cval];
		}
		temp.marker = true;
		return true;
	}
	
	public boolean isWord(String s){
		Trie temp = this.root;
		
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			int cval = (int)c - 97;
			if(temp.tarr[cval] == null){
				return false;
			}
			temp = temp.tarr[cval];
		}
		if(temp.marker == true){
			return true;
		}
		return false;
	}
	
	public boolean removeString(String s){
		
		return false;
	}
	
}
