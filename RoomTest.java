package com.laboon;
import static org.junit.Assert.*;

import org.junit.Test;


public class RoomTest 
{

	@Test
	public void testHasItemFalse() 
	{
		Room testRoom;
		
		//empty room
		testRoom = new Room(false, false, false, false, false);
		
		//should return false
		assertFalse(testRoom.hasItem());
	}

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

	@Test
	public void testHasSugarFalse() 
	{
		//room with no sugar, but everything else is true
		Room testRoom = new Room(true, true, false, true, true);
		
		//should be false
		assertFalse(testRoom.hasSugar());
	}

	@Test
	public void testHasSugarTrue() 
	{
		//room with sugar
		Room testRoom = new Room(false, false, true, false, false);
		
		//should be true
		assertTrue(testRoom.hasSugar());
	}

	@Test
	public void testHasCreamFalse() 
	{
		//room with no cream, but everything else is true
		Room testRoom = new Room(true, false, true, true, true);
		
		//should be false
		assertFalse(testRoom.hasCream());
	}

	@Test
	public void testHasCreamTrue() 
	{
		//room with cream
		Room testRoom = new Room(false, true, false, false, false);
		
		//should be true
		assertTrue(testRoom.hasCream());
	}
	
	@Test
	public void testHasCoffeeFalse() 
	{
		//room with no coffee, but everything else is true
		Room testRoom = new Room(false, true, true, true, true);
		
		//should be false
		assertFalse(testRoom.hasCoffee());
	}
	
	@Test
	public void testHasCoffeeTrue() 
	{
		//room with sugar
		Room testRoom = new Room(true, false, false, false, false);
		
		//should be true
		assertTrue(testRoom.hasCoffee());
	}
	
	@Test
	public void testNorthExitFalse() 
	{
		//room with no North exit, but everything else is true
		Room testRoom = new Room(true, true, true, true, false);
		
		//should be false
		assertFalse(testRoom.northExit());
	}
	
	@Test
	public void testNorthExitTrue() 
	{
		//room with North exit
		Room testRoom = new Room(false, false, false, true, false);
		
		//should be true
		assertTrue(testRoom.northExit());
	}
	
	@Test
	public void testSouthExitFalse() 
	{
		//room with no South exit, but everything else is true
		Room testRoom = new Room(true, true, true, true, false);
		
		//should be false
		assertFalse(testRoom.southExit());
	}

	@Test
	public void testSouthExitTrue() 
	{
		//room with South exit
		Room testRoom = new Room(false, false, false, false, true);
		
		//should be true
		assertTrue(testRoom.southExit());
	}
	
	@Test
	public void testRoomCoNo() 
	{
		//create room with Coffee and North Exit
		Room testRoom = new Room(true, false, false, true, false);
		
		//make sure we created the expected room qualities (coffee and north exit)
		assertTrue(testRoom.hasCoffee() && !testRoom.hasCream() && !testRoom.hasSugar() && testRoom.northExit() && !testRoom.southExit());
	}

	@Test
	public void testRoomCrNoSo() 
	{
		//create room with Cream, North, and South Exits
		Room testRoom = new Room(false, true, false, true, true);
		
		//make sure we created the expected room qualities (cream, north exit, and south exit)
		assertTrue(!testRoom.hasCoffee() && testRoom.hasCream() && !testRoom.hasSugar() && testRoom.northExit() && testRoom.southExit());
	}
	
	@Test
	public void testRoomEmpty() 
	{
		//create room with nothing
		Room testRoom = new Room(false, false, false, false, false);
		
		//make sure we created the expected room qualities (empty)
		assertFalse(testRoom.hasCoffee() || testRoom.hasCream() || testRoom.hasSugar() || testRoom.northExit() || testRoom.southExit());
	}
	
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
		assertFalse(des1.equals(des2));
	}

}
