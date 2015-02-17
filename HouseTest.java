package com.laboon;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class HouseTest {

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

	//test that a negative numbered room returns the expected error message
	@Test
	public void testGetCurrentRoomInfoNegative() {
		//single roomed house
		House testHouse = new House(1);
		String testInfo;
		
		//room 0 assumed, so decrement
		testHouse.moveSouth();
		
		//check description
		testInfo = testHouse.getCurrentRoomInfo();
		assertEquals(testInfo, "You are in a magical land!  But you are returned to the beginning!");
	}

	//test that a room numbered higher than total number of rooms returns the expected error message
	@Test
	public void testGetCurrentRoomInfoPositive() {
		//single roomed house
		House testHouse = new House(1);
		String testInfo;
		
		//room 0 assumed, so increment
		testHouse.moveNorth();
		
		//check description
		testInfo = testHouse.getCurrentRoomInfo();
		assertEquals(testInfo, "You are in a magical land!  But you are returned to the beginning!");
	}
	
	//test that a valid room returns a description (not an error)
	@Test
	public void testGetCurrentRoomInfoDefault() {
		//single roomed house
		House testHouse = new House(1);
		String testInfo;
				
		//check description
		testInfo = testHouse.getCurrentRoomInfo();
		assertFalse(testInfo.equals("You are in a magical land!  But you are returned to the beginning!"));
	}
	
	//ensure that moving north increments room number
	//do this by forcing the position to a number higher than number of rooms
	//expect error in incremented room, no error in original room
	@Test
	public void testMoveNorth() {
		//2-roomed house
		House testHouse = new House(2);
		String testInfo1, testInfo2, testInfo3, testInfo4;
				
		//check description
		testInfo1 = testHouse.getCurrentRoomInfo();
		
		//move north, and check description again
		testHouse.moveNorth();
		testInfo2 = testHouse.getCurrentRoomInfo();
		
		//again...expect error here
		testHouse.moveNorth();
		testInfo3 = testHouse.getCurrentRoomInfo();
		
		//we should be back at the beginning
		testInfo4 = testHouse.getCurrentRoomInfo();
		
		//make sure all infos are different (except 1 and 4)
		//ensure that final info is expected error
		//ensure that room was set back to original after error
		assertTrue(testInfo1.equals(testInfo4) && !testInfo1.equals(testInfo2) && !testInfo1.equals(testInfo3) && !testInfo2.equals(testInfo3) && testInfo3.equals("You are in a magical land!  But you are returned to the beginning!"));
	}

	//ensure that moving south decrements room number
	//do this by forcing the position to a negative number
	//expect error in decremented room, no error in original room
	@Test
	public void testMoveSouth() {
		//2-roomed house so we know we didn't move north
		House testHouse = new House(1);
		String testInfo1, testInfo2, testInfo3;
				
		//check description, expected room 0
		testInfo1 = testHouse.getCurrentRoomInfo();
		
		//move south, and check description again (should be error)
		testHouse.moveNorth();
		testInfo2 = testHouse.getCurrentRoomInfo();
		
		//we should be back at the beginning
		testInfo3 = testHouse.getCurrentRoomInfo();
		
		//ensure that info 2 is expected error
		//ensure that room was set back to original after error
		assertTrue(testInfo1.equals(testInfo3) && !testInfo1.equals(testInfo2) && testInfo2.equals("You are in a magical land!  But you are returned to the beginning!"));
	}
	
	//Create room with no items
	//player looks in the room and should pick up no items
	@Test
	public void testLookNothing() {
		
		//create player with all items, but coffee
		Player testPlayer = new Player(false, false, false);

		//create room with nothing
		Room testRoom = new Room(false, false, false, false, false);
		
		//make house arbitary number of rooms
		House testHouse = new House(6);
				
		boolean beforeLook, afterLook;
		
		//player should not have all items before looking
		beforeLook = testPlayer.hasAllItems();
		
		//look
		testHouse.look(testPlayer, testRoom);
		
		//player should not have all items after looking
		afterLook = testPlayer.hasAllItems();
		
		//make sure not true before and true after
		assertFalse(beforeLook || afterLook);
	}
	
	//Create room with with coffee
	//player looks in the room and should pick up coffee
	@Test
	public void testLookCoffee() {
		
		//create player with all items, but coffee
		Player testPlayer = new Player(true, true, false);

		//create room with coffee (must be in array for House object)
		Room testRoom = new Room(true, false, false, false, false);
		
		//make house with single room declared
		House testHouse = new House(8);
				
		boolean beforeLook, afterLook;
		
		//player should not have all items before looking
		beforeLook = testPlayer.hasAllItems();
		
		//look
		testHouse.look(testPlayer, testRoom);
		
		//player should have all items after looking
		afterLook = testPlayer.hasAllItems();
		
		//make sure not true before and true after
		assertTrue(!beforeLook && afterLook);
	}

	//Create room with with all items
	//player looks in the room and should pick up everything
	@Test
	public void testLookAllItems() {
		
		//create player with no items
		Player testPlayer = new Player(false, false, false);

		//create room with all items
		Room testRoom = new Room(true, true, true, false, false);
		
		//make house with single room declared
		House testHouse = new House(6);
				
		Boolean beforeLook, afterLook;
		
		//player should not have all items before looking
		beforeLook = testPlayer.hasAllItems();
		
		//look
		testHouse.look(testPlayer, testRoom);
		
		//player should have all items after looking
		afterLook = testPlayer.hasAllItems();
		
		//make sure not true before and true after
		assertTrue(!beforeLook && afterLook);
	}
	
	//ensure that correct number of rooms are generated
	@Test
	public void testGenerateRooms() {
		
		//test house with arbitrary number of rooms
		House testHouse = new House(10);
		
		//we will make a room with 15 rooms
		int testNum = 15;
		
		//generate 15 rooms
		Room[] rooms = testHouse.generateRooms(testNum);

		//make sure we didn't get a null list
		assertNotNull(rooms);
		
		//ensure that correct number of rooms were created
		assertEquals(rooms.length, testNum);
	}

}
