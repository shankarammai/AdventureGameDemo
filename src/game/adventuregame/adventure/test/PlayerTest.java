package game.adventuregame.adventure.test;

import org.junit.Test;

import game.adventuregame.model.Item;
import game.adventuregame.model.Location;
import game.adventuregame.model.Player;

import static org.junit.Assert.*;

import java.util.Collections;

public class PlayerTest {
	private final Location house = new Location("house", "You are in a small village house.");
	private final Location street = new Location("street", "You are on the main street of the village.");
	private final Player player = new Player(street);
	
	@Test
	public void testGetLocation() {
		assertSame(street, player.getLocation());
	}
	
	@Test
	public void testSetLocation() {
		player.setLocation(house);
		assertSame(house, player.getLocation());
	}
	
	@Test
	public void testInventory() {
		assertEquals(Collections.emptyList(), player.getInventory());
	}
	
	@Test
	public void testTakeItem() {
		Item hammer=new Item("hammer","This is a steel hammer");
		hammer.setPortable(true);
		hammer.setLocation(street);
		player.takeItem(hammer);
		assertTrue(player.hasItem(hammer));
		
	}
	@Test(expected=IllegalArgumentException.class)
	public void testTakeItemNotPortable(){
		Item clock = new Item("clock", "It is an old grandfather clock.");
		player.takeItem(clock);
	}
	@Test
	public void testHasItem() {
		Item hammer=new Item("hammer","This is a steel hammer");
		hammer.setPortable(true);
		hammer.setLocation(street);
		player.takeItem(hammer);
		assertTrue(player.hasItem(hammer));
		
	}
	@Test 
	public void testHasNotItem() {
		Item hammer=new Item("hammer","This is a steel hammer");
		hammer.setLocation(street);
		assertFalse(player.hasItem(hammer));
	}
	@Test
	public void testCanSeeItem() {
		Item hammer=new Item("hammer","This is a steel hammer");
		assertFalse(player.canSeeItem(hammer));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testDropItem() {
		Item hammer=new Item("hammer","This is a steel hammer");
		player.dropItem(hammer);
	}
	@Test 
	public void testGetInvetory() {
		Item hammer=new Item("hammer","This is a steel hammer");
		hammer.setLocation(street);
		hammer.setPortable(true);
		player.takeItem(hammer);
		assertTrue(player.getInventory().contains(hammer));
	}
}
