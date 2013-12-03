
public class ObjectDriver {

	public static void main(String[] args){
		DummyClone dum = new DummyClone(1, 'c', "hello");
		DummyClone dum1 = (DummyClone)dum.clone();
		//DummyClone dc = new DummyClone();
		//dc = dum;
		System.out.println(dum.equals(dum1));
		System.out.println(dum1.i +" " + dum1.c +" "+ dum1.s);
		System.out.println(dum.getClass().hashCode());
	}
}
