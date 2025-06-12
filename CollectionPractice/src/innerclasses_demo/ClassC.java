package innerclasses_demo;

public class ClassC {
	
	void show() {
		String s = "Working in my Favour";
		
		class InnerClass {
			void display() {
				String data =  "Universe is "+ s;
				System.out.println("---------------------------------");
				System.out.println(data);
				System.out.println("---------------------------------");
			}
		}
		new InnerClass().display();
	}
	public static void main(String[] args) {
		new ClassC().show();
	}
}
