package game.adventuregame.model;

/**
 * Models Items with given name and description for the game.
 * <p>
 * An Item has its name,description,location and portable status.
 * 
 * @author Shankar Ammai
 * @see Location
 */
public class Item {

	private String name;
	private String description;
	private Location location;
	private boolean isPortable;

	/**
	 * Creates an Item with given name and description
	 * <p>
	 * Creates an Item with given name and description then sets its location to
	 * {@code null} and portable status to {@code false}.
	 * 
	 * @param name        Name of the item
	 * @param description Description of the item
	 */
	public Item(String name, String description) {
		this.name = name;
		this.description = description;
		this.location = null;
		this.isPortable = false;
	}

	/**
	 * Returns the name of the item.
	 * 
	 * @return The Name of the Item
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the description of the item
	 * 
	 * @return The Description of the item
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Returns the location of the item.
	 * 
	 * @return The location location of the item.
	 */
	public Location getLocation() {
		return this.location;
	}

	/**
	 * Sets the location of the item
	 * 
	 * @param location New Location of the item.
	 */
	public void setLocation(Location location) {
		this.location = location;

	}

	/**
	 * Returns If the item is portable or not.
	 * <p>
	 * If the value is {@code true} then the item is portable. Otherwise Item is not
	 * portable.
	 * 
	 * @return if the Item is portable or not.
	 */
	public boolean isPortable() {
		return this.isPortable;
	}

	/**
	 * Sets the portable status of the item.
	 * <p>
	 * If {@code true} is provided as the parameter then the item is portable. If
	 * the parameter is {@code false} then item is not portable.
	 * 
	 * @param portable Portable status of the item.
	 */
	public void setPortable(boolean portable) {
		this.isPortable = portable;
	}
}
