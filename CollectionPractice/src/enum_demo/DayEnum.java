package enum_demo;

import java.util.Scanner;

public class DayEnum {

	public static void main(String[] args) {
		DayEnum de = new DayEnum();
		String n = de.display();
		System.out.println("Task is - "+n);
		de.diplayDay();

	}
	String display() {
		Days d = Days.Saturday;
		System.out.println("here I'm printing from Enum class - "+d);
		
		String Task = "";
		Scanner sc = new Scanner(System.in);
		
		switch(d) {
			case Sunday:
				System.out.println("User Selected Day as Sunday ");
				System.out.println("please assign Task for that Day - ");
				Task = sc.nextLine();
				break;
				
			case Monday:
				System.out.println("User Selected Day as Monday ");
				System.out.println("please assign Task for that Day - ");
				Task = sc.nextLine();
				break;
				
			case Tuesday:
				System.out.println("User Selected Day as Tuesday ");
				System.out.println("please assign Task for that Day - ");
				Task = sc.nextLine();
				break;
				
			case Wednesday:
				System.out.println("User Selected Day as Wednesday ");
				System.out.println("please assign Task for that Day - ");
				Task = sc.nextLine();
				break;
				
			case Thursday:
				System.out.println("User Selected Day as Thursday ");
				System.out.println("please assign Task for that Day - ");
				Task = sc.nextLine();
				break;
				
			case Friday:
				System.out.println("User Selected Day as Friday ");
				System.out.println("please assign Task for that Day - ");
				Task = sc.nextLine();
				break;
				
			case Saturday:
				System.out.println("User Selected Day as Saturday ");
				System.out.println("please assign Task for that Day - ");
				Task = sc.nextLine();
				break;
				
			default:
				System.out.println("Invalid Data");
				break;
		}
		return Task;
		
		}
	void diplayDay() {
		System.out.println("\nDisplay Day using for each loop - ");
		for(Days e: Days.values()) {
			System.out.println(".."+e);
		}
		
		System.out.println("\n Displaying Day using Array AND for loop - ");
		Days arr[] = Days.values();
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println("..."+arr[i]);
		}
	}
}
