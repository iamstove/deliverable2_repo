package com.laboon;
import static org.junit.Assert.*;

import org.junit.Test;

public class CoffeeMakerTest{

	@Test
	public void runGameLoopTest(){
		fail("No test");
	}

	@Test
	public void runArgsTest(){
		//this function always returns zero, could also test it prints correctly
		CoffeeMaker testcm = new CoffeeMaker();
		int retval = testcm.runArgs("string"); //the input string is irrelevant
		AssertEquals(retval, 0);
	}

	@Test
	public void 
}