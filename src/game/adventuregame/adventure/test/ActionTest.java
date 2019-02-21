package game.adventuregame.adventure.test;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Test;

import game.adventuregame.adventure.effects.Effect;
import game.adventuregame.adventure.effects.Message;
import game.adventuregame.model.Action;
import game.adventuregame.model.Item;
import game.adventuregame.model.Location;
import game.adventuregame.model.Player;

public class ActionTest {
	private final  Action useItem =new Action("use") ;
	@Test
	public void testGetName() {
		assertEquals("use",useItem.getName());
	}
	@Test 
	public void testIsAllowed() {
		Location street = new Location("street", "You are on the main street of the village.");
		Player player=new Player(street);
		assertTrue(useItem.isAllowed(player));
	}
	@Test
	public void testAddRequiredItem() {
		Location street = new Location("street", "You are on the main street of the village.");
		Player player=new Player(street);
		Item hammer=new Item ("hammer","this is a steel hammer");
		useItem.addRequiredItem(hammer);
		assertFalse(useItem.isAllowed(player));	
	}
	@Test
	public void testAddEffect() {
		Effect effect=new Message("You hit the clock with the hammer.");
		useItem.addEffect(effect);
		assertTrue(useItem.getEffects().contains(effect));
	}
	@Test
	public void testGetEffects() {
		assertEquals(Collections.emptyList(),useItem.getEffects());
	}
}
