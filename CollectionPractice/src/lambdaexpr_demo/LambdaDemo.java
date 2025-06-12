package lambdaexpr_demo;

public class LambdaDemo {

	public void Testt() {
		System.out.println("Implementation of Lambda Expression - ");
		Demo d = () -> System.out.println("I am from 1st Interface");
		d.test();
		
		Demo1 dd = (int a, int b) -> {
			if(a<10)
				return a+b;
			else
				return a-b;
		};
		System.out.println("I am from 2nd Interface -  "+dd.test1(2, 40));
	}
	public static void main(String[] args) {
		new LambdaDemo().Testt();

	}

}
