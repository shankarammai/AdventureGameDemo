package game.adventuregame.adventure.test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.adventuregame.adventure.effects.DoAction;
import game.adventuregame.adventure.effects.Effect;
import game.adventuregame.adventure.effects.TakeItem;
import game.adventuregame.model.Action;
import game.adventuregame.model.Item;
import game.adventuregame.model.Location;
import game.adventuregame.model.Player;
import game.adventuregame.model.World;

public class DoActionTest {
	private final World world = new World();

	@Test
	public void testDoAction() {
		Location house = world.addLocation("house", "You are in a small village house.");
		Location street = world.addLocation("street", "You are on the main street of the village.");
		house.addNeighbour("out", street);
		Item clock = world.addItem("clock", "It is an old grandfather clock.");
		house.addItem(clock);
		clock.setPortable(true);
		Player player=new Player(house);
		Action removeclock = world.addAction("remove clock");
		removeclock.addRequiredItem(clock);
		removeclock.addEffect(new TakeItem("clock"));
		world.setStartingLocation(house);
		Effect doAction=new DoAction("remove clock");
		doAction.execute(player, world);
		assertTrue(player.hasItem(clock));
	}

}
