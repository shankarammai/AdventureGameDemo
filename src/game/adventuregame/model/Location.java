package game.adventuregame.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Models locations for the game.
 * <p>
 * A Location has a name, its description, direction and name of the neighbours,
 * list of items in the location.
 * 
 * @see Item
 * @author Shankar Ammai
 *
 */
public class Location {
	private String name;
	private String description;
	private Map<String, Location> neighbours;
	private List<Item> allItemsInThisLocation;
	private Location neighbour;

	/**
	 * Creates a new location with given name and description.
	 * <p>
	 * Newly created location will not have any neighbours and items.
	 * 
	 * @param name        name of the location.
	 * @param description Description of the location.
	 */
	public Location(String name, String description) {
		this.name = name;
		this.description = description;
		this.neighbours = new HashMap<>();
		this.allItemsInThisLocation = new ArrayList<>();
	}

	/**
	 * Returns the name of the location
	 * 
	 * @return The name of the location.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the description of the location.
	 * 
	 * @return The description of the location
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Adds a neighbour to a location providing direction and neighbour
	 * <p>
	 * User Should provide direction as {@code String} and neighbour as
	 * {@code location}, Neighbour is also another location.
	 * 
	 * @param direction Direction to the neighbour
	 * @param neighbour Neighbour of the location, Neighbour is location as well.
	 */
	public void addNeighbour(String direction, Location neighbour) {
		this.neighbours.put(direction, neighbour);

	}

	/**
	 * Returns neighbour providing the direction to the neighbour.
	 * 
	 * @param direction Direction to the neighbour
	 * @return neighbour, neighbour is another location as well.
	 */
	public Location getNeighbour(String direction) {
		if (this.neighbours.containsKey(direction)) {
			this.neighbour = this.neighbours.get(direction);
		}
		return this.neighbour;
	}

	/**
	 * Returns List of all directions that the location has neighbours to.
	 * 
	 * @return directions All the Direction which has neighbours to it.
	 */
	public Collection<String> getAllDirections() {
		Collection<String> directions = new ArrayList<>();
		for (String direction : this.neighbours.keySet()) {
			directions.add(direction);
		}
		return directions;
	}

	/**
	 * Returns all the items in the location.
	 * 
	 * @return All the items in the location.
	 */
	public List<Item> getItems() {
		return Collections.unmodifiableList(this.allItemsInThisLocation);
	}

	/**
	 * Adds a given item to the location.
	 * 
	 * @param item Item to be added to the location.
	 */
	public void addItem(Item item) {
		this.allItemsInThisLocation.add(item);
		item.setLocation(this);
	}

	/**
	 * Checks if the item is in the location or not .
	 * 
	 * @param item Item to check if it is in the location.
	 * @return If the item is present in the location or not.
	 */
	public boolean hasItem(Item item) {
		return this.allItemsInThisLocation.contains(item);
	}

	/**
	 * Removes a item from a location.
	 * 
	 * @param item Item to be removed from a location.
	 * @throws IllegalArgumentException If the item to be removed is not in that
	 *                                  location.
	 */
	public void removeItem(Item item) {
		if (this.allItemsInThisLocation.contains(item)) {
			this.allItemsInThisLocation.remove(item);
			item.setLocation(null);
		} else {
			throw new IllegalArgumentException();
		}
	}
}
