 package com.laboon;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoffeeMakerTest{
	//Tests to make sure the run args test function works by making sure it returns zero
	@Test
	public void runArgsTest(){
		//this function always returns zero, could also test it prints correctly
		CoffeeMaker testcm = new CoffeeMaker();
		String arg = "string";
		int retval = testcm.runArgs(arg); //the input string is irrelevant
		assertEquals(retval, 0);
	}

	//Test run game loop with a winner by mocking a game that returns 0 when called
	@Test
	public void testRunGameLoopWin(){ //0 for win 1 for lose
		House mockedHouse =  mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game mockedGame = mock(Game.class);
		CoffeeMaker testcm = new CoffeeMaker();
		when(mockedGame.run())thenReturn(0);

		boolean ret = cm.runGameLoop(mockedPlayer, mockedHouse, mockedGame);
		assertEquals(ret, 0);
	}

	//Test run game loop with losing by mocking a game that returns 1 when called
	@Test
	public void testRunGameLoopLose(){ //0 for win 1 for lose
		House mockedHouse =  mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game mockedGame = mock(Game.class);
		CoffeeMaker testcm = new CoffeeMaker();
		when(mockedGame.run())thenReturn(1);

		boolean ret = cm.runGameLoop(mockedPlayer, mockedHouse, mockedGame);
		assertEquals(ret, 1);
	}
}
