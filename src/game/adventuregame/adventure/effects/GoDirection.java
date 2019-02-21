package game.adventuregame.adventure.effects;

import game.adventuregame.model.Location;
import game.adventuregame.model.Player;
import game.adventuregame.model.World;

/**
 * This class models GoDirection Effect.
 * <p>
 * This class is responsible for the movement of the player.
 * 
 * @author Shankar Ammai
 *
 */
public class GoDirection implements Effect {
	private String direction;

	/**
	 * This method creates a new GoDirection Effect given the name of the direction
	 * to go towards.
	 * 
	 * @param direction Direction to go towards.
	 */
	public GoDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * This method executes the GoDirection Effect given the player and the world.
	 * <p>
	 * If there is a location go in that particular direction then player goes in
	 * that location. Otherwise an informative message is shown.
	 * 
	 * @param player Player to play the game.
	 * @param world  The World where the game is to be played.
	 */
	@Override
	public void execute(Player player, World world) {
		Location location = player.getLocation();
		if (location.getAllDirections().contains(this.direction)) {
			Location newlocation = location.getNeighbour(this.direction);
			player.setLocation(newlocation);
			System.out.println("You are in " + newlocation.getName());
		} else {
			System.out.println("You cannot go " + this.direction);
		}

	}

}
