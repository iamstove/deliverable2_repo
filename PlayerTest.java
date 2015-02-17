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
		Player testPlayer = new Player(); //create a player with no items 
		boolean result = testPlayer.hasAllItems();

		AssertFalse(result);
		
		testPlayer.getSugar();
		result = testPlayer.hasAllItems();
		AssertFalse(result);

		testPlayer.getCream();
		result = testPlayer.hasAllItems();
		AssertFalse(result);

		testPlayer.getCoffee();
		result = testPlayer.hasAllItems();
		AssertTrue(result);
	}

	@Test
	public void testShowInvintoryCream(){
		Player testPlayer = new Player();
		testPlayer.showInvintory();
		AssertEqual("YOU HAVE NO COFFEE!\nYOU HAVE NO CREAM!\nYOU HAVE NO SUGAR!\n");
		testPlayer.getCream();
		AssertEqual("YOU HAVE NO COFFEE!\nYou have some fresh cream.\nYOU HAVE NO SUGAR!\n");
	}

	@Test
	public void testShowInvintorySugar(){
		Player testPlayer = new Player();
		testPlayer.showInvintory();
		AssertEqual("YOU HAVE NO COFFEE!\nYOU HAVE NO CREAM!\nYOU HAVE NO SUGAR!\n");
		testPlayer.getSugar();
		AssertEqual("YOU HAVE NO COFFEE!\nYOU HAVE NO CREAM!\nYou have some tasty sugar.\n");
	}

	@Test
	public void testShowInvintoryCoffee(){
		Player testPlayer = new Player();
		testPlayer.showInvintory();
		AssertEqual("YOU HAVE NO COFFEE!\nYOU HAVE NO CREAM!\nYOU HAVE NO SUGAR!\n");
		testPlayer.getCoffee();
		AssertEqual("You have a cup of delicious coffee.\nYOU HAVE NO CREAM!\nYOU HAVE NO SUGAR!\n");
	}

	@Test
	public void testDrinkFalse(){
		Player testPlayer = new Player(); //all false player
		boolean result = testPlayer.drink();
		AssertFalse(result);
		testPlayer.getCoffee();
		result = testPlayer.drink();
		AssertFalse(result);
		testPlayer.getSugar();
		result = testPlayer.drink();
		AssertFalse(result);
		Player testPlayer = new Player()
	}


	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
}