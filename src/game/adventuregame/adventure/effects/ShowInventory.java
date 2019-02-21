package game.adventuregame.adventure.effects;

import game.adventuregame.model.Item;
import game.adventuregame.model.Player;
import game.adventuregame.model.World;

/**
 * This class models ShowInventory Effect.
 * <p>
 * This class is responsible for showing player inventory.
 * 
 * @author Shankar Ammai
 *
 */
public class ShowInventory implements Effect {
	/**
	 * This method executes ShowInventory Effect.
	 * <p>
	 * When executed it shows all the items that the player has.
	 * 
	 * @param player Player to play the game.
	 * @param world  The World where the game is to be played.
	 */
	@Override
	public void execute(Player player, World world) {
		if (player.getInventory().isEmpty()) {
			System.out.println("You are not carrying anything.");
		} else {
			System.out.print("You are carrying: ");
			for (Item inventoryItems : player.getInventory()) {
				System.out.println(inventoryItems.getName());
			}
		}
	}
}
