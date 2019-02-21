package game.adventuregame.adventure.effects;

import game.adventuregame.model.Item;
import game.adventuregame.model.Player;
import game.adventuregame.model.World;

/**
 * This class models TakeItem Effect.
 * <p>
 * This class is responsible for player taking the item.
 * 
 * @author Shankar Ammai
 *
 */
public class TakeItem implements Effect {
	private String itemName;

	/**
	 * This method creates a new TakeItem Effect given the name of the item name.
	 * 
	 * @param itemName Name of the item.
	 */
	public TakeItem(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * This method executes the TakeItem Effect.
	 * <p>
	 * When this method is executed, if the item is there in the world ,player takes
	 * the item and removes the given item from the location. If the item is not
	 * there in the world or if the player is already carrying the given item then
	 * informative message is displayed.
	 * 
	 * @param player Player to play the game.
	 * @param world  The World where the game is to be played.
	 * 
	 * 
	 */
	@Override
	public void execute(Player player, World world) {
		Item item = world.getItem(this.itemName);
		if (item != null) {
			if (player.hasItem(item)) {
				System.out.println("Item Already There !!");
			} else {
				try {
					player.takeItem(item);
					player.getLocation().removeItem(item);
					System.out.println("You are now carrying " + this.itemName);
				} catch (IllegalArgumentException e) {
					System.out.println("You cannot take " + this.itemName);
				}
			}
		} else {
			System.out.println("Item Does not exist");
		}
	}
}