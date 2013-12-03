import java.util.ArrayList;
import java.util.List;


public class TestEmployee {
	
	
	public static void main(String[] args){
		
		Employee e1 = new Employee(1, "Dan", "Snyder");
		Employee e2 = new Employee(11, "Bruce", "Allen");
		Employee e3 = new Employee(12, "Mike", "Shanahan");
		Employee e4 = new Employee(121, "Kyle","Shanahan");
		Employee e5 = new Employee(122, "Jim", "Haslett");
		Employee e6 = new Employee(123, "Bobby", "Turner");
		Employee e7 = new Employee(1211, "Matt", "LaFleur");
		Employee e8 = new Employee(1212, "Keenan", "McCardell");
		
		List<Employee> s1 = new ArrayList<Employee>();
		s1.add(e2);
		s1.add(e3);
		e1.setSubordinates(s1);
		List<Employee> s3 = new ArrayList<Employee>();
		s3.add(e4);
		s3.add(e5);
		s3.add(e6);
		e3.setSubordinates(s3);
		List<Employee> s4 = new ArrayList<Employee>();
		s4.add(e7);
		s4.add(e8);
		e4.setSubordinates(s4);
		
		e2.setManager(e1);
		e3.setManager(e1);
		e4.setManager(e3);
		e5.setManager(e3);
		e6.setManager(e3);
		e7.setManager(e4);
		e8.setManager(e4);
		
		System.out.println("Managers for "+e1.first_name+" :");
		e1.printCEO();
		System.out.println("Managers for "+e2.first_name+" :");
		e2.printCEO();
		System.out.println("Managers for "+e3.first_name+" :");
		e3.printCEO();
		System.out.println("Managers for "+e4.first_name+" :");
		e4.printCEO();
		System.out.println("Managers for "+e5.first_name+" :");
		e5.printCEO();
		System.out.println("Managers for "+e6.first_name+" :");
		e6.printCEO();
		System.out.println("Managers for "+e7.first_name+" :");
		e7.printCEO();
		System.out.println("Managers for "+e8.first_name+" :");
		e8.printCEO();
		
		System.out.println("Print company :");
		e1.printCompany();
	}
}
