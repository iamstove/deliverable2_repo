package com.laboon;
import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest{

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() { //capture output to stdout 
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
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
		Player testPlayer = new Player(true, true, true); //create a player with all items

	}


	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
}