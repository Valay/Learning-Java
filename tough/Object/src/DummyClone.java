// Learning Clonable method of object!


public class DummyClone implements Cloneable{
	int i = 0;
	char c = 'c';
	String s = "hello";
	
	public DummyClone(int I, char C, String S){
		i = I;
		c = C;
		s =S;
	}
	
	public DummyClone(){
		// do nothing constructor
	}
	
	protected Object clone(){
		DummyClone d = new DummyClone();
		d.i = i;
		d.c = c;
		d.s = s;
		return d;
	}
	
	public boolean equals(Object o){
		if(!(o instanceof DummyClone )){
			return false;
		}
		
		if(o == this){
			return true;
		}
		DummyClone dc = (DummyClone)o;
		
		if(i == dc.i && c == dc.c && s.equals(dc.s) ){
			return true;
		}
		return false;
	}
}
