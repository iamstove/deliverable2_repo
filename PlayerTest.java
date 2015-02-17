package com.laboon;
<<<<<<< Updated upstream
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
=======

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.mockito.*;
>>>>>>> Stashed changes

public class PlayerTest{

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


	//Set up the code that runs before each test, redirects the text output ot the outContent objecct
	@Before
	public void setUpStreams() { //capture output to stdout 
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	//clean up the streams made in before
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}

	//Tests to see if the player has all the items, starting with all false, then with sugar, then with sugar in cream
	//and then with all the items	
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


	/* 	This function checks all the different scenarios where drink could return false.
	*	It creates a new player occasionally to reset the items that the player has picked up.
	*/
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

	//This function checks the one scenario where drink can return true, when the player has all the items
	@Test
	public void testDrinkTrue(){
		Player testPlayer = new Player(true, true, true); //player with all the items
		boolean result = testPlayer.drink();
		assertTrue(result);
	}
}
