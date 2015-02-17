package com.laboon;
import static org.junit.Assert.*;

import java.io.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class GameTest{

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() { //capture output to stdout 
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));

	    House mockedHouse =  mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game testGame = new Game(mockedPlayer, mockedHouse);
	}
	

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}

	@Test
	public void testCase(){
	    House mockedHouse =  mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game testGame = new Game(mockedPlayer, mockedHouse);
		assertEquals(testGame.doSomething("n"),testGame.doSomething("N"));
		assertEquals(testGame.doSomething("s"),testGame.doSomething("S"));
		assertEquals(testGame.doSomething("l"),testGame.doSomething("L"));
		assertEquals(testGame.doSomething("i"),testGame.doSomething("I"));
		assertEquals(testGame.doSomething("h"),testGame.doSomething("H"));
		assertEquals(testGame.doSomething("D"),testGame.doSomething("D"));

	}

	@Test
	public void testN(){
	    House mockedHouse =  mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game testGame = new Game(mockedPlayer, mockedHouse);
		testGame.doSomething("N");
		testGame.doSomething("n");
		verify(mockedHouse, times(2)).moveNorth();
	}

	@Test
	public void testS(){
	    House mockedHouse =  mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game testGame = new Game(mockedPlayer, mockedHouse);
		testGame.doSomething("S");
		testGame.doSomething("s");
		verify(mockedHouse, times(2)).moveSouth();
	}

	@Test
	public void testL(){
	    House mockedHouse =  mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Room mockedRoom = mock(Room.class);
		Game testGame = new Game(mockedPlayer, mockedHouse);
		testGame.doSomething("L");
		testGame.doSomething("l");
		verify(mockedHouse, times(2)).look(mockedPlayer,null);
	}

	@Test
	public void testI(){
	    House mockedHouse =  mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game testGame = new Game(mockedPlayer, mockedHouse);
		testGame.doSomething("I");
		testGame.doSomething("i");
		verify(mockedPlayer, times(2)).showInventory();
	}

	//this test assumes the function Game.help exists and prints to the screen some help message this help message is captured and compared to some previously agreed upon message, in this case it's simply <help message>

	@Test
	public void testH(){
	    House mockedHouse =  mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game testGame = new Game(mockedPlayer, mockedHouse);
		//capture prints
		testGame.doSomething("H");
		testGame.doSomething("h");
		assertEquals(outContent.toString(), "<help message>");
	}

	@Test
	public void testDWin(){
	    House mockedHouse =  mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game testGame = new Game(mockedPlayer, mockedHouse);
		when(mockedPlayer.drink()).thenReturn(true);

		assertEquals(testGame.doSomething("D"),1);
		assertEquals(testGame.doSomething("d"),1);
	}

	@Test
	public void testDLose(){
	    House mockedHouse =  mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game testGame = new Game(mockedPlayer, mockedHouse);
		when(mockedPlayer.drink()).thenReturn(false);

		assertEquals(testGame.doSomething("D"),-1);
		assertEquals(testGame.doSomething("d"),-1);
	}
}
