package game.adventuregame.adventure.effects;

import game.adventuregame.model.Action;
import game.adventuregame.model.Player;
import game.adventuregame.model.World;

/**
 * This class represents DoAction effect.
 * <p>
 * If a player does something than it is the responsiblity of this class to do
 * it.
 * 
 * @author Shankar Ammai
 *
 */
public class DoAction implements Effect {
	private String actionName;

	/**
	 * Creates a new DoAction effect.
	 * 
	 * @param actionName Name of the action to be performed.
	 */
	public DoAction(String actionName) {
		this.actionName = actionName;
	}

	/**
	 * This method performs the action.
	 * <p>
	 * To perform the action, this action should be present in the world and the
	 * action should be allowed to be performed by the player. If the action is not
	 * in the world or player is not allowed to do the action then an informative
	 * message is displayed. Otherwise all the effects of the action is executed.
	 * 
	 * 
	 * @param player Player to play the game.
	 * @param world  The World where the game is to be played.
	 * @author Shankar Ammai
	 */
	@Override
	public void execute(Player player, World world) {
		Action action = world.getAction(this.actionName);

		if (action != null && action.isAllowed(player)) {
			for (Effect effect : action.getEffects()) {
				effect.execute(player, world);
			}
		} else if (action != null) {
			System.out.println("You cannot " + this.actionName + " right now");
		} else {
			System.out.println("I don't know how to " + this.actionName);
		}

	}

}
