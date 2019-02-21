package game.adventuregame.adventure.effects;

import game.adventuregame.adventure.game.QuitException;
import game.adventuregame.model.Player;
import game.adventuregame.model.World;

/**
 * This Exception is raised when the user types the command "quit".
 * 
 * @see QuitException
 * @author Shankar Ammai
 *
 */
public class Quit implements Effect {
	/**
	 * This method executes the QuitException Effect.
	 * <p>
	 * User quits the game when the effect is executed.
	 * 
	 * @param player Player to play the game.
	 * @param world  The World where the game is to be played.
	 * @throws QuitException when user types quit command.
	 */
	@Override
	public void execute(Player player, World world) throws RuntimeException {
		throw new QuitException();
	}

}
