package org.howardh.reversepolishcalculator.wordsversion;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Test;

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
	
	@Test	// TODO as not testing correctly
	public void testConvertStringInvalidValueEntered() {		
		System.out.println("\n# ConvertString - Invalid value");
		String expression = "one fred divide";
		String expResult = "1 fred /";
		String result = ReversePolishCalculator.convertString(expression);
		assertNotEquals(expResult, result);
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
	
}

