package singleton;

public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) {	
		MySingletonLazy lazy = MySingletonLazy.getInstance();	
		MySingletonEnum myEnum = MySingletonEnum.INSTANCE;
		System.out.println(myEnum.getVal());
		myEnum.setVal(32);		
		System.out.println(myEnum.getVal());
		myEnum.setVal(33);	
		System.out.println(myEnum.getVal());
	}

}
