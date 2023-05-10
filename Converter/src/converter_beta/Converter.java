package converter_beta;
import java.util.*;
public class Converter {

	public static double convertLength() {
	    double result = 0.0;
	    boolean forWhile = true;
	    Scanner sc = new Scanner(System.in);
	    double value;
	    while(forWhile) {
	    	System.out.println("Length/Distance Options:");
	    	System.out.println("1. Convert Meters to Centimeters");
	    	System.out.println("2. Convert Centimeters to Meters");
	    	System.out.println("3. Convert Meters to Kilometers");
	    	System.out.println("4. Convert Kilometers to meters");
	    	System.out.println("Enter your choice: ");
	    	int ch = sc.nextInt();
	    	switch(ch) {
	    	case 1: System.out.println("Enter the value in Meters: ");
	    	value = sc.nextDouble();
	    	result = value * 100;
	    	break;
	    	
	    	case 2: System.out.println("Enter the value in Centimeters: ");
	    	value = sc.nextDouble();
	    	result = value / 100;
	    	break;
	    	
	    	case 3: System.out.println("Enter the value in Meters: ");
	    	value = sc.nextDouble();
	    	result = value / 1000;
	    	break;
	    	
	    	case 4: System.out.println("Enter the value in Kilometers: ");
	    	value = sc.nextDouble();
	    	result = value * 1000;
	    	break;
	    	
	    	default: System.out.println("Enter a valid choice!: ");
	    	}
	    	forWhile = false;
	    }
		return result;
	}
	
	public static double convertWeight() {
	    double result = 0.0;
	    boolean forWhile = true;
	    Scanner sc = new Scanner(System.in);
	    double value;
	    while(forWhile) {
	    	System.out.println("Weight Options:");
	    	System.out.println("1. Convert Grams to Kilograms");
	    	System.out.println("2. Convert Kilograms to Grams");
	    	System.out.println("Enter your choice: ");
	    	int ch = sc.nextInt();
	    	switch(ch) {
	    	case 1: System.out.println("Enter the value in Grams: ");
	    	value = sc.nextDouble();
	    	result = value / 1000;
	    	break;
	    	
	    	case 2: System.out.println("Enter the value in Kilograms: ");
	    	value = sc.nextDouble();
	    	result = value * 1000;
	    	break;

	    	
	    	default: System.out.println("Enter a valid choice!: ");
	    	}
	    	forWhile = false;
	    }
		return result;
	}
	
	public static double convertVolume() {
		double result = 0.0;
		boolean forWhile = true;
	    Scanner sc = new Scanner(System.in);
	    double value;
	    while(forWhile) {
	    	System.out.println("Volume Options:");
	    	System.out.println("1. Convert Litres to Millilitres");
	    	System.out.println("2. Convert Millilitres to Litres");
	    	System.out.println("Enter your choice: ");
	    	int ch = sc.nextInt();
	    	switch(ch) {
	    	case 1: System.out.println("Enter the value in Litres: ");
	    	value = sc.nextDouble();
	    	result = value * 1000;
	    	break;
	    	
	    	case 2: System.out.println("Enter the value in Millilitres: ");
	    	value = sc.nextDouble();
	    	result = value / 1000;
	    	break;

	    	
	    	default: System.out.println("Enter a valid choice!: ");
	    	}
	    	forWhile = false;
	    }
		return result;
	}
	
	public static void main(String[] args) {
		Scanner ef = new Scanner(System.in);
		double result = 0.0;
		boolean isTrue = true;
		while(isTrue) {
			System.out.println("Simple Console Converter Program");
			System.out.println("What type of convertion would you like to make?");
			System.out.println("1. Length / Distance");
			System.out.println("2. Weight");
			System.out.println("3. Volume");
			System.out.println("Enter your choice: ");
			int choice = ef.nextInt();
			switch(choice) {
			case 1: result = Converter.convertLength();
			System.out.println("The answer is : " + result);
			break;
			
			case 2: result = Converter.convertWeight();
			System.out.println("The answer is : " + result);
			break;
			
			case 3: result = Converter.convertVolume();
			System.out.println("The answer is : " + result);
			break;
			
			default: System.out.println("Enter a valid choice: ");
			}
			System.out.println("Would you like to continue?(Y/N): ");
			String answer = ef.next();
			if(!answer.equalsIgnoreCase("Y")) {
				isTrue = false;
				System.exit(0);
			}
		}
	}

}
