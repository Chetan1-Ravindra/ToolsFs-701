package com.nt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.nt.service.ArithmeticOp;

@TestInstance(Lifecycle.PER_CLASS)
public class ArithmeticOpTest {

	private static ArithmeticOp op;
	
	@BeforeAll
	public static void tearOnce()
	{
		op = new ArithmeticOp();
	}
	
	@Test
	public void testSumWithPositive()
	{
		int a=10,b=20;
		int expacted=30;
		int actual=op.sum(a,b);
		assertEquals(expacted,actual);	
	}
	
	@Test 
	public void testSumWithNegative()
	{
		int a=-10,b=-20;
		int expacted=-30;
		int actual=op.sum(a,b);
		assertEquals(expacted,actual);
	}
}
