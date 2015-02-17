package com.laboon;
import static org.junit.Assert.*;

import java.io.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class PlayerTest{

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
	public void testGetSugar(){
		Player testPlayer = new Player(false, false, false); //create a new player with no items
	}

	@Test
	public void testGetCoffee(){
		Player testPlayer = new Player(false, false, false); //create a new player with no items
	}

	@Test
	public void testGetCream(){
		Player testPlayer = new Player(false, false, false); //create a new player with no items
	}

	@Test
	public void testHasAllItems(){
		Player testPlayer = new Player(false, false, false); //create a player with no items 
		boolean result = testPlayer.hasAllItems();

		assertFalse(result);
		
		testPlayer.getSugar();
		result = testPlayer.hasAllItems();
		assertFalse(result);

		testPlayer.getCream();
		result = testPlayer.hasAllItems();
		assertFalse(result);

		testPlayer.getCoffee();
		result = testPlayer.hasAllItems();
		assertTrue(result);
	}

	@Test
	public void testDrinkFalse(){
		Player testPlayer = new Player(); //all false player
		boolean result = testPlayer.drink();
		assertFalse(result); //none
		
		
		testPlayer.getCoffee();
		result = testPlayer.drink();
		assertFalse(result); //coffee
		
		
		testPlayer.getSugar();
		result = testPlayer.drink();
		assertFalse(result); //coffee + sugar
		
		
		Player testPlayer2 = new Player(false, true, false); //player just has cream
		result = testPlayer2.drink();
		assertFalse(result); //cream
		
		
		testPlayer2.getCoffee();
		result = testPlayer2.drink();
		assertFalse(result); //cream + coffee
		
		
		Player testPlayer3 = new Player(true, false, false); //player just sugar
		result = testPlayer3.drink();
		assertFalse(result); //sugar
		

		testPlayer3.getCream();
		result = testPlayer3.drink();
		assertFalse(result); //sugar + cream
	}

	@Test
	public void testDrinkTrue(){
		Player testPlayer = new Player(true, true, true); //player with all the items
		boolean result = testPlayer.drink();
		assertTrue(result);
	}
}
