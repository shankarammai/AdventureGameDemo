package game.adventuregame.adventure.effects;

import game.adventuregame.model.Item;
import game.adventuregame.model.Player;
import game.adventuregame.model.World;

/**
 * This class models LookItem Effect.
 * <p>
 * This class is responsible for displaying the information about a particular
 * item.
 * 
 * @author Shankar Ammai
 *
 */
public class LookItem implements Effect {
	private String itemName;

	/**
	 * Creates a new LookItem effect given the name of the item.
	 * 
	 * @param itemname Name of the item.
	 */
	public LookItem(String itemname) {
		this.itemName = itemname;
	}

	/**
	 * This method executes the LookItem Effect.
	 * 
	 * <p>
	 * When Executed this method displays the description of the item if the item is
	 * there and player can see the item. Otherwise informative message is
	 * displayed.
	 * 
	 * @param player Player to play the game.
	 * @param world  The World where the game is to be played.
	 */
	@Override
	public void execute(Player player, World world) {
		Item item = world.getItem(this.itemName);
		if (item != null) {
			if (player.canSeeItem(item)) {
				System.out.println(item.getDescription());
			}
		} else {
			System.out.println("There is no " + this.itemName + " here.");
		}

	}

}
