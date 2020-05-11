/*
OnOffStates.java
Howard Higgins
20200510

Screening Test 


Instructions
The questions in this test are designed not to be completable in the time allowed so
please make your best attempt at completion but partial answers are perfectly
acceptable.
The time limit for the 2 questions is 1hr and you are free to divide the hour up between
the questions as you see fit.

The coding question(s) is/are best completed in the programming language you are most
familiar with but we have a preference for statically-typed (Java/C# etc.) and/or typeinfered
languages (Haskell/F# etc.), rather than dynamically typed languages
(Python/Javascript etc.). Please supply the code working files on submission of the test.


Coding Question

1. On/Off States
a. Create a method/function that creates a collection of 100 integers (this can
be any array, list, sequence etc) where each integer in the collection has a
value of -1. I.e. [-1,-1,-1,-1,…,-1]

b. Create an additional method/function that is given a 100 element
collection (i.e. the initial collection) and an integer index and returns a 100
element array. The logic of the method/function should change the state of
each element such that if the element has a value of -1 then it should be
changed to a 1, and if the element is 1 then it should be changed to -1.
Which elements are switched should be dependent on the index supplied
to the method/function i.e. if the index supplied is 1, then every element of
the array should have its value changed, i.e.:
[1,1,1,1,…]
If the index is 3, then every third element’s state should be switched, i.e.:
[-1,-1,1,-1,-1,1,-1,…]

c. Create a final method (or unit test) that creates the initial collection and
repeatedly applies the method/function from part b (making sure that the
output array from each application is the input array to the next
application of the method/function. The logic of the method/test should
apply the function 100 times, with the integer index matching the number
of times the method is being applied. I.e. if it is the 2nd application of the
method, then the index should be 2 and if it is the 88th application of the
method then the index should be 88. Once the method has run please
output/print the value of the 64th element of the collection.

2. Reverse Polish Calculator
The object of this question is to implement a stack based (like reverse polish)
calculator. The user will enter the equation in the form of words in the
Console/REPL, i.e. ONE TWO ADD THREE ONE MINUS FIVE ADD and the result for
that equation should be 4

a. Create an elegant solution that will return the correct result for equations
that are entered into the Console/REPL. The solution should support the
operators ADD, MINUS, MUTIPLY and DIVIDE. The solution should have
sufficient error handling
*/

package org.howardh.onoffstates;

public class OnOffStates {
	
	// Test method
	public static void pr(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println( (i+1) + ": " + a[i]);
		}
	}
	
	/**
	 * 1.a. Creates a collection of 100 integers where each integer in the collection has a value of -1.
	 */
	public static int[] setStates(int sz, int val) {
		int[] a = new int[sz];
		for (int i = 0; i < a.length; i++) {
			a[i] = val;
		}
		
		return a;
	}
	
	/**
	 * 1.b. Change value of each nth element - if it's value is -1 change to a 1
	 */
	public static void changeStates(int[] a, int index) {
		int j = 1;
		for (int i = 0; i < a.length; i++) {
			if ( j == index) {
				if ( a[i] == -1 ) { 
					a[i] = 1;
				} else {
					a[i] = -1;
				}
				j = 0;
			}
			j++;
		}
	}
	
	/* 
	 * 1.c. Driver and Test
	 */
	public static void main(String[] args) {
		
		// create the initial collection
		int size = 100;
		int[] a = new int[size];
		a = setStates(size, -1);
		//pr(a);
		
		// Repeatedly apply to next list
		for (int i = 0; i < size; i++) {
			changeStates(a, i);
			
		}
		
		pr(a);
		System.out.println("64th element: " + a[63]);
	}
	
}
/* Output:
64th element: 1
*/