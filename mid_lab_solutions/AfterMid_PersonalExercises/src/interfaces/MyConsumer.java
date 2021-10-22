package interfaces;

public interface MyConsumer extends Interface1, Interface2{

	@Override
	default void display() {
		// TODO Auto-generated method stub
		Interface1.super.display();
	}

//	public static void main(String[] args) {
//		//new MyConsumer().display();
//		//new MyConsumer().hello();
//		//Interface1.world();
//		System.out.println("Holla");
//		
////	}

//	@Override
//	public void display() {
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public void display() {
//		System.out.println("Display Implemented from Class");
//	}
//	@Override
//	public void hello() {
//		System.out.println("Hello From Class");
//	}

}
