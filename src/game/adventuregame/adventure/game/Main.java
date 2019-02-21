
package game.adventuregame.adventure.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import game.adventuregame.adventure.effects.Effect;
import game.adventuregame.adventure.effects.LookLocation;
import game.adventuregame.adventure.effects.Message;
import game.adventuregame.adventure.effects.Quit;
import game.adventuregame.model.Action;
import game.adventuregame.model.Item;
import game.adventuregame.model.Location;
import game.adventuregame.model.Player;
import game.adventuregame.model.World;

/**
 * This class is responsible for handing the user input and making the world for
 * the game.
 * 
 * @author Shankar Ammai
 * @see Runnable
 */
public class Main implements Runnable {
	private World world;

	/**
	 * This method creates Main object given the world.
	 * 
	 * @param world World for the game
	 */
	public Main(World world) {
		this.world = world;
	}

	/**
	 * This method is responsible for taking the user input and determines the right
	 * effect to execute and execute it.
	 */
	@Override
	public void run() {
		Player player = new Player(this.world.getStartingLocation());
		Effect startingeffect = new LookLocation();
		startingeffect.execute(player, world);
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print(">>>> ");
			try {
				String keyboardinput = keyboard.readLine();
				Effect effectToExecute = CommandParser.parsePlayerCommand(keyboardinput);
				effectToExecute.execute(player, this.world);
			} catch (IOException e) {
			} catch (QuitException e) {
				break;
			}
		}
	}

	/**
	 * This method is responsible for creating new world and running the actual
	 * game.
	 * 
	 * @param args Unused.
	 * @throws IOException When there is problem reading the input from the user.
	 */
	public static void main(String args[]) throws IOException {
		World world = new World();
		Location house = world.addLocation("house", "You are in a small village house.");
		Location street = world.addLocation("street", "You are on the main street of the village.");
		house.addNeighbour("out", street);
		street.addNeighbour("in", house);
		Item clock = world.addItem("clock", "It is an old grandfather clock.");
		house.addItem(clock);
		Item hammer = world.addItem("hammer", "It is a brand new hammer.");
		street.addItem(hammer);
		hammer.setPortable(true);
		Action useHammer = world.addAction("use hammer");
		useHammer.addRequiredItem(hammer);
		useHammer.addRequiredItem(clock);
		useHammer.addEffect(new Message("You hit the clock with the hammer."));
		useHammer.addEffect(new Message("The clock shatters into pieces."));
		useHammer.addEffect(new Message("THE END"));
		useHammer.addEffect(new Quit());
		world.setStartingLocation(house);
		world.onStart(new LookLocation());

		Main main = new Main(world);
		main.run();

	}
}
