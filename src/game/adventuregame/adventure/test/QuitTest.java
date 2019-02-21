package game.adventuregame.adventure.test;

import org.junit.Test;

import game.adventuregame.adventure.effects.Effect;
import game.adventuregame.adventure.effects.Quit;
import game.adventuregame.adventure.game.QuitException;
import game.adventuregame.model.Location;
import game.adventuregame.model.Player;
import game.adventuregame.model.World;

public class QuitTest {

	@Test(expected=QuitException.class)
	public void testQuit() {
		World world=new World();
		Location house = new Location("house", "You are in a small village house.");
		Player player=new Player(house);
		Effect quiteffect= new Quit();
		quiteffect.execute(player, world);
	}

}
