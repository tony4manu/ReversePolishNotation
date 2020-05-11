/*
ReversePolishCalculator.java  RPN

tonyH, 20200509Sa

Based on: https://codereview.stackexchange.com/questions/120451/reverse-polish-notation-calculator-in-java

*/
package org.tonyh;

import java.util.EmptyStackException;
import java.util.Stack;

public class ReversePolishCalculator {
	
	/**
     * Computes the outcome of a given expression in Reverse Polish Notation
     *
     * @param expr the expression to compute
	 * @return 
     */
	public static double compute(String expr) throws
				ArithmeticException, EmptyStackException {
		Stack<Double> stack = new Stack<>();
		
		System.out.println("Expression: " + expr);
		System.out.println("Input\tOperation\tStack after");
		
		for (String token : expr.split("\\s+")) {
			System.out.print(token + "\t");
			switch (token) {
				case "+":
					System.out.print("Operate\t\t");
					stack.push(stack.pop() + stack.pop());
					break;
				case "-":
				case "\u2212":
					System.out.print("Operate\t\t");
					stack.push( -stack.pop() + stack.pop());
					break;
				case "*":
				case "\u00D7":
					System.out.print("Operate\t\t");
					stack.push(stack.pop() * stack.pop());
					break;
				case "/":
				case "\u00F7":
					System.out.print("Operate\t\t");
					double divisor = stack.pop();
					stack.push(stack.pop() / divisor);
					break;
				case "^":
					System.out.print("Operate\t\t");
					double exponent = stack.pop();
					stack.push(Math.pow(stack.pop(), exponent));
					break;
				default:
					System.out.print("Push\t\t");
					stack.push(Double.parseDouble(token));
					break;
			}
			
			System.out.println(stack);
		}
		
		double result = stack.pop();
		System.out.println("Final Answer: " + result);
		
		return result;
	}
	
	/**
	 * Runs the calculation for the RPN expression in args[0].
	 */
	public static void main(String[] args) {
		try {
			compute(args[0]);
		} catch (Exception err) {
			System.out.println("Error: " + err.getMessage());
			System.out.println(err.toString());
		}
	}

}

/*
Sample run:

$ java RPN "3 5 +"
3 5 +
Input   Operation   Stack after
3   Push        [3.0]
5   Push        [3.0, 5.0]
+   Operate     [8.0]
Final Answer: 8.0


###
String expression = "3 2 + 8 4 * -";

Sting expression = "ONE TWO ADD THREE ONE MINUS FIVE ADD"
	"1 2 + 3 1 - 5 +"
*/
