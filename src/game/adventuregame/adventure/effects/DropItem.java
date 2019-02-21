package game.adventuregame.adventure.effects;

import game.adventuregame.model.Item;
import game.adventuregame.model.Player;
import game.adventuregame.model.World;

/**
 * This class models a DropItem Effect.
 * <p>
 * When Executed player will drop item if allowed.
 * 
 * @author Shankar Ammai
 *
 */
public class DropItem implements Effect {
	private String itemName;

	/**
	 * This method creates a new DropItem effect given the name of the item.
	 * 
	 * @param itemname Name of the item to drop.
	 */
	public DropItem(String itemname) {
		this.itemName = itemname;
	}

	/**
	 * This method executes the DropItem effect.
	 * <p>
	 * Given item is dropped if the item is in the world and if the player is
	 * carrying the given item. Otherwise an informative message is displayed.
	 * 
	 * @param player Player to play the game.
	 * @param world  The World where the game is to be played.
	 * @throws IllegalArgumentException when the player is not carrying the item or
	 *                                  item is not in the world.
	 */
	@Override
	public void execute(Player player, World world) {
		Item item = world.getItem(this.itemName);
		try {
			player.dropItem(item);
			System.out.println(" You dropped " + this.itemName);
		} catch (IllegalArgumentException e) {
			System.out.println("You aren't carrying " + this.itemName);
		}
	}

}
