package game.adventuregame.adventure.test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.adventuregame.adventure.effects.Effect;
import game.adventuregame.adventure.effects.Message;
import game.adventuregame.model.Item;
import game.adventuregame.model.Location;
import game.adventuregame.model.World;

public class WorldTest {
	private final World world = new World();

	@Test
	public void testGestStartingLocation() {
		assertNull(world.getStartingLocation());

	}

	@Test
	public void testSetStartingLocation() {
		Location house = new Location("house", "You are in a small village house.");
		world.setStartingLocation(house);
		assertEquals(house, world.getStartingLocation());
	}

	@Test
	public void testAddItem() {
		Item hammer = world.addItem("hammer", "It is a brand new hammer.");
		assertEquals("hammer", hammer.getName());
	}

	@Test
	public void testGetItem() {
		Item hammer = world.addItem("hammer", "It is a brand new hammer.");
		assertSame(hammer, world.getItem("hammer"));
	}

	@Test
	public void testAddLocation() {
		Location house = world.addLocation("house", "You are in a small village house.");
		assertEquals("house", house.getName());
	}

	@Test
	public void testGetLocation() {
		Location house = world.addLocation("house", "You are in a small village house.");
		assertSame(house, world.getLocation("house"));
	}

	@Test
	public void testAddAction() {
		world.addAction("useItem");
		assertEquals(world.getAction("useItem").getName(), "useItem");
	}

	@Test
	public void testGetAction() {
		world.addAction("Throw");
		assertEquals(world.getAction("Throw").getName(), "Throw");
	}

	@Test
	public void testOnStart() {
		Effect effect = new Message("You hit the clock with the hammer.");
		world.onStart(effect);
		assertTrue(world.getStartEffects().contains(effect));
	}

	@Test
	public void TestGetStarteffects() {
		Effect effect1 = new Message("You hit the clock with the hammer.");
		Effect effect2 = new Message("The clock shatters into pieces.");
		world.onStart(effect1);
		world.onStart(effect2);
		assertTrue(world.getStartEffects().contains(effect1) 
				&& world.getStartEffects().contains(effect2));

	}
}
