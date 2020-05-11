/*
ReversePolishCalculatorTest.java  RPN

Test for ReversePolishCalculator class Works! :D
20200509Sa
*/
package org.tonyh;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReversePolishCalculatorRPNTest {

	static ReversePolishCalculatorRPN revPolCalc;
	private double TEST_DELTA = 0.00001;
	
	@Before
	public void setUp() throws Exception {
		revPolCalc = new ReversePolishCalculatorRPN();
		revPolCalc = null;
	}

	//@SuppressWarnings("static-access")
	@Test
	public void testCompute() {
		System.out.println("# Calcluate +");
		String expression = "1 1 +";
		double expResult = 2.0;
		double result = ReversePolishCalculatorRPN.compute(expression);
		assertEquals(expResult, result, TEST_DELTA);
		

		System.out.println("\n# Calcluate /");
		expression = "1 3 /";
		expResult = 0.33333;
		result = ReversePolishCalculatorRPN.compute(expression);
		assertEquals(expResult, result, TEST_DELTA);	
	}
	
	@Test
	public void testComputeOnGivenExpresstion()  {
		String expression = "3 2 + 8 4 * -";
		System.out.println("calculate \"" + expression + "\"");
		double expResult = -27.0;
		double result = ReversePolishCalculatorRPN.compute(expression);
		assertEquals(expResult, result, TEST_DELTA);
	}
	
	@Test
	public void testComputeWithObelusMultiply() {
		String expression = "5 3 \u00D7";
		String exprWAsterisk = expression.replace("\u00D7", "*");	// Multiply sign
		System.out.println("calculate -" + expression +
				"\" should work the same as " + exprWAsterisk);
		double expResult = 15.0;
		double result = ReversePolishCalculatorRPN.compute(expression);
		assertEquals(expResult, result, TEST_DELTA);
		
		double resultWSlash = ReversePolishCalculatorRPN.compute(exprWAsterisk);
		assertEquals(result, resultWSlash, TEST_DELTA);
	}
	
	
	@Test
	public void testComputeWithObelusDivision() {
		String expression = "8 2 \u00F7";
		String exprWSlash = expression.replace("\u00F7", "/");	// division sign
		System.out.println("calculate \"" + expression + "\" should work the same as " + exprWSlash);
		double expResult = 4.0;
		double result = ReversePolishCalculatorRPN.compute(expression);
		assertEquals(expResult, result, TEST_DELTA);
		
		double resultWSlash = ReversePolishCalculatorRPN.compute(exprWSlash);
		assertEquals(result, resultWSlash, TEST_DELTA);
	}

	@Test
	public void testComputeWithDivision() {
		String expression = "59 7 /";
		double expResult = 8.42857;
		double result = ReversePolishCalculatorRPN.compute(expression);
		assertEquals(expResult, result, TEST_DELTA);
	}
	
	
	@Test
	public void testComputeWithObelusSubtraction() {
		String expression = "5 2 \u2212";
		String exprWHyphen = expression.replace("\u2212", "-");	// minus sign
		System.out.println("calculate -" + expression +
				"\" should work the same as " + exprWHyphen);
		double expResult = 3.0;
		double result = ReversePolishCalculatorRPN.compute(expression);
		assertEquals(expResult, result, TEST_DELTA);
		
		double resultWSlash = ReversePolishCalculatorRPN.compute(exprWHyphen);
		assertEquals(result, resultWSlash, TEST_DELTA);
	}
	
	
	@Test
	public void testComputeWithAddition() {
		String expression = "9 7 +";
		double expResult = 16.0;
		double result = ReversePolishCalculatorRPN.compute(expression);
		assertEquals(expResult, result, TEST_DELTA);
	}

	@After
	public void tearDown() throws Exception {
		revPolCalc = null;
	}

}
