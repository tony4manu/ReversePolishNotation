/* 
JUnit 4.12.0

Howard Higgins
20200510

COMMENTS:
1. Maybe do a divide by zero test
2. If possible test when convertString receives an invalid expression
	Example: expression = "one fred divide";
*/

package org.howardh.reversepolishcalculator.wordsversion;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.EmptyStackException;

public class ReversePolishCalculatorTest {
	
	private double TEST_DELTA = 0.00001;	// Precision level
	
	@Test
	public void testConvertString() {
		System.out.println("# ConvertString");
		String expression = "FIVE FOUR ADD";
		String expResult = "5 4 +";
		String result = ReversePolishCalculator.convertString(expression);
		assertEquals(expResult, result);
	}

	@Test
	public void testConvertString1() {		
		System.out.println("\n# ConvertString #1");
		String expression = "SEVEN ONE MINUS";
		String expResult = "7 1 -";
		String result = ReversePolishCalculator.convertString(expression);
		assertEquals(expResult, result);
	}

	@Test
	public void testCompute() {
		System.out.println("# Calcluate +");
		String expression = "TWO THREE ADD";
		double expResult = 5.0;
		double result = ReversePolishCalculator.compute(expression);
		assertEquals(expResult, result, TEST_DELTA);
	}
	
	@Test
	public void testFourDigits() {
		System.out.println("# Calculate testFourDigits + -");
		String expression = "ONE TWO ADD THREE ONE MINUS";
		double expResult = 2.0;
		double result = ReversePolishCalculator.compute(expression);
		assertEquals(expResult, result, TEST_DELTA);
	}

	@Test
	public void testComputeFourDigitsThenDivision() {
		System.out.println("# ComputeFourDigitsThenDivide + -");
		String expression = "NINE SIX MULTIPLY ONE THREE ADD DIVIDE";
		double expResult = 0.07407;
		double result = ReversePolishCalculator.compute(expression);
		assertEquals(expResult, result, TEST_DELTA);
	}

	@Test(expected = EmptyStackException.class)  // java.util.EmptyStackException
	public void testEmptyStackExceptionThrown() {
		System.out.println("# testEmptyStackExceptionThrown");
		String expression = "NINE SIX MULTIPLY ADD ONE THREE DIVIDE";
		ReversePolishCalculator.compute(expression);
	}
	
}

