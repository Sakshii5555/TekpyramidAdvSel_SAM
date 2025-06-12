package method_reference;

public class Demo1 {

	public static void main(String[] args) {
		new Demo1().display();

	}
	void display() {
		System.out.println("Implementing Method referencing..");
		InterfaceA i = Test1 :: new;
		i.meth1();
	}
}
