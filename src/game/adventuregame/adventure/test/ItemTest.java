package game.adventuregame.adventure.test;

import org.junit.Test;

import game.adventuregame.model.Item;
import game.adventuregame.model.Location;

import static org.junit.Assert.*;

public class ItemTest {
	private final Item clock = new Item("clock", "It is an old grandfather clock.");

	@Test
	public void testGetName() {
		assertEquals("clock", clock.getName());
	}

	@Test
	public void testGetDescription() {
		assertEquals("It is an old grandfather clock.", clock.getDescription());
	}

	@Test
	public void testSetPortable() {
		clock.setPortable(true);
		assertTrue(clock.isPortable());
	}

	@Test
	public void testGetAndSetLocation() {
		Location house = new Location("house", "You are in a small village house.");
		clock.setLocation(house);
		assertSame(house, clock.getLocation());
	}
	@Test
	public void testIsPortable() {
		assertFalse(clock.isPortable());
	}
}
