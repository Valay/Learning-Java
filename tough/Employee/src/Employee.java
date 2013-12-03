import java.util.List;

public class Employee {
	int id;
	String first_name;
	String last_name;
	
	Employee manager;
	List<Employee> subordinates;
	
	public Employee(int iden, String fname, String lname){
		id = iden;
		first_name = fname;
		last_name = lname;
	}
	
	public void setManager(Employee man){
		manager = man;
	}
	
	public void setSubordinates(List<Employee> sub){
		subordinates = sub;
	}
	
	public void printSubordinates(){
		//System.out.println("Subordinates for employee "+first_name+" are :");
		if(subordinates != null){
			for(Employee e: subordinates){
				System.out.println(e.first_name);
				e.printSubordinates();
			}
		}
	}
	
	public void printCEO(){
		System.out.println(findCEO().first_name);
	}
	
	public void printCompany(){
		Employee CEO = findCEO();
		System.out.println(first_name);
		CEO.printSubordinates();
	}
	
	private Employee findCEO(){
		while(this.manager != null){
			return (this.manager.findCEO());
		}
	    return this;
	}
	
}
