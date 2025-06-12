package innerclasses_demo;

public class ClassA {

	private void meth1() {
		System.out.println("I am from Outer Class method..");
	}
	public static void main(String[] args) {
		ClassA.InnerClass  a= new ClassA().new InnerClass();
		a.meth2();
		
	}
	ClassA() {
		System.out.println("I am from Outer Class Constructor..");
	}
	class InnerClass {
		void meth2() {
			System.out.println("I am from Inner Class method..");
			meth1();
		}
		
		InnerClass(){
			System.out.println("I am from Inner Class Constructor..");
		}
	}
	
}
