package game.adventuregame.adventure.test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.adventuregame.adventure.effects.Effect;
import game.adventuregame.adventure.effects.GoDirection;
import game.adventuregame.model.Location;
import game.adventuregame.model.Player;
import game.adventuregame.model.World;

public class GoDirectionTest {
	private final World world = new World();
	private final Location house = world.addLocation("house", "You are in a small village house.");
	private final Player player = new Player(house);

	@Test
	public void testGoDirection() {
		Location street = world.addLocation("street", "You are on the main street of the village.");
		house.addNeighbour("out", street);
		street.addNeighbour("in", house);
		Effect goout= new GoDirection("out");
		goout.execute(player, world);
		assertEquals(player.getLocation(),street);
	}
	@Test
	public void testGoToNonExistingDirection() {
		Effect goout= new GoDirection("out");
		goout.execute(player, world);
		assertEquals(player.getLocation(),house);
	}
}
