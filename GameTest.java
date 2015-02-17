package com.laboon;
import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.*;
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

	//no test for the constructor, that can't be tested
	@Test
	public void testCase(){
		assertEquals(testGame.doSomething("n"),testGame.doSomething("N"));
		assertEquals(testGame.doSomething("s"),testGame.doSomething("S"));
		assertEquals(testGame.doSomething("l"),testGame.doSomething("L"));
		assertEquals(testGame.doSomething("i"),testGame.doSomething("I"));
		assertEquals(testGame.doSomething("h"),testGame.doSomething("H"));
		assertEquals(testGame.doSomething("D"),testGame.doSomething("D"));

	}

	@Test
	public void testN(){
		testGame.doSomething("N");
		testGame.doSomething("n");
		verify(mockedHouse, times(2)).moveNorth();
	}

	@Test
	public void testS(){
		testGame.doSomething("S");
		testGame.doSomething("s");
		verify(mockedHouse, times(2)).moveSouth();
	}

	@Test
	public void testL(){
		testGame.doSomething("L");
		testGame.doSomething("l");
		verify(mockedHousee, times(2)).moveLook();
	}

	@Test
	public void testI(){
		testGame.doSomething("I");
		testGame.doSomething("i");
		verify(mockedPlayer, times(2)).showInvintory();
	}

	//this test assumes the function Game.help exists and prints to the screen some help message this help message is captured and compared to some previously agreed upon message, in this case it's simply <help message>

	@Test
	public void testH(){
		//capture prints
		testGame.help()
		assertEquals(outContent.toString(), "<help message>");
	}

	@Test
	public void testDWin(){
		when(mockedPlayer.drink()).thenReturn(true);

		assertEquals(testGame.doSomething("D"),1);
		assertEquals(testGame.doSomething("d"),1);
	}

	@Test
	public void testDLose(){
		when(mockedPlayer.drink()).thenReturn(false);

		assertEquals(testGame.doSomething("D"),-1);
		assertEquals(testGame.doSomething("d"),-1);
	}

	@Test
	public void testNumeric(){
		boolean result = testGame.doSomething(1);
		//capture output and compare
		assertEquals(outContent.toString, "What?\n");
		assertEquals(result, 0);
	}

	@Test
	public void testString(){
		boolean result = testGame.doSomething("asdf");
		//capture output and compare
		assertEquals(outContent.toString, "What?\n");
		assertEquals(result, 0);
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}

/*
	@Test
	public void testRunWin(){
		House mockedHouse = mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game testGame = new Game(mockedPlayer, mockedHouse);
		//mock
		when(mockedPlayer.drink()).thenReturn(true);
		//capture output
		testGame.run();
		fail("Not yet implemented");
	}
	@Test
	public void testRunWin(){
		House mockedHouse = mock(House.class);
		Player mockedPlayer = mock(Player.class);
		Game testGame = new Game(mockedPlayer, mockedHouse);
		fail("Not yet implemented");
	}
do I have to do these?*/
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
}