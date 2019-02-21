package game.adventuregame.adventure.effects;

import game.adventuregame.model.Player;
import game.adventuregame.model.World;

/**
 * This interface performs the correct effect for all type of effects.
 * 
 * @author Shankar Ammai
 *
 */
public interface Effect {
	public void execute(Player player, World world);
}
