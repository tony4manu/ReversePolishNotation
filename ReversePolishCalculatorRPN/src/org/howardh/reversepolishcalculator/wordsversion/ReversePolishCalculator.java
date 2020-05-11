/*
 * ReversePolishCalculator.java		 (words version)
 * Howard Higgins
 * 20200510
 * 
 * Screening Test 
 * 
 * A stack based (like reverse polish) calculator.
 */
package org.howardh.reversepolishcalculator.wordsversion;

import java.util.EmptyStackException;
import java.util.Stack;

public class ReversePolishCalculator {

	public static double compute(String expression) throws
				EmptyStackException, ArithmeticException {
		Stack<Double> stack = new Stack<>();
		
		String expr = convertString(expression);
		
		System.out.println("Converted: " + expr);
		System.out.println("Input\tOperation\tStack after");

		for (String token : expr.split("\\s+")) {
			System.out.print(token + "\t");
			switch (token) {
				case "+":
					System.out.print("Operate\t\t");
					stack.push(stack.pop() + stack.pop());
					break;
				case "-":
					System.out.print("Operate\t\t");
					stack.push( -stack.pop() + stack.pop());
					break;
				case "*":
					System.out.print("Operate\t\t");
					stack.push(stack.pop() * stack.pop());
					break;
				case "/":
					System.out.print("Operate\t\t");
					stack.push(stack.pop() / stack.pop());
					break;
				default:
					System.out.print("Push\t\t");
					stack.push(Double.parseDouble(token));
					break;
			}
			System.out.println(stack);
		}

		return stack.pop();
	}
	
	public static String convertString(String expr) {
		String s = "";
		System.out.println("Expression: " + expr);
		for (String token : expr.toUpperCase().split("\\s+")) {
			switch (token) {
				case "ONE": s = s + " 1";
					break;
				case "TWO": s = s + " 2";
					break;
				case "THREE": s = s + " 3";
					break;
				case "FOUR": s = s + " 4";
					break;
				case "FIVE": s = s + " 5";
					break;
				case "SIX": s = s + " 6";
					break;
				case "SEVEN": s = s + " 7";
					break;
				case "EIGHT": s = s + " 8";
					break;
				case "NINE": s = s + " 9";
					break;
				case "ZERO": s = s + " 0";
					break;
				case "ADD": s = s + " +";
					break;
				case "MINUS": s = s + " -";
					break;
				case "MULTIPLY": s = s + " *";
				break;
				case "DIVIDE": s = s + " /";
					break;
				default:
					System.out.println("Error: Invalid value entered. [" + token + "]");
					System.exit(-1);
					break;
			}
		}
		
		return s.trim();
	}
	
	/**
	 * Runs the calculation for the RPN expression in args[0].
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			try {
				System.out.println("Final answer: " + compute(args[0]));
			} catch (Exception err) {
				System.out.println("Error: " + err.getMessage());
				System.out.println(err.toString());
			}
		} else {
			System.out.println("Reverse Polish Calcutor (words version)");
			System.out.println("Usage: ReversePolishCalcutor NINE THREE MULTIPLY");
			System.exit(0);
		}
	}
	
}
/* Output:
java ReversePolishCalculator FIVE FOUR ADD
Expression: FIVE FOUR ADD
Converted: 5 4 +
Input	Operation	Stack after
5	Push		[5.0]
4	Push		[5.0, 4.0]
+	Operate		[9.0]
Final Answer: 9.0

---------
Expression: ONE TWO ADD THREE ONE MINUS FIVE ADD
Converted: 1 2 + 3 1 - 5 +
Input	Operation	Stack after
1	Push		[1.0]
2	Push		[1.0, 2.0]
+	Operate		[3.0]
3	Push		[3.0, 3.0]
1	Push		[3.0, 3.0, 1.0]
-	Operate		[3.0, 2.0]
5	Push		[3.0, 2.0, 5.0]
+	Operate		[3.0, 7.0]
Final answer: 7.0

-----------
Expression: ONE TWO ADD THREE ONE MINUS FIVE ADD MINUS
Converted: 1 2 + 3 1 - 5 + -
Input	Operation	Stack after
1	Push		[1.0]
2	Push		[1.0, 2.0]
+	Operate		[3.0]
3	Push		[3.0, 3.0]
1	Push		[3.0, 3.0, 1.0]
-	Operate		[3.0, 2.0]
5	Push		[3.0, 2.0, 5.0]
+	Operate		[3.0, 7.0]
-	Operate		[-4.0]
Final answer: -4.0
*/