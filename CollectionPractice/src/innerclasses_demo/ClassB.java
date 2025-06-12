package innerclasses_demo;

public class ClassB {
	int a = 10;
	static int b=20;
	
	static class InnerClass {
		void meth1() {
			System.out.println("--------------------------");
			System.out.println("Inner class method..");
			System.out.println("Value of a - "+new ClassB().a);
			System.out.println("Value of b - "+b);
		}
		static {
			System.out.println("--------------------------");
			System.out.println("Inner class Static Block..");
		}
		InnerClass(){
			System.out.println("---------------------------");
			System.out.println("Inner class Constructor..");
		}
		public static void main(String[] args) {
			System.out.println("---------------------------");
			System.out.println("Inner class main method..");
			new InnerClass().meth1();
		}
	}
	static {
		System.out.println("............................");
		System.out.println("Outer class Static Block..");
	}
	ClassB(){
		System.out.println("Outer class Constructor..");
	}
	public static void main(String[] args) {
		System.out.println("Outer class main method..");
		
		//System.out.println("Value of a - "+ new ClassB().a);
		System.out.println("Value of b- "+b);
	}
}
