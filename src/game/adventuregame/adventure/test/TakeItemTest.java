package game.adventuregame.adventure.test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.adventuregame.adventure.effects.Effect;
import game.adventuregame.adventure.effects.TakeItem;
import game.adventuregame.model.Item;
import game.adventuregame.model.Location;
import game.adventuregame.model.Player;
import game.adventuregame.model.World;

public class TakeItemTest {

	private final World world = new World();
	private final Item hammer = world.addItem("hammer", "It is a brand new hammer.");
	private final Location house = world.addLocation("house", "You are in a small village house.");
	private final Player player = new Player(house);

	@Test
	public void testTakeItemHammer() {
		Effect take= new TakeItem("hammer");
		house.addItem(hammer);
		hammer.setLocation(house);
		hammer.setPortable(true);
		take.execute(player, world);
		assertTrue(player.hasItem(hammer));
	}

	@Test
	public void testTakeItemNotPortable() {
		Effect take = new TakeItem("hammer");
		house.addItem(hammer);
		hammer.setLocation(house);
		hammer.setPortable(false);
		take.execute(player, world);
		assertFalse(player.hasItem(hammer));
	}

	@Test
	public void testTakeItemInAnotherLocation() {
		Effect take = new TakeItem("hammer");
		house.addItem(hammer);
		Location street = world.addLocation("Street", "This is a street.");
		hammer.setLocation(street);
		hammer.setPortable(true);
		take.execute(player, world);
		assertFalse(player.hasItem(hammer));
	}

}
