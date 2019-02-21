package game.adventuregame.adventure.test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.adventuregame.adventure.effects.DropItem;
import game.adventuregame.adventure.effects.Effect;
import game.adventuregame.model.Item;
import game.adventuregame.model.Location;
import game.adventuregame.model.Player;
import game.adventuregame.model.World;

public class DropItemTest {
	private final World world = new World();
	private final Item hammer = world.addItem("hammer", "It is a brand new hammer.");
	private final Location house = world.addLocation("house", "You are in a small village house.");
	private final Player player = new Player(house);

	@Test
	public void testDropItem() {
		Effect drop = new DropItem("hammer");
		hammer.setLocation(house);
		hammer.setPortable(true);
		player.takeItem(hammer);
		drop.execute(player, world);
		assertFalse(player.hasItem(hammer));
		assertTrue(house.getItems().contains(hammer));
		assertEquals(hammer.getLocation(), house);

	}

}
