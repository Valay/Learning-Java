package Trie;

public class Trie {

	Boolean marker;
	char c;
	Trie[] tarr;
	
	public Trie(){
		this.marker = false;
		this.tarr = new Trie[27];
	}
}
