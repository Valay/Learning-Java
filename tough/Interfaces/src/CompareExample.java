
public class CompareExample implements Comparable<CompareExample>{

	private final String FirstName, LastName;
	
	public CompareExample(String FN, String LN){
		if(FN == null || LN == null){
			throw new NullPointerException();
		}
		this.FirstName = FN;
		this.LastName = LN;
	}
	
	// Overriding the equals method from Object class
	public boolean equals(Object o){
		if(!(o instanceof CompareExample)){
			return false;
		}
		CompareExample ce = (CompareExample) o;
		return (ce.FirstName == this.FirstName && ce.LastName == this.LastName);
	}
	
	// overriding the hashCode method of the Object class
	public int hashCode(){
		return 43*this.FirstName.hashCode() + this.LastName.hashCode();
	}
	
	// implementing the compareTo method of the Comparable interface
	public int compareTo(CompareExample arg) {
		int lname = this.LastName.compareTo(arg.LastName);
		
		return lname != 0? lname : this.FirstName.compareTo(arg.FirstName);
	}
	
	// overriding toString method of Object class
	public String toString(){
		return(this.FirstName + " " + this.LastName);
	}
	
	public static void main(String args[]){
		
		CompareExample ce1 = new CompareExample("Valay","Shah");
		CompareExample ce2 = new CompareExample("Karan","Shah");
		CompareExample ce3 = new CompareExample("Valay","Shah");
		
		if(ce1.equals(ce3)){
			System.out.println(ce1);
		}else{
			System.out.println(ce3);
		}
	}
	
}
