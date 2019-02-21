package game.adventuregame.adventure.effects;

import game.adventuregame.model.Item;
import game.adventuregame.model.Location;
import game.adventuregame.model.Player;
import game.adventuregame.model.World;

/**
 * Models a LookLocation Effect.
 * <p>
 * This class is responsible for displaying the information about the location.
 * 
 * @author Shankar
 *
 */
public class LookLocation implements Effect {
	/**
	 * This method executes LookLocation Effect.
	 * <p>
	 * When executed this method displays the name and the description of the
	 * player's location. Name of the items in that location and Directions that the
	 * player can go in.
	 * 
	 * @param player Player to play the game.
	 * @param world  The World where the game is to be played.
	 */
	@Override
	public void execute(Player player, World world) {
		Location location = player.getLocation();
		System.out.println(location.getDescription());
		System.out.print("Location : " + location.getName());
		if (!(location.getItems().isEmpty())) {
			System.out.print("\nThere is: ");
			for (Item item : location.getItems()) {
				System.out.print(item.getName());
				int totalItemsIndex = location.getItems().size() - 1;
				if (location.getItems().get(totalItemsIndex).equals(item)) {
					System.out.print(".");
				} else {
					System.out.print(", ");
				}
			}
		}
		if (!location.getAllDirections().isEmpty()) {
			System.out.print("\nYou can go : ");
			for (String direction : location.getAllDirections()) {
				System.out.print(direction + " \n");

			}
		}
	}

}
