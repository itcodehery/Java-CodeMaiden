package calculator_beta;
import java.util.*;
public class Calculator {
		public static void main(String[] args) {
			Scanner getScan = new Scanner(System.in);
			boolean isFalse = false;
			while(!isFalse) {
				System.out.println("Enter an expression(ex: 1+3): ");
				String expression = getScan.nextLine();
				String[] parts = expression.split(" ");
				if(parts.length != 3) {
					System.out.println("Enter a valid expression! ");
					continue;
				}
				try {
					double op1 = Double.parseDouble(parts[0]);
					String operand = parts[1];
					double op2 = Double.parseDouble(parts[2]);
					double res = 0.0;
					switch(operand) {
					case "+": res = op1 + op2;
					break;
					
					case "-": res = op1 - op2;
					break;
					
					case "*": res = op1 * op2;
					break;
					
					case "/": res = op1 / op2;
					break;
					
					case "^": res = Math.pow(op1, op2);
					break;
					
					case "%": res = (( op1 / op2 )* 100.0);
					break;
				
					}
					System.out.println("= " + res);
				}catch(NumberFormatException e) {
					System.out.println("Invalid values!");
				}
				System.out.println("Do you want to continue?(Y/N): ");
				String ans = getScan.nextLine();
				ans = ans.toLowerCase();
				if(!ans.equalsIgnoreCase("y")){
					getScan.close();
					System.exit(0);
				}
			}
		}
}
//Output: 
//	Enter an expression(ex: 2+3): 
//	The result = 5
// Do you want to continue?(y/n): y