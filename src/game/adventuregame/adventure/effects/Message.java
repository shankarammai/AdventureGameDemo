package game.adventuregame.adventure.effects;

import game.adventuregame.model.Player;
import game.adventuregame.model.World;

/**
 * This class models Message effect.
 * <p>
 * This class is responsible showing messages to the player.
 * 
 * @author Shankar Ammai
 *
 */
public class Message implements Effect {
	private String message;

	/**
	 * This method creates a Message Effect given the message.
	 * 
	 * @param message Message to be displayed.
	 */
	public Message(String message) {
		this.message = message;
	}

	/**
	 * This method executes the Message Effect.
	 * <p>
	 * Message is displayed after the effect is executed.
	 * 
	 * @param player Player to play the game.
	 * @param world  The World where the game is to be played.
	 */
	@Override
	public void execute(Player player, World world) {
		System.out.println(this.message);
	}

}
