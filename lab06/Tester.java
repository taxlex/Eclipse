package lab06;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tester {

	@Test
	public void testFactorialFive(){
	assertEquals(120, Loops.slowFactorial(5));
	assertEquals(3628800, Loops.slowFactorial(10));
	assertEquals(6, Loops.slowFactorial(3));
	assertEquals(1, Loops.slowFactorial(0));
	}
	@Test
	public void testFactorialTwelve(){
	assertEquals(479001600, Loops.slowFactorial(12));
	
	}
	@Test(expected=IllegalArgumentException.class)
	public void testFactorialNegative(){
		Loops.slowFactorial(-1);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testFactorialNegative1(){
		Loops.slowFactorial(-4);
	}

}
