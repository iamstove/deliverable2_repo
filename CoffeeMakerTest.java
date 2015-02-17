package com.laboon;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoffeeMakerTest{

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() { //capture output to stdout 
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}

	@Test
	public void runArgsTest(){
		//this function always returns zero, could also test it prints correctly
		CoffeeMaker testcm = new CoffeeMaker();
		String arg = "string";
		int retval = testcm.runArgs(arg); //the input string is irrelevant
		assertEquals(retval, 0);
	}

	@Test
	public void runGameLoopTestWin(){
		House mockedHouse =  mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game mockedGame = mock(Game.class);
		when(mockedGame.run()).thenReturn(0);
		CoffeeMaker testcm = new CoffeeMaker();

		boolean val = testcm.runGameLoop(mockedPlayer, mockedHouse, mockedGame);

		assertEquals(val, 0);
	}

	@Test
	public void runGameLoopTestLose(){
		House mockedHouse =  mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game mockedGame = mock(Game.class);
		when(mockedGame.run()).thenReturn(1);
		CoffeeMaker testcm = new CoffeeMaker();

		boolean val = testcm.runGameLoop(mockedPlayer, mockedHouse, mockedGame);

		assertEquals(val, 1);

	}
}
