package game.adventuregame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Models Player for the game.
 * <p>
 * A player has its location. A player can have items in his inventory. A player
 * will be able to take and drop items. A player will be able to perform
 * different tasks.
 * 
 * @see Location
 * @see Item
 * @author Shankar Ammai
 * 
 *
 */
public class Player {
	// TODO: declare fields

	private Location location;
	private List<Item> playerItems;

	/**
	 * Creates a player given a location for the player. A newly created player's
	 * inventory is empty.
	 * 
	 * @param location Location of the player.
	 */
	public Player(Location location) {
		this.location = location;
		this.playerItems = new ArrayList<>();
	}

	/**
	 * Returns the location of the player.
	 * 
	 * @return The Location of the player.
	 */
	public Location getLocation() {
		return this.location;
	}

	/**
	 * Sets the location of the player to the given location.
	 * 
	 * @param location New location of the player.
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Player takes the item.
	 * <p>
	 * A player can take an item if the item is portable and the item is in the
	 * player's location.
	 * 
	 * @param item Item to take.
	 * @throws IllegalArgumentException If the item is not portable or the item is
	 *                                  not in player's location.
	 */
	public void takeItem(Item item) {
		if (item.isPortable() && item.getLocation() == this.getLocation()) {
			this.playerItems.add(item);
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Returns if the player has an item given.
	 * 
	 * @param item Item to check the if player has it.
	 * @return If the player has the item. Returns {@code true} if the player has
	 *         the item, {@code false} if player does not have the item. {@code }
	 */
	public boolean hasItem(Item item) {
		return this.getInventory().contains(item);

	}

	/**
	 * Returns if the player can see an item.
	 * <p>
	 * A player can see an item if the item is in the player's location or if the
	 * item is in player's inventory.
	 * 
	 * @param item Item to check if the player can see it.
	 * @return {@code true} if the player can see it, {@code false} if the player
	 *         can not see it.
	 */
	public boolean canSeeItem(Item item) {
		return this.hasItem(item) || item.getLocation() == this.getLocation();
	}

	/**
	 * Drops an item from player's inventory
	 * <p>
	 * A player can only drop an item if the item is in player's inventory. After
	 * dropping the item, Item's location is set to current location of the player.
	 * 
	 * @param item Item to drop from player's inventory.
	 * @throws IllegalArgumentException if the player does not have the item.
	 */
	public void dropItem(Item item) {
		if (this.hasItem(item)) {
			this.playerItems.remove(item);
			this.getLocation().addItem(item);
		} else {
			throw new IllegalArgumentException();
		}

	}

	/**
	 * Returns the list of items that the player has.
	 * 
	 * @return The list of the items that the player has in his inventory.
	 */
	public List<Item> getInventory() {
		return Collections.unmodifiableList(this.playerItems);
	}
}
