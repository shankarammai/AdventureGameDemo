package game.adventuregame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import game.adventuregame.adventure.effects.Effect;

/**
 * Models Actions with given name. An action has its name, list of required
 * items to perform that action and certain effects of that action.
 * 
 * @see Item
 * @see Effect
 * @author Shankar Ammai
 *
 */
public class Action {
	private String name;
	private List<Item> requiredItems;
	private List<Effect> effects;

	/**
	 * Creates an Action given the name of the action.
	 * <p>
	 * A newly created item has no required items and has no effects after
	 * performing the action.
	 * 
	 * @param name Name of the action
	 */
	public Action(String name) {
		this.name = name;
		this.requiredItems = new ArrayList<>();
		this.effects = new ArrayList<>();
	}

	/**
	 * Returns the name of the action.
	 * 
	 * @return the name of the action.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Add given item as required item to perform the action.
	 * 
	 * @param item Item to add as required the item to perform the action.
	 */
	public void addRequiredItem(Item item) {
		this.requiredItems.add(item);
	}

	/**
	 * Returns if the player is allowed to perform the action.
	 * <p>
	 * A player can perform an action if the player can see all required items.
	 * 
	 * @param player Player to check if he can perform the action.
	 * @return {@code true} if the player can perform the task, {@code false} if the
	 *         player cannot perform the action.
	 */
	public boolean isAllowed(Player player) {
		boolean condition = true;
		for (Item itemrequired : this.requiredItems) {
			condition = condition && player.canSeeItem(itemrequired);
		}
		return condition;
	}

	/**
	 * Adds given effect to the action.
	 * 
	 * @param effect effect of the action.
	 */
	public void addEffect(Effect effect) {
		this.effects.add(effect);
	}

	/**
	 * Returns the list of effects of the action.
	 * 
	 * @return Effects of the action.
	 */
	public List<Effect> getEffects() {
		return Collections.unmodifiableList(this.effects);
	}
}
