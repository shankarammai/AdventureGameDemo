package game.adventuregame.adventure.game;

import game.adventuregame.adventure.effects.Quit;

/**
 * This exception is raised whenever user types the command "quit".
 * 
 * @see Quit
 * @author Shankar Ammai
 *
 */
public class QuitException extends RuntimeException {
	/**
	 * Raises the QuitException when the user types the command quit. User quits the
	 * game when executed.
	 */
	public QuitException() {

	}
}
