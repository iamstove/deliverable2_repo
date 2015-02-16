package com.laboon;
import static org.junit.Assert.*;

import org.junit.Test;


public class RoomTest 
{
	
	/*
	 Tests that an empty room has no items
	*/
	@Test
	public void testHasItemFalse() 
	{
		Room testRoom;
		
		//empty room
		testRoom = new Room(false, false, false, false, false);
		
		//should return false
		assertFalse(testRoom.hasItem());
	}
	/*
	 tests that a non-empty room has items
	*/
	@Test
	public void testHasItemTrue() 
	{
		Room testRoom1, testRoom2, testRoom3;
		
		//3 rooms, all with a single item
		testRoom1 = new Room(true, false, false, false, false);
		testRoom2 = new Room(false, true, false, false, false);
		testRoom3 = new Room(false, false, true, false, false);
		
		//all rooms should return true
		assertTrue(testRoom1.hasItem() && testRoom2.hasItem() && testRoom3.hasItem());
	}
	
	/*
	 tests than a room with no sugar returns false when checked for sugar
	*/
	@Test
	public void testHasSugarFalse() 
	{
		//room with no sugar, but everything else is true
		Room testRoom = new Room(true, true, false, true, true);
		
		//should be false
		assertFalse(testRoom.hasSugar());
	}

	//tests that a room with sugar returns true when checked for sugar
	@Test
	public void testHasSugarTrue() 
	{
		//room with sugar
		Room testRoom = new Room(false, false, true, false, false);
		
		//should be true
		assertTrue(testRoom.hasSugar());
	}

	//tests that a room with no cream returns false when checked for cream
	@Test
	public void testHasCreamFalse() 
	{
		//room with no cream, but everything else is true
		Room testRoom = new Room(true, false, true, true, true);
		
		//should be false
		assertFalse(testRoom.hasCream());
	}

	//tests that a room with cream returns true when checked for cream
	@Test
	public void testHasCreamTrue() 
	{
		//room with cream
		Room testRoom = new Room(false, true, false, false, false);
		
		//should be true
		assertTrue(testRoom.hasCream());
	}
	
	//tests that a room with no coffee returns false when checked for coffee
	@Test
	public void testHasCoffeeFalse() 
	{
		//room with no coffee, but everything else is true
		Room testRoom = new Room(false, true, true, true, true);
		
		//should be false
		assertFalse(testRoom.hasCoffee());
	}
	
	//tests that a room with coffee returns true when checked for coffee
	@Test
	public void testHasCoffeeTrue() 
	{
		//room with sugar
		Room testRoom = new Room(true, false, false, false, false);
		
		//should be true
		assertTrue(testRoom.hasCoffee());
	}
	
	//tests that a room with no north exit returns false when checked for one
	@Test
	public void testNorthExitFalse() 
	{
		//room with no North exit, but everything else is true
		Room testRoom = new Room(true, true, true, true, false);
		
		//should be false
		assertFalse(testRoom.northExit());
	}
	
	//tests that a room with a north exit returns true when checked for one
	@Test
	public void testNorthExitTrue() 
	{
		//room with North exit
		Room testRoom = new Room(false, false, false, true, false);
		
		//should be true
		assertTrue(testRoom.northExit());
	}
	
	//tests that a room with no south exit returns false when checked for one
	@Test
	public void testSouthExitFalse() 
	{
		//room with no South exit, but everything else is true
		Room testRoom = new Room(true, true, true, true, false);
		
		//should be false
		assertFalse(testRoom.southExit());
	}

	//tests that a room with a south exit returns true when checked for one
	@Test
	public void testSouthExitTrue() 
	{
		//room with South exit
		Room testRoom = new Room(false, false, false, false, true);
		
		//should be true
		assertTrue(testRoom.southExit());
	}
	
	//Create a room with Coffee and a North Exit
	//check that only those attributes are set to true
	@Test
	public void testRoomCoNo() 
	{
		//create room with Coffee and North Exit
		Room testRoom = new Room(true, false, false, true, false);
		
		//make sure we created the expected room qualities (coffee and north exit)
		assertTrue(testRoom.hasCoffee() && !testRoom.hasCream() && !testRoom.hasSugar() && testRoom.northExit() && !testRoom.southExit());
	}

	//Create a room with Cream, a North Exit, and a South Exit
	//Ensure that only those attributes are set to true
	@Test
	public void testRoomCrNoSo() 
	{
		//create room with Cream, North, and South Exits
		Room testRoom = new Room(false, true, false, true, true);
		
		//make sure we created the expected room qualities (cream, north exit, and south exit)
		assertTrue(!testRoom.hasCoffee() && testRoom.hasCream() && !testRoom.hasSugar() && testRoom.northExit() && testRoom.southExit());
	}
	
	//Create empty room
	//ensure that all attributes are set to false
	@Test
	public void testRoomEmpty() 
	{
		//create room with nothing
		Room testRoom = new Room(false, false, false, false, false);
		
		//make sure we created the expected room qualities (empty)
		assertFalse(testRoom.hasCoffee() || testRoom.hasCream() || testRoom.hasSugar() || testRoom.northExit() || testRoom.southExit());
	}
	
	//Create FULL room
	//ensure that all attributes are set to true
	@Test
	public void testRoomFull() 
	{
		//create room with nothing
		Room testRoom = new Room(true, true, true, true, true);
		
		//make sure we created the expected room qualities (FULL)
		assertTrue(testRoom.hasCoffee() && testRoom.hasCream() && testRoom.hasSugar() && testRoom.northExit() && testRoom.southExit());
	}

	//make 2 empty rooms
	//ensure that their descriptions are not the same (should be random each time)
	@Test
	public void testGetDescription() 
	{
		//ensure we get random descriptions
		Room testRoom1, testRoom2;
		String des1, des2;
		
		//create 2 empty rooms
		testRoom1 = new Room(false, false, false, false, false);
		testRoom2 = new Room(false, false, false, false, false);
		
		//get room descriptions
		des1 = testRoom1.getDescription();
		des2 = testRoom2.getDescription();
		
		//make sure they are different
		assertFalse(des1.equals(des2));
	}

}
