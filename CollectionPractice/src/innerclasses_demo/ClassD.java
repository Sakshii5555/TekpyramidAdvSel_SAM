package innerclasses_demo;

public class ClassD {

	static Demo d = new Demo() {
		void print() {
			super.print();
			System.out.println("Thanks allot...");
		}
	};
	public static void main(String[] args) {
		d.print();
	}

}
