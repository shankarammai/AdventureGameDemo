package game.adventuregame.adventure.game;

import game.adventuregame.adventure.effects.DoAction;
import game.adventuregame.adventure.effects.DropItem;
import game.adventuregame.adventure.effects.Effect;
import game.adventuregame.adventure.effects.GoDirection;
import game.adventuregame.adventure.effects.LookItem;
import game.adventuregame.adventure.effects.LookLocation;
import game.adventuregame.adventure.effects.Message;
import game.adventuregame.adventure.effects.Quit;
import game.adventuregame.adventure.effects.ShowInventory;
import game.adventuregame.adventure.effects.TakeItem;

/**
 * This class represents CommandParser.
 * <p>
 * This class is responsible for parsing the command entered by the user.
 * 
 * @author Shankar Ammai
 *
 */
public class CommandParser {
	public static final String HELP_MESSAGE = "Commands:\n" + "    look              Look around you.\n"
			+ "    look [item]       Look at an item.\n" + "    inventory         Look at your inventory.\n"
			+ "    go [direction]    Walk in a direction.\n" + "    take [item]       Take an item.\n"
			+ "    drop [item]       Drop an item.\n" + "    help              Show this help message.\n"
			+ "    quit              Exit the game.";

	/**
	 * This method parses the command given by the user and then returns the correct
	 * effect for that particular command.
	 * 
	 * @param command Command to parse.
	 * @return Effect to execute.
	 */
	public static Effect parsePlayerCommand(String command) {
		command = command.toLowerCase();
		if ("look".equals(command)) {
			return new LookLocation();
		} else if (command.startsWith("look ")) {
			return new LookItem(command.substring(5));
		} else if ("inventory".equals(command)) {
			return new ShowInventory();
		} else if (command.startsWith("go ")) {
			return new GoDirection(command.substring(3));
		} else if (command.startsWith("take ")) {
			return new TakeItem(command.substring(5));
		} else if (command.startsWith("drop ")) {
			return new DropItem(command.substring(5));
		} else if ("help".equals(command)) {
			return new Message(HELP_MESSAGE);
		} else if ("quit".equals(command)) {
			return new Quit();
		} else {
			return new DoAction(command);
		}
	}
}
