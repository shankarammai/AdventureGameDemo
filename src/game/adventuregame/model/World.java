package game.adventuregame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.adventuregame.adventure.effects.Effect;

/**
 * Models world for the game.
 * <p>
 * A world has many items in the world. A world has multiple locations. A world
 * has list of actions that a player can perform. A world has many effects. A
 * game has starting location to start the game.
 * 
 * @see Item
 * @see Location
 * @see Player
 * @see Action
 * @author Shankar Ammai
 *
 */
public class World {
	private Map<String, Item> allItemsInTheWorld;
	private Map<String, Location> allLocations;
	private Map<String, Action> allActions;
	private List<Effect> allEffects;
	private Location startingLocation;

	/**
	 * Creates a world for the game.
	 * <p>
	 * A newly created world does not have starting location. There are no items, no
	 * locations, no actions and no effects in newly created world.
	 */
	public World() {
		this.startingLocation = null;
		this.allItemsInTheWorld = new HashMap<>();
		this.allLocations = new HashMap<>();
		this.allActions = new HashMap<>();
		this.allEffects = new ArrayList<>();

	}

	/**
	 * Returns the starting location of the world.
	 * 
	 * @return World starting location.
	 */
	public Location getStartingLocation() {
		return this.startingLocation;
	}

	/**
	 * Sets the world starting location to the given location.
	 * 
	 * @param location Location to set world starting location to.
	 */
	public void setStartingLocation(Location location) {
		this.startingLocation = location;
	}

	/**
	 * Returns the item given the name of the item.
	 * <p>
	 * Returns item if the item is in the world else returns {@code null}.
	 * 
	 * @param name Name of the item.
	 * @return item from the name of the item.
	 */
	public Item getItem(String name) {
		Item item = null;
		if (this.allItemsInTheWorld.containsKey(name)) {
			item = this.allItemsInTheWorld.get(name);
			return item;
		}
		return item;
	}

	/**
	 * Returns new item given name and description of the item.
	 * <p>
	 * Creates and add new item to the world if the item is not there.
	 * 
	 * @param name        name of the item.
	 * @param description description of the item.
	 * @throws IllegalArgumentException if the item with same name is already there.
	 * @return new item after creating and adding item to the world.
	 */
	public Item addItem(String name, String description) {
		if (this.allItemsInTheWorld.containsKey(name)) {
			throw new IllegalArgumentException();
		} else {
			Item newitem = new Item(name, description);
			this.allItemsInTheWorld.put(name, newitem);

			return newitem;
		}
	}

	/**
	 * Returns the location given the name of the location if the location is there
	 * in the world.
	 * 
	 * @param name Name of the item.
	 * @return the location if the location is there.
	 */
	public Location getLocation(String name) {
		Location location = null;
		if (this.allLocations.containsKey(name)) {
			location = this.allLocations.get(name);
		}
		return location;
	}

	/**
	 * Returns the location, given the name and the description.
	 * <p>
	 * Creates and add new location to the world if the location is not there.
	 * 
	 * @param name        Name of the location
	 * @param description Description of the location.
	 * @return location after creating new location and adding to the world.
	 * @throws IllegalArgumentException if the name of the location is already
	 *                                  there.
	 */
	public Location addLocation(String name, String description) {
		if (this.allLocations.containsKey(name)) {
			throw new IllegalArgumentException();
		} else {
			Location newlocation = new Location(name, description);
			this.allLocations.put(name, newlocation);
			return newlocation;
		}
	}

	/**
	 * Returns action with the given name.
	 * <p>
	 * Returns {@code null} if the action is not there.
	 * 
	 * @param name Name of the action
	 * @return action corresponding with the given name of the action.
	 */
	public Action getAction(String name) {
		Action action = null;
		if (this.allActions.containsKey(name)) {
			action = this.allActions.get(name);
		}
		return action;
	}

	public Action addAction(String name) {
		if (this.allActions.containsKey(name)) {
			throw new IllegalArgumentException();
		} else {
			Action newaction = new Action(name);
			this.allActions.put(name, newaction);
			return newaction;
		}
	}

	/**
	 * Adds given effect to the list of effects to start on.
	 * 
	 * @param effect Effect to add to the on start.
	 */
	public void onStart(Effect effect) {
		this.allEffects.add(effect);
	}

	/**
	 * Returns the list of all effects to start.
	 * 
	 * @return list of all effects
	 */
	public List<Effect> getStartEffects() {
		// TODO: implement getStartEffects method
		return Collections.unmodifiableList(this.allEffects);
	}
}
