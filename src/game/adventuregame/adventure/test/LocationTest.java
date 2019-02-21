package game.adventuregame.adventure.test;

import org.junit.Test;

import game.adventuregame.model.Item;
import game.adventuregame.model.Location;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LocationTest {
	private final Location house = new Location("house", "You are in a small village house.");
	
	@Test
	public void testGetName() {
		assertEquals("house", house.getName());
	}
	
	@Test
	public void testGetDescription() {
		assertEquals("You are in a small village house.", house.getDescription());
	}
	
	@Test
	public void noItems() {
		assertEquals(Collections.emptyList(), house.getItems());
	}
	
	@Test
	public void testAddNeighbour() {
		house.addNeighbour("right",new Location("School","This is a primary school"));
		house.addNeighbour("left",new Location("Tower","This is a tower"));
		List<String>alldirections=new ArrayList<>(Arrays.asList("right","left"));
		assertTrue(alldirections.containsAll(house.getAllDirections())
				&& house.getAllDirections().containsAll(alldirections));
		
	}
	@Test //this method tests addNeighbour and getAllDirections method
	public void testGetAllDirections() {
		Location mall=new Location("Mall","This is a shopping mall");
		Location ground=new Location("Ground","This is a Ground ");
		house.addNeighbour("right",mall);
		house.addNeighbour("left",ground);
		List<Location>allNeighbours=new ArrayList<>(Arrays.asList(mall,ground));
		assertTrue(allNeighbours.contains(mall)&& allNeighbours.contains(ground));
	}
	@Test // this method tests getNeighbour
	public void testGetNeighbour() {
		Location ground=new Location("Ground","This is a Ground ");
		house.addNeighbour("front",ground);
		assertEquals(ground,house.getNeighbour("front"));
		
	}
	@Test // this method tests getNeighbour if there is no neighbour
	public void testNoNeighbour() {
		Location ground=new Location("Ground","This is a Ground ");
		assertNull(ground.getNeighbour("front"));
	}
	@Test //this method tests hasItem and addItem method
	public void testHasItem() {
		Item television=new Item("Television","This is 43 inches Television");
		house.addItem(television);
		assertTrue(house.hasItem(television));
	}
	@Test //this method tests removeItem method 
	public void testRemoveItem() {
		Item television=new Item("Television","This is 43 inches Television");
		house.addItem(television);
		house.removeItem(television);
		assertTrue(house.getItems().isEmpty());
	} 
	@Test //this method tests addItem method 
	public void testAddItem() {
		Item television=new Item("Television","This is 43 inches Television");
		house.addItem(television);
		assertTrue(house.getItems().contains(television));
	} 
	
}
