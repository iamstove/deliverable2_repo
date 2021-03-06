package com.laboon;

<<<<<<< Updated upstream
import java.io.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.mockito.*;


public class GameTest{

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	//This code runs before each test and sets up the outcontent object to catch println statements
	@Before
	public void setUpStreams() { //capture output to stdout 
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}
	
	//close the streams that were opened in before
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}

	//This function tests the case insensitivity of the program, each result should be the same because each should run the same code
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

	//Tests dosomething with N and makes sure that house.moveNorth is called twice
	@Test
	public void testN(){
	    House mockedHouse =  mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game testGame = new Game(mockedPlayer, mockedHouse);
		testGame.doSomething("N");
		testGame.doSomething("n");
		verify(mockedHouse, times(2)).moveNorth();
	}

	//Tests dosomething with N and makes sure that house.moveSouth is called twice
	@Test
	public void testS(){
	    House mockedHouse =  mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game testGame = new Game(mockedPlayer, mockedHouse);
		testGame.doSomething("S");
		testGame.doSomething("s");
		verify(mockedHouse, times(2)).moveSouth();
	}

	//Tests doSometing with L and makes sure that player.look is called twice
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

	//Tests doSomething with I and makes sure that player.showInvintory is called twice
	@Test
	public void testI(){
	    House mockedHouse =  mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game testGame = new Game(mockedPlayer, mockedHouse);
		testGame.doSomething("I");
		testGame.doSomething("i");
		verify(mockedPlayer, times(2)).showInventory();
	}

	//this test assumes the function Game.help exists and prints to the screen some help message this 
	//help message is captured and compared to some previously agreed upon message, in this case it's simply <help message>
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

	//Tests drink where the player should win, this is done by mocking the player and when drink is called having it just return true (which is the win condition)
	@Test
	public void testDWin(){
	    House mockedHouse =  mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game testGame = new Game(mockedPlayer, mockedHouse);
		when(mockedPlayer.drink()).thenReturn(true);

		assertEquals(testGame.doSomething("D"),1);
		assertEquals(testGame.doSomething("d"),1);
	}

	//Tests drink where the player should lose, this is done by mocking the player and when drink is called having it just return false
	//where false is the lose condition
	@Test
	public void testDLose(){
	    House mockedHouse =  mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game testGame = new Game(mockedPlayer, mockedHouse);
		when(mockedPlayer.drink()).thenReturn(false);

		assertEquals(testGame.doSomething("D"),-1);
		assertEquals(testGame.doSomething("d"),-1);
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
}